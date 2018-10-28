package tools_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPagesConfiguration;

public class MenuOP extends AbstractPagesConfiguration {

    @FindBy(xpath = "//ul[@id='primary-menu']/li[5]/a/span/span/span")
    private WebElement forum;

    @FindBy(xpath = "//ul[@id='primary-menu']/li[1]/a/span/span/span")
    private WebElement homePage;

    @FindBy(xpath = "//ul[@id='primary-menu']/li[8]/a/span/span/span")
    private WebElement demoSites;

    @FindBy(xpath = "//*[@id='primary-menu']//*[contains(text(), 'Automation Practice Form')]")
    private WebElement practiceForm;

    @FindBy(xpath = "//*[@id='primary-menu']//*[contains(text(), 'Automation Practice Table')]")
    private WebElement practiceTable;

    @FindBy(xpath = "//*[@id='primary-menu']//*[contains(text(), 'Alerts')]")
    private WebElement alertHandlingPage;

    @FindBy(css = "#primary-menu .menu-item-23300")
    private WebElement iFramePractice;

    @FindBy(css = "#primary-menu .menu-item-22593")
    private WebElement windowSwitchingPractice;


    public MenuOP(WebDriverWait waitDriver, WebDriver webDriver) {
        super(waitDriver, webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public MenuOP openHomePage() {
        waitUntilElementBeClickable(homePage)
                .click();
        return this;
    }

    public MenuOP expandDemoSites() {
        new Actions(webDriver)
                .moveToElement(waitUntilElementBeClickable(demoSites))
                .perform();
        return this;
    }

    public FormOP openPracticeFormPage() {
        waitUntilElementBeClickable(practiceForm)
                .click();
        return new FormOP(waitDriver, webDriver);
    }

    public AlerOP openAlertHandlingPage() {
        waitUntilElementBeClickable(alertHandlingPage)
                .click();
        return new AlerOP(waitDriver, webDriver);
    }

    public MenuOP openForumPage() {
        new Actions(webDriver).moveToElement(forum).perform();
        waitUntilElementBeClickable(forum)
                .click();
        return this;
    }

    public WindowTabOP openWindowSwitchingPage() {
        waitUntilElementBeClickable(windowSwitchingPractice)
                .click();
        return new WindowTabOP(waitDriver, webDriver);
    }

    public IFrameOP openIFramePage() {
        waitUntilElementBeClickable(iFramePractice)
                .click();
        return new IFrameOP(waitDriver, webDriver);
    }

    public TableOP openPracticeTablePage() {
        waitUntilElementBeClickable(practiceTable)
                .click();
        return new TableOP(waitDriver, webDriver);
    }
}
