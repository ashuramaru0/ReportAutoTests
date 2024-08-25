package Report;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestBase {
    public static WebDriver driver;
    protected String env;
    protected String md;
    @BeforeClass(description = "Set up driver.")
    @Parameters({"environment", "browser", "mode"})
    public void preConditions(String environment, String browser, String mode){
        Configuration.timeout = 8000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        this.env = environment;
        this.md = mode;
        BrowserDriverFactory bdf = new BrowserDriverFactory();
        driver = bdf.createDriver(browser, environment, mode);


        WebDriverRunner.setWebDriver(driver);
    }

    public String getEnv(){
        return env;
    }
    public String getMode(){return md;};


    @AfterClass
    public void clearSelenideListener(){
        SelenideLogger.removeListener("AllureSelenide");
        WebDriverRunner.getWebDriver().quit();
    }
}
