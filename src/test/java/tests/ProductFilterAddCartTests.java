package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import pages.ProductSearchPage;

public class ProductFilterAddCartTests {

    private WebDriver driver;
    private ProductSearchPage ProductSearch;



    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        ProductSearch = new ProductSearchPage(driver);
        driver.get("https://www.hepsiburada.com");
    }

    @Test
    public void hepsiburadaLoginTest() throws InterruptedException {

        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.searchBox));
        ProductSearch.clickWithJS(By.cssSelector(ProductSearch.searchBox));
        ProductSearch.writeInTheFieldByCss(ProductSearch.searchBox, "iPhone 17 Pro Max");
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.productSelect));
        ProductSearch.clickWithJS(By.cssSelector(ProductSearch.productSelect));
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.firstProduct));
        boolean isProductsVisible = ProductSearch.isElementDisplayed(By.cssSelector(ProductSearch.firstProduct));
        Assert.assertTrue(isProductsVisible, "Arama sonuçları görüntülenemedi!");
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.appleFilter));
        ProductSearch.clickWithJS(By.cssSelector(ProductSearch.appleFilter));
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.addToCartButton));
        ProductSearch.clickWithJS(By.cssSelector(ProductSearch.addToCartButton));
        ProductSearch.waitUntilTheElementAppears(By.xpath("//*[contains(text(),'Ürün sepetinizde')]"));
        ProductSearch.clickWithJS(By.cssSelector(ProductSearch.goToCart));
        }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
