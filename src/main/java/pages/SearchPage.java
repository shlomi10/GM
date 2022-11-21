package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseFunctions;

/**
 * this class represents the main page
 * @author Shlomi
 */

public class SearchPage extends BaseFunctions {

    // constructor
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    By searchField = By.xpath("//input[@id='searchboxinput']");
    String textToSearch = "Rome";
    By searchBTN = By.xpath("//button[@id='searchbox-searchbutton']");
    By zoomInBTN = By.xpath("//button[@id='widget-zoom-in']");
    By sideMenu = By.xpath("//div[@role='main']");

    // navigate to the site
    public Boolean getWebSite(String site) {
        return navigateToURL(site);
    }

    // search for text
    public Boolean searchText() {
        return clearAndTypeTextToElem(searchField, textToSearch);
    }

    // click the search button
    public Boolean clickSearch(){
        return clickOnElement(searchBTN);
    }

    // wait for page to load
    public Boolean waitForPageToBeLoad(){
        return waitForElementToBeVisible(sideMenu);
    }

    // take screenshot
    public Boolean takescreenShot(){
        return takeScreenShot();
    }

    // click the zoom in button
    public Boolean clickZoomIn(){
        return clickOnElement(zoomInBTN);
    }

}
