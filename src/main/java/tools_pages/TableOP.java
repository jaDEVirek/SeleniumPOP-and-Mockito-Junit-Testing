package tools_pages;

import models.TableStructure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AbstractPagesConfiguration;

import java.util.ArrayList;
import java.util.List;

public class TableOP extends AbstractPagesConfiguration {

    private List<TableStructure> tableStructures;
    
    @FindBy(css = "table[summary='Sample Table'] tbody tr")
    private List<WebElement> tableBody;


    public TableOP(WebDriverWait waitDriver, WebDriver webDriver) {
        super(waitDriver, webDriver);
        this.tableStructures = new ArrayList<>();
        PageFactory.initElements(webDriver, this);
    }

    public TableOP fillTableWithData() {
        for (WebElement eL : tableBody) {
            tableStructures.add(new TableStructure(eL));
        }
        return this;
    }

    public TableOP fetchAndPrintData() {
        for (TableStructure tB : tableStructures) {
            System.out.println(tB.toString());
        }
        return this;
    }
}

