package jQuery_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPagesConfiguration;

public class DragDropPage extends AbstractPagesConfiguration {

    private LeftHorizontalMenuPage leftMenuPage;

    @FindBy(className = "demo-frame")
    private WebElement frame;

    @FindBy(id = "droppable")
    private WebElement dropable;

    @FindBy(id = "draggable")
    private WebElement draggableElement;

    private Actions actionProvider;

    public DragDropPage(WebDriverWait waitDriver, WebDriver webDriver, LeftHorizontalMenuPage lHpage) {
        super(waitDriver, webDriver);
        PageFactory.initElements(webDriver, this);
        actionProvider = new Actions(webDriver);
        leftMenuPage = lHpage;
    }

    public DragDropPage switchToContentFrame() {
        switchDriverToFrame(frame);
        return this;
    }

    public DragDropPage performDragAndDrop() {
        actionProvider.dragAndDrop(draggableElement, dropable).build().perform();
        return this;
    }

    public String getPlaceHoldText() {
        return waitUntilElementBeVisible(dropable)
                .getText();
    }
    public LeftHorizontalMenuPage goToLeftMenu() {
        return leftMenuPage;
    }

}
