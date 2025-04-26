package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper
{
    public WebDriver driver;

    public WaitHelper(WebDriver driver)
    {
        this.driver = driver;
    }

    public void waitTillElementVisible(WebElement element, long timeOutSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitTillElementCClickable(WebElement element, long timeOutSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
