package pages;

import org.openqa.selenium.WebDriver;

public class ProductSearchPage extends Page {

    public final String searchBox = "input[data-test-id='search-bar-input']";
    public final String productSelect = "div[data-test-id='search-bar-suggestions-container']:nth-child(1)";
    public final String firstProduct = "li[class*='productListContent']:first-child";
    public final String appleFilter = "input[value='apple']";
    public final String addToCartButton = "button[id='addToCart']";
    public final String goToCart = "button[class*='checkoutui-ProductOnBasketHeader']";
    public final String acceptCookies = "button#onetrust-accept-btn-handler";


    public ProductSearchPage(WebDriver driver) {
        super(driver);
    }
}


