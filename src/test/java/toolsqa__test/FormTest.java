package toolsqa__test;

import config.AbstractTestConfigurationClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tools_pages.FormOP;

public class FormTest extends AbstractTestConfigurationClass {

    @BeforeMethod
    public void loadDriverPage() {
        webDriver.get("http://toolsqa.com/automation-practice-form/");
    }

    @Test
    public void shouldTestFormUsingOP() {
        new FormOP(waitDriver, webDriver)
                .populateFirstName("Wiktor")
                .populateLastName("Reliso")
                .chooseSex()
                .chooseExperience()
                .chooseProfession()
                .setDate("10-01-2011")
                .setCommand("Wait Commands")
                .setContinent("Europe")
                .populateAutomationTool()
                .uploadFile("upload.txt")
                .submitForm();
    }
}
