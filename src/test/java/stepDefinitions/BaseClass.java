package stepDefinitions;

import org.openqa.selenium.WebDriver;
import pageObjectClass.DashboardPage;
import pageObjectClass.LoginPage;
import utils.ConfigReader;

public class BaseClass
{
    public WebDriver driver;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public static String BASE_URL;
    public static long randomNumber;

    public void setUp()
    {
        BASE_URL= ConfigReader.getProperty("reqURL");
        randomNumber = (long) (Math.random()*10000 + 33333300000L); // 1263126371273
    }
}
