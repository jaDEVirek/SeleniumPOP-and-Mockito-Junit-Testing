package toolsqa__test;

import config.AbstractTestConfigurationClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools_pages.IFrameOP;

public class IFrameTest extends AbstractTestConfigurationClass {

    @BeforeMethod
    public void loadDriverPage() {
        webDriver.get("http://toolsqa.com/");
    }
    
    @Test
    public void shouldTestIFramePage() throws InterruptedException {
        new IFrameOP(waitDriver, webDriver)
        .loadIFramePageFromMenu()
        .switchToFirstFrame()
        .clickFrameButton()
        .switchToSecondFrame()
        .clickSecondFrameButton();
    }
}
