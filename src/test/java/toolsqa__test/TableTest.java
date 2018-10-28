package toolsqa__test;

import config.AbstractTestConfigurationClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools_pages.TableOP;

public class TableTest extends AbstractTestConfigurationClass {
    @BeforeMethod
    public void loadDriverPage() {
        webDriver.get("http://toolsqa.com/automation-practice-table/");
    }

    @Test
    public void shouldFetchAndPrintData() {
        new TableOP(waitDriver, webDriver)
                .fillTableWithData()
                .fetchAndPrintData();
    }
}

