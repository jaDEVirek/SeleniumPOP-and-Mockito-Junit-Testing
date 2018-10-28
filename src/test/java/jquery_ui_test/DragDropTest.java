package jquery_ui_test;

import config.AbstractTestConfigurationClass;
import jQuery_pages.DragDropPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragDropTest extends AbstractTestConfigurationClass {
    
    @BeforeMethod
    private void setUpDriver() {
        webDriver.get("https://jqueryui.com/droppable/");
    }

    @Test
    public void shouldTestDragNDropPage() {
        DragDropPage dragDopPage = new DragDropPage(waitDriver, webDriver, leftHorizontalMenuPage);
        System.out.println(dragDopPage.switchToContentFrame()
                .performDragAndDrop()
                .getPlaceHoldText());
    }
}
