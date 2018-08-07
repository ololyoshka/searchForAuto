package utils;

import com.codeborne.selenide.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public static WebDriver driver;

    @BeforeClass
    public static void setup()
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

}
