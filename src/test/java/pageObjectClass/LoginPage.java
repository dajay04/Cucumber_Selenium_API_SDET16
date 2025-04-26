package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class LoginPage
{
    WebDriver driver;
    WaitHelper wait;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WaitHelper(driver);
    }

    @FindBy(id= "username")
    WebElement usernameField;
    @FindBy(name= "password")
    WebElement passwordField;
    @FindBy(xpath= "//button[@id='submit']")
    WebElement loginButton;
    @FindBy(xpath= "//div[@id='error']")
    WebElement errorText;

    public void enterUsername(String username)
    {
        wait.waitTillElementVisible(usernameField,10);
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password)
    {
        wait.waitTillElementVisible(passwordField,10);
        passwordField.sendKeys(password);
    }
    public void loginClick()
    {
        wait.waitTillElementCClickable(loginButton,10);
        loginButton.click();
    }
    public String errorTextMessage()
    {
        return errorText.getText();
    }
}
