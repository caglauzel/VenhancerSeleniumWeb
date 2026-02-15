package pages;

import org.openqa.selenium.WebDriver;

public class ProductFilterPage extends Page {


    public final String appleFilter = "input[value='apple']";


    public ProductFilterPage(WebDriver driver) {
        super(driver);
    }
}


