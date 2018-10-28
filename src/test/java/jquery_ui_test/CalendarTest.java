package jquery_ui_test;

import config.AbstractTestConfigurationClass;
import jQuery_pages.CalendarPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CalendarTest extends AbstractTestConfigurationClass {

    @BeforeMethod
    void getDriverPage() {
        webDriver.get("https://jqueryui.com/datepicker/");
    }

    @Test(dataProvider = "dateParameters")
    public void shouldFindDate(String dates) throws InterruptedException {
        new CalendarPage(waitDriver, webDriver, leftHorizontalMenuPage)
                .switchToFrame()
                .openDateCalendar()
                .setDateInCalendar(dates)
                .fillTheCalendar();
    }

    @DataProvider(name = "dateParameters")
    public Object[] dateParametersProvider() {
        String format = DateTimeFormatter.ofPattern("dd.MM.yyyy").format(LocalDateTime.now());
        Object[] dates = new Object[5];
        dates[0] = "01.02.2019";
        dates[1] = "27.12.2018";
        dates[2] = format;
        dates[3] = "06.07.2018";
        dates[4] = "20.11.2017";
        return dates;
    }
}
