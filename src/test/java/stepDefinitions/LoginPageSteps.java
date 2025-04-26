package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectClass.DashboardPage;
import pageObjectClass.LoginPage;

import java.time.Duration;

public class LoginPageSteps extends BaseClass
{

    @Given("User launches Chrome Browser")
    public void user_launches_chrome_browser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage= new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @When("User open URL {string}")
    public void user_open_url(String url)
    {
            driver.get(url);
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String username, String password)
    {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks on Submit Button")
    public void user_clicks_on_submit_button()
    {
        loginPage.loginClick();
    }

    @Then("User verifies PageTitle should be {string}")
    public void user_verifies_page_title_should_be(String pageTitle)
    {
            Assert.assertEquals("Validation failed for Title",pageTitle,driver.getTitle());
    }

    @And("User closes browser")
    public void userClosesBrowser()
    {
        driver.quit();
    }

    @And("User clicks on Logout button")
    public void userClicksOnLogoutButton()
    {
        dashboardPage.logOutClick();
    }

    @Then("User verifies error message {string}")
    public void userVerifesErrorMessage(String error_message)
    {
        Assert.assertEquals("Error text is incorrect",error_message,loginPage.errorTextMessage());
    }
}
