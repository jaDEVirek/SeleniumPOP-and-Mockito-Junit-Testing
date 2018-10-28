package tools_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPagesConfiguration;

public class IFrameOP extends AbstractPagesConfiguration {

    @FindBy(xpath = "//ul[@id='primary-menu']/li[7]/a/span/span/span")
    private WebElement demoSiteLabel;

    @FindBy(xpath = "//ul[@id='primary-menu']/li[7]/ul/li[7]/a/span/span")
    private WebElement iFramePage;

    @FindBy(id = "IF1")
    private WebElement firstFrame;

    @FindBy(id = "IF2")
    private WebElement secondFrame;

    @FindBy(id = "submit")
    private WebElement frameSubmit;

    @FindBy(xpath = "//div[@id='primary']/main/article/footer/p/a")
    private WebElement frameReadButton;

    public IFrameOP(WebDriverWait waitDriver, WebDriver webDriver) {
        super(waitDriver, webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public IFrameOP loadIFramePageFromMenu() {
        waitUntilElementBeVisible(demoSiteLabel)
                .click();
        waitUntilElementBeClickable(iFramePage)
                .click();
        return this;
    }

    public IFrameOP switchToFirstFrame() throws InterruptedException {
        switchDriverToFrame(waitUntilElementBeVisible(firstFrame));
        return this;
    }

    public IFrameOP clickFrameButton() {
        waitUntilElementBeClickable(frameSubmit)
                .click();
        return this;
    }

    public IFrameOP switchToSecondFrame() {
        switchDriverToDefaultContent();
        switchDriverToFrame(secondFrame);
        return this;
    }

    public IFrameOP clickSecondFrameButton() {
        waitUntilElementBeClickable(frameReadButton)
                .click();
        switchDriverToDefaultContent();
        return this;
    }
}
