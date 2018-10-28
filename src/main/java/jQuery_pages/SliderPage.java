package jQuery_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPagesConfiguration;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SliderPage extends AbstractPagesConfiguration {

    LeftHorizontalMenuPage leftMenuPage;

    @FindBy(className = "demo-frame")
    private WebElement frame;
    @FindBy(id = "custom-handle")
    private WebElement slider;


    public SliderPage(WebDriverWait waitDriver, WebDriver webDriver, LeftHorizontalMenuPage leftMenuPage) {
        super(waitDriver, webDriver);
        this.leftMenuPage = leftMenuPage;
        PageFactory.initElements(webDriver, this);
    }


    public SliderPage switchDriverToFrame(){
        switchDriverToFrame(frame);
        return this;
    }
    public SliderPage performStepsSliderAction(int step1, int step2, int step3) {
        for (Integer inT : new PriorityQueue<>(Arrays.asList(step1, step2, step3))) {
            if (Integer.valueOf(slider.getText()) > inT) {
                performActionDown(inT, slider);
            } else if (Integer.valueOf(slider.getText()).equals(inT)) {
            } else {
                performActionUp(inT, slider);
            }
        }
        return this;
    }

    private void performActionUp(Integer value, WebElement slider) {
        while (!Integer.valueOf(slider.getText()).equals(value)) {
            waitUntilElementBeVisible(slider).sendKeys(Keys.ARROW_UP);
        }
    }

    private void performActionDown(Integer value, WebElement slider) {
        while (!Integer.valueOf(slider.getText()).equals(value)) {
            waitUntilElementBeVisible(slider).sendKeys(Keys.ARROW_DOWN);
        }
    }

    public LeftHorizontalMenuPage goToLeftMenu() {
        return leftMenuPage;
    }
}
