package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import stepDefinitions.BaseClass;

@RunWith(Cucumber.class)
@CucumberOptions
        (
            features = "src/main/resources/Features",
            glue = "stepDefinitions",
            tags = "@regression",
            monochrome = true,// it will remove unneccsary characters in console window
            dryRun = false, // It will not run in actual
            plugin = {"pretty","html:target/cucumber-reports.html"}
        )
public class TestRunner
{
        @BeforeClass
        public static void globalSetup()
        {
                // Create an instance of Base Class where setup and random no generated
                BaseClass obj = new BaseClass();

                // Calling methods
                obj.setUp();
                System.out.println(obj.toString());
        }
}
