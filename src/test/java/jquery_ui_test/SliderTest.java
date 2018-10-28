package jquery_ui_test;

import config.AbstractTestConfigurationClass;
import jQuery_pages.SliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends AbstractTestConfigurationClass {


    @BeforeMethod
    public void loadDriverPage() {
        webDriver.get("https://jqueryui.com/slider/#custom-handle");
    }

    @Test
    public void shouldTestAlertPage() {
        new SliderPage(waitDriver, webDriver, leftHorizontalMenuPage)
                .switchDriverToFrame()
                .performStepsSliderAction(50, 80, 60);
    }
}
