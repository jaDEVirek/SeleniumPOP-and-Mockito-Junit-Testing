package config;

import jQuery_pages.LeftHorizontalMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.Objects;

/**
 * Global Configuration class for tests
 * Basic using Chrome browser
 */
public abstract class AbstractTestConfigurationClass {

    protected WebDriver webDriver;
    protected WebDriverWait waitDriver;
    protected LeftHorizontalMenuPage leftHorizontalMenuPage;

    @BeforeMethod
    public void setupChromeDriverWithOptions() {
        System.setProperty("webdriver.chrome.driver", getAbsoluteVariablePath());
        ChromeOptions chromeOptions = new ChromeOptions()
                .addArguments("start-maximized")
                .addArguments("disable-extensions");
        webDriver = new ChromeDriver(chromeOptions);
        waitDriver = new WebDriverWait(webDriver, 10);
        leftHorizontalMenuPage = new LeftHorizontalMenuPage(new WebDriverWait(webDriver, 10), webDriver);
    }

    private String getAbsoluteVariablePath() {
        return new File(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource("chromedriver.exe"))
                .getFile())
                .getAbsolutePath();
    }

    @AfterMethod
    public void closeCurrentWindowDriver() {
        webDriver.quit();
    }
}
