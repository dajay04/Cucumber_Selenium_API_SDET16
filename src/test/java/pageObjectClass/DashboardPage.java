package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class DashboardPage
{
    WebDriver driver;
    WaitHelper wait;

    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WaitHelper(driver);
    }

    @FindBy(xpath= "//a[@href='https://practicetestautomation.com/practice-test-login/']")
    WebElement logOutButton;

    public void logOutClick()
    {
        wait.waitTillElementCClickable(logOutButton,10);
        logOutButton.click();
    }
}
