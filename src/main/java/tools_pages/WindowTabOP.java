package tools_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPagesConfiguration;

import java.util.ArrayList;
import java.util.List;

public class WindowTabOP extends AbstractPagesConfiguration {

    @FindBy(css = "button[onClick='newBrwWin()']")
    private WebElement browserButton;

    @FindBy(xpath = "//div[@id='content']/p[3]/button")
    private WebElement massageButton;

    @FindBy(xpath = "//div[@id='content']/p[4]/button")
    private WebElement browserTabButton;

    @FindBy(xpath = "//img[contains(@alt,'Selenium Tutorial in Java')]")
    private WebElement seleniumIcon;

    @FindBy(css = "body")
    private WebElement bodyTextArea;

    @FindBy(xpath = "//ul[@id='primary-menu']/li[6]/a/span/span")
    private WebElement forumLink;


    public WindowTabOP(WebDriverWait waitDriver, WebDriver webDriver) {
        super(waitDriver, webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public WindowTabOP handleBrowseButton() {
        waitUntilElementBeClickable(browserButton)
                .click();
        switchDriverToWindow(getWindowHandles().get(1));
        waitUntilElementBeVisible(seleniumIcon)
                .click();
        switchToDefaultAndCloseWindow();
        return this;
    }

    public WindowTabOP handleMassageButton() {
        waitUntilElementBeClickable(massageButton)
                .click();
        switchDriverToWindow(getWindowHandles().get(1));
        System.out.println(bodyTextArea.getText());
        switchToDefaultAndCloseWindow();
        return this;
    }

    public WindowTabOP handleBrowseTabButton() {
        waitUntilElementBeClickable(browserTabButton)
                .click();
        switchDriverToWindow(getWindowHandles().get(1));
        waitUntilElementBeClickable(forumLink)
                .click();
        switchToDefaultAndCloseWindow();
        return this;
    }

    private List<String> getWindowHandles() {
        return new ArrayList<>(webDriver.getWindowHandles());
    }

    private void switchToDefaultAndCloseWindow() {
        webDriver.close();
        switchDriverToWindow(getWindowHandles().get(0));
    }
}
