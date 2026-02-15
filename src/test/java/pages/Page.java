package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {

    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }


    public void waitUntilTheElementAppears(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public void clickWithJS(By locator) {
        WebElement element = driver.findElement(locator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void writeInTheFieldByCss(String cssSelector, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(d -> {
            try {
                WebElement element = d.findElement(By.cssSelector(cssSelector));

                element.click();
                try {
                    element.clear();
                } catch (Exception e) {

                    ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].value='';", element);
                }

                element.sendKeys(text);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }


    public boolean isElementDisplayed(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}