package toolsqa__test;

import config.AbstractTestConfigurationClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools_pages.MenuOP;

public class WindowTest extends AbstractTestConfigurationClass {

    private MenuOP mainMenu;

    @BeforeMethod
    public void loadDriverPage() {
        webDriver.get("http://toolsqa.com/");
        mainMenu = new MenuOP(waitDriver, webDriver);
    }

    @Test
    public void shouldTestWindowTabs(){
        mainMenu.expandDemoSites()
                .openWindowSwitchingPage()
                .handleBrowseButton()
                .handleBrowseTabButton();

    }


}
