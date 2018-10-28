package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *
 */
public class TableStructure {
    private String structure;
    private String country;
    private String city;
    private String height;
    private Integer buildYear;
    private Integer rank;

    public TableStructure(WebElement tabHead) {
        structure = tabHead.findElement(By.cssSelector("th")).getText();
        List<WebElement> tds = tabHead.findElements(By.cssSelector("td"));
        country = tds.get(0).getText();
        city = tds.get(1).getText();
        height = tds.get(2).getText();
        buildYear = Integer.parseInt(tds.get(3).getText());
        rank = Integer.parseInt(tds.get(4).getText());
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public Integer getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(Integer buildYear) {
        this.buildYear = buildYear;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TableStructure{");
        sb.append("structure='").append(structure).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", height='").append(height).append('\'');
        sb.append(", buildYear=").append(buildYear);
        sb.append(", rank=").append(rank);
        sb.append('}');
        return sb.toString();
    }
}