package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import pages.ProductAddToCardPage;
import pages.ProductFilterPage;
import pages.ProductSearchPage;

public class ProductFilterAddCartTests {

    private WebDriver driver;
    private ProductSearchPage ProductSearch;
    private ProductFilterPage ProductFilter;
    private ProductAddToCardPage ProductAddToCard;



    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        ProductSearch = new ProductSearchPage(driver);
        ProductFilter = new ProductFilterPage(driver);
        ProductAddToCard = new ProductAddToCardPage(driver);
        driver.get("https://www.hepsiburada.com");
    }

    @Test
    public void hepsiburadaProductSearch() throws InterruptedException {

        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.searchBox));
        ProductSearch.clickWithJS(By.cssSelector(ProductSearch.searchBox));
        ProductSearch.writeInTheFieldByCss(ProductSearch.searchBox, "iPhone 17 Pro Max");
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.productSelect));
        ProductSearch.clickWithJS(By.cssSelector(ProductSearch.productSelect));
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.firstProduct));
        boolean isProductsVisible = ProductSearch.isElementDisplayed(By.cssSelector(ProductSearch.firstProduct));
        Assert.assertTrue(isProductsVisible, "Arama sonuçları görüntülenemedi!");


        }

    @Test
    public void hepsiburadaProductFilter() throws InterruptedException {

        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.searchBox));
        ProductSearch.clickWithJS(By.cssSelector(ProductSearch.searchBox));
        ProductSearch.writeInTheFieldByCss(ProductSearch.searchBox, "iPhone 17 Pro Max");
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.productSelect));
        ProductSearch.clickWithJS(By.cssSelector(ProductSearch.productSelect));
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.firstProduct));
        boolean isProductsVisible = ProductSearch.isElementDisplayed(By.cssSelector(ProductSearch.firstProduct));
        Assert.assertTrue(isProductsVisible, "Arama sonuçları görüntülenemedi!");
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductAddToCard.acceptCookies));
        ProductSearch.clickWithJS(By.cssSelector(ProductAddToCard.acceptCookies));
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductFilter.appleFilter));
        ProductSearch.clickWithJS(By.cssSelector(ProductFilter.appleFilter));

    }
    @Test
    public void hepsiburadaProductAddToCart() throws InterruptedException {

        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.searchBox));
        ProductSearch.clickWithJS(By.cssSelector(ProductSearch.searchBox));
        ProductSearch.writeInTheFieldByCss(ProductSearch.searchBox, "iPhone 17 Pro Max");
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.productSelect));
        ProductSearch.clickWithJS(By.cssSelector(ProductSearch.productSelect));
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductSearch.firstProduct));
        boolean isProductsVisible = ProductSearch.isElementDisplayed(By.cssSelector(ProductSearch.firstProduct));
        Assert.assertTrue(isProductsVisible, "Arama sonuçları görüntülenemedi!");
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductAddToCard.acceptCookies));
        ProductSearch.clickWithJS(By.cssSelector(ProductAddToCard.acceptCookies));
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductFilter.appleFilter));
        ProductSearch.clickWithJS(By.cssSelector(ProductFilter.appleFilter));
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductAddToCard.addToCartButton));
        WebElement element = driver.findElement(By.cssSelector(ProductAddToCard.addToCartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ProductSearch.clickWithJS(By.cssSelector(ProductAddToCard.addToCartButton));
        ProductSearch.waitUntilTheElementAppears(By.xpath("//*[contains(text(),'Ürün sepetinizde')]"));
        ProductSearch.clickWithJS(By.cssSelector(ProductAddToCard.goToCart));
        ProductSearch.waitUntilTheElementAppears(By.cssSelector(ProductAddToCard.successToast));
        String actualMessage = driver.findElement(By.cssSelector(ProductAddToCard.successToast)).getText();
        Assert.assertEquals(actualMessage, "Ürün sepete eklendi", "Başarı mesajı hatalı!");
    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
