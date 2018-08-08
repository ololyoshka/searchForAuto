package utils;

import com.codeborne.selenide.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertTrue;

public class BaseClass {

    private WebDriver driver;

    @BeforeClass
    public void setup()
    {
        Configuration.timeout = 10000;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // pass the driver to selenide
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().fullscreen();

    }

    @AfterClass
    public void quit()
    {
        driver.quit();
    }

    public void urlShouldContain (String path) {
        String currentURL = WebDriverRunner.url();
        assertTrue(
                String.format("url should contain %s but actuall full url is %s", path, currentURL),
                currentURL.contains(path)
        );
    }

}
