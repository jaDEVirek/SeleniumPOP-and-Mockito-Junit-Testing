package tools_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPagesConfiguration;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class FormObjectPattern
 */
public class FormOP extends AbstractPagesConfiguration {

    @FindBy(css = "input[name='firstname']")
    private WebElement firstName;

    @FindBy(css = "input[name='lastname']")
    private WebElement lastName;

    @FindBy(id = "sex-0")
    private WebElement sex;

    @FindBy(name = "exp")
    private List<WebElement> expsList;

    @FindBy(css = "input[id='datepicker']")
    private WebElement datePicker;

    @FindBy(name = "tool")
    private List<WebElement> toolsList;

    @FindBy(id = "photo")
    private WebElement loadedFile;

    @FindBy(name = "selenium_commands")
    private WebElement command;

    @FindBy(name = "profession")
    private List<WebElement> proffesions;

    @FindBy(id = "continents")
    private WebElement continent;

    @FindBy(id = "submit")
    private WebElement submit;


    public FormOP(WebDriverWait waitDriver, WebDriver webDriver) {
        super(waitDriver, webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public FormOP populateFirstName(String fName) {
        firstName.sendKeys(fName);
        return this;
    }

    public FormOP populateLastName(String lName) {
        lastName.sendKeys(lName);
        return this;
    }

    public FormOP chooseSex() {
        sex.click();
        return this;
    }

    public FormOP chooseExperience() {
        this.expsList.get(new Random().nextInt(6))
                .click();
        return this;
    }

    public FormOP chooseProfession() {
        for (WebElement webEl : proffesions) {
            if (webEl.getAttribute("value")
                    .equalsIgnoreCase(this.generateRandomProfession())) {
                webEl.click();
            }
        }
        return this;
    }

    public FormOP uploadFile(String resource) {
        loadedFile.sendKeys( new File(getClass()
                .getClassLoader()
                .getResource(resource)
                .getFile())
                .getAbsolutePath());
        return this;
    }

    public FormOP setDate(String date) {
        datePicker.sendKeys(date);
        return this;
    }

    public FormOP setCommand(String sCommand) {
        Select commandHandler = new Select(command);
        for (WebElement webElement : commandHandler.getOptions()) {
            if (webElement.getText().equalsIgnoreCase(sCommand)) {
                webElement.click();
                break;
            }
        }
        return this;
    }

    public FormOP populateAutomationTool() {
        toolsList.stream()
                .filter(t -> t.getAttribute("value").equalsIgnoreCase("Selenium Webdriver") || t.getAttribute("value").equalsIgnoreCase("Selenium IDE"))
                .collect(Collectors.toList())
                .forEach(WebElement::click);
        return this;
    }

    public FormOP setContinent(String cont) {
        new Select(continent).selectByVisibleText(cont);
        return this;
    }

    public FormOP submitForm() {
        submit.click();
        return this;
    }

    private String generateRandomProfession() {
        int i = new Random().nextInt(15) + 1;
        return i >= 8 ? "Automation Tester" : "Manual Tester";
    }
}
