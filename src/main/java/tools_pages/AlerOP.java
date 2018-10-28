package tools_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPagesConfiguration;

import java.util.Random;

/**
 * Class represents Alert as page object pattern
 *
 * @see <a href="http://toolsqa.com/handling-alerts-using-selenium-webdriver/">Handling Alerts</a>
 */
public class AlerOP extends AbstractPagesConfiguration {

    @FindBy(xpath = "//*[@id='content']/p[4]/button")
    private WebElement basicAlert;

    @FindBy(xpath = "//button[contains(text(),'Confirm Pop up')]")
    private WebElement confirmAlert;

    @FindBy(xpath = "//button[contains(text(),'Prompt Pop up')]")
    private WebElement promptAlert;


    public AlerOP(WebDriverWait waitDriver, WebDriver webDriver) {
        super(waitDriver, webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public AlerOP handleBasicAlert() {
        waitUntilElementBeClickable(basicAlert)
                .click();
        waitBeforeHandlingAlert()
                .accept();
        return this;
    }

    public AlerOP handleConfirmAlert() {
        waitUntilElementBeClickable(confirmAlert)
                .click();
        if (new Random().nextInt(10) > 5) {
            waitBeforeHandlingAlert().dismiss();
        } else {
            waitBeforeHandlingAlert().accept();
        }
        return this;
    }

    public AlerOP handlePromptAlert(String choice){
        waitUntilElementBeClickable(promptAlert)
                .click();
        waitBeforeHandlingAlert()
                .sendKeys(choice);
        waitBeforeHandlingAlert().
                accept();
        return this;
    }
}
