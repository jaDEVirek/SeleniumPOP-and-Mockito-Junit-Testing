package toolsqa__test;

import config.AbstractTestConfigurationClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools_pages.AlerOP;

public class AlertTest extends AbstractTestConfigurationClass {

    @BeforeMethod
    private void setUpDriver() {
        webDriver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
    }

    @Test
    public void handleAllPageAlert() {
        new AlerOP(waitDriver, webDriver)
                .handleBasicAlert()
                .handleConfirmAlert()
                .handlePromptAlert("no");
    }
}
