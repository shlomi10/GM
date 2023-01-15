package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;
import pages.SearchPage;

public class BaseTest implements ITestListener {

    WebDriver driver;
    SearchPage searchPage;

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void setup(String browser) {

        driver = new ChromeDriver();

        // maximize the browser window
        driver.manage().window().maximize();

        searchPage = new SearchPage(driver);

    }

    @AfterTest(alwaysRun = true)
    public void close() {
        driver.quit();

    }

}
