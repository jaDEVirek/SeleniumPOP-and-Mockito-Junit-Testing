package utils;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPagesConfiguration {

    protected WebDriverWait waitDriver;
    protected WebDriver webDriver;

    public AbstractPagesConfiguration(WebDriverWait waitDriver, WebDriver webDriver) {
        this.waitDriver = waitDriver;
        this.webDriver = webDriver;
    }

    protected WebElement waitUntilElementBeClickable(WebElement webElement) {
        return waitDriver.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected List<WebElement> waitUntilElementsBeVisible(List<WebElement> webElements) {
        return waitDriver.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    protected WebElement waitUntilElementBeVisible(WebElement webElement) {
        return waitDriver.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected Alert waitBeforeHandlingAlert() {
        return waitDriver.until(ExpectedConditions.alertIsPresent());
    }

    protected void switchDriverToFrame(WebElement frame) {
        webDriver.switchTo().frame(frame);
    }

    protected void switchDriverToDefaultContent() {
        webDriver.switchTo().defaultContent();
    }

    protected void switchDriverToWindow(String handleName) {
        webDriver.switchTo().window(handleName);
    }
}

