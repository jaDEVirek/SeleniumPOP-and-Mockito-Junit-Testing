package jQuery_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPagesConfiguration;

public class TopMenuPage extends AbstractPagesConfiguration {


    LeftHorizontalMenuPage leftMenuPage;

    private final String xPathPath = "//*[@id=\"menu-top\"]/";
    private Actions actionProvider;

    @FindBy(xpath = xPathPath + "li[1]/a")
    private WebElement demos;

    @FindBy(xpath = xPathPath + "li[2]/a")
    private WebElement download;

    @FindBy(xpath = xPathPath + "li[3]/a")
    private WebElement apiDocument;

    @FindBy(xpath = xPathPath + "li[4]/a")
    private WebElement themes;

    @FindBy(xpath = xPathPath + "li[5]/a")
    private WebElement development;

    @FindBy(xpath = xPathPath + "li[6]/a")
    private WebElement support;

    @FindBy(xpath = xPathPath + "li[7]/a")
    private WebElement blog;

    @FindBy(xpath = xPathPath + "li[8]/a")
    private WebElement about;

    @FindBy(xpath = "//form//input[@name='s']")
    private WebElement searchArea;

    @FindBy(xpath = "//form//button")
    private WebElement submitBtn;

    public TopMenuPage(WebDriverWait waitDriver, WebDriver webDriver, LeftHorizontalMenuPage menuPage) {
        super(waitDriver, webDriver);
        leftMenuPage = menuPage;
        actionProvider = new Actions(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public TopMenuPage searchInBrowser(String text) {
        actionProvider.moveToElement(searchArea).perform();
        waitUntilElementBeVisible(searchArea)
                .sendKeys(text);
        waitUntilElementBeClickable(submitBtn)
                .click();
        return this;
    }

    public TopMenuPage goToDownload() {
        waitUntilElementBeClickable((WebElement) actionProvider.moveToElement(download))
                .click();
        return this;
    }

    public TopMenuPage goToAboutPage() {
        waitUntilElementBeClickable((WebElement) actionProvider.moveToElement(about))
                .click();
        return this;
    }

    public TopMenuPage goToSupportPage() {
        waitUntilElementBeClickable((WebElement) actionProvider.moveToElement(support))
                .click();
        return this;
    }

    public TopMenuPage goToApiDocument() {
        actionProvider.moveToElement(apiDocument).perform();
        waitUntilElementBeClickable(apiDocument)
                .click();
        return this;
    }

    public TopMenuPage goToThemes() {
        waitUntilElementBeClickable((WebElement) actionProvider.moveToElement(themes))
                .click();
        return this;
    }

    public TopMenuPage goToDevelopmentPage() {
        waitUntilElementBeClickable((WebElement) actionProvider.moveToElement(development))
                .click();
        return this;
    }

    public TopMenuPage goToDemos() {
        waitUntilElementBeClickable((WebElement) actionProvider.moveToElement(demos))
                .click();
        return this;
    }

    public TopMenuPage goToBlog() {
        waitUntilElementBeClickable((WebElement) actionProvider.moveToElement(blog))
                .click();
        return this;
    }

    public LeftHorizontalMenuPage goToLeftMenu() {
        return leftMenuPage;
    }
}
