package jQuery_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPagesConfiguration;

public class LeftHorizontalMenuPage extends AbstractPagesConfiguration {

    @FindBy(xpath = "//a[contains(text(), 'Droppable')]")
    private WebElement droppable;

    @FindBy(xpath = "//*[@id='sidebar']//a[contains(text(), 'Slider')]")
    private WebElement slider;

    @FindBy(xpath = "//*[@id='sidebar']//a[contains(text(), 'Datepicker')]")
    private WebElement datePicker;

    public LeftHorizontalMenuPage(WebDriverWait waitDriver, WebDriver webDriver) {
        super(waitDriver, webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public DragDropPage goToDroppable() {
        waitUntilElementBeClickable(droppable)
                .click();
        return new DragDropPage(waitDriver, webDriver, new LeftHorizontalMenuPage(waitDriver, webDriver));
    }

    public SliderPage goToSlider() {
        waitUntilElementBeClickable(slider)
                .click();
        return new SliderPage(waitDriver, webDriver, new LeftHorizontalMenuPage(waitDriver, webDriver));
    }

    public CalendarPage goToDatePicker() {
        waitUntilElementBeClickable(datePicker)
                .click();
        return new CalendarPage(waitDriver, webDriver, new LeftHorizontalMenuPage(waitDriver, webDriver));
    }
}
