package pages;

import org.openqa.selenium.WebDriver;

public class ProductAddToCardPage extends Page {



    public final String addToCartButton = "button[id='addToCart']";
    public final String goToCart = "button[class*='checkoutui-ProductOnBasketHeader']";
    public final String acceptCookies = "button#onetrust-accept-btn-handler";
    public final String successToast = "div.hb-toast-text";


    public ProductAddToCardPage(WebDriver driver) {
        super(driver);
    }
}


