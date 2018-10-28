package jQuery_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPagesConfiguration;

import java.util.Arrays;
import java.util.List;

public class CalendarPage extends AbstractPagesConfiguration {

    private LeftHorizontalMenuPage leftMenuPage;

    @FindBy(css = "#content iframe")
    private WebElement frame;

    @FindBy(id = "datepicker")
    private WebElement dataPicker;

    @FindBy(className = "ui-datepicker-month")
    private WebElement calMonth;

    @FindBy(className = "ui-datepicker-year")
    private WebElement calYear;

    @FindBy(xpath = ".//*[@id='ui-datepicker-div']/div/a[2]/span")
    private WebElement arrowToRight;

    @FindBy(xpath = ".//*[@id='ui-datepicker-div']/div/a[1]/span")
    private WebElement arrowToLeft;

    @FindBy(css = "tbody tr td")
    private List<WebElement> daysList;

    private int expMonth;
    private String expDay;
    private int expYear;

    public CalendarPage(WebDriverWait waitDriver, WebDriver webDriver, LeftHorizontalMenuPage leftMenuPage) {
        super(waitDriver, webDriver);
        PageFactory.initElements(webDriver, this);
        this.leftMenuPage = leftMenuPage;
    }


    public CalendarPage switchToFrame() {
        switchDriverToFrame(frame);
        return this;
    }

    public CalendarPage openDateCalendar() {
        dataPicker.click();
        return this;
    }

    public CalendarPage setDateInCalendar(String date) {
        expMonth = Integer.parseInt(date.substring(3, 5));
        expYear = Integer.parseInt(date.substring(6));
        expDay = date.substring(0, 2);
        return this;
    }

    public CalendarPage fillTheCalendar() throws InterruptedException {
        boolean dateNotFound = true;
        while (dateNotFound) {
            String cM = waitUntilElementBeVisible(calMonth).getText();
            String cY = waitUntilElementBeVisible(calYear).getText();

            if (getMonthsAsNumber(cM) == expMonth && (expYear == Integer.parseInt(cY))) {
                findDayByGivenDate(Integer.parseInt(expDay));
                dateNotFound = false;
            } else if (getMonthsAsNumber(cM) < expMonth && (expYear == Integer.parseInt(cY)) || expYear > Integer.parseInt(cY)) {
                waitUntilElementBeClickable(arrowToRight).click();
            } else if (getMonthsAsNumber(cM) > expMonth && (expYear == Integer.parseInt(cY)) || expYear < Integer.parseInt(cY)) {
                waitUntilElementBeClickable(arrowToLeft).click();
            }
        }
        Thread.sleep(2000);
        return this;
    }

    private void findDayByGivenDate(Integer date) {
        waitUntilElementsBeVisible(daysList)
                .parallelStream()
                .filter(cell -> cell.getText().equals(String.valueOf(date)))
                .findAny()
                .ifPresent(WebElement::click);
    }

    private int getMonthsAsNumber(String month) {
        return Arrays.asList("January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December")
                .indexOf(month) + 1;
    }

    public LeftHorizontalMenuPage goToLeftMenu() {
        return leftMenuPage;
    }
}
