package utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import com.google.common.util.concurrent.Uninterruptibles;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class represents the main functions of all pages
 * @author Shlomi
 */


public abstract class BaseFunctions {

	WebDriver driver;
	WebDriverWait wait;

	// constructor
	public BaseFunctions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	// function to navigate to URL
	public Boolean navigateToURL(String URL) {
		try{
			driver.navigate().to(URL);
			return true;
		} catch (Exception e) {
			System.out.println("Site was not loaded");
			return false;
		}
	}
	
	// function to get the current URL
	public String getURLCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	// function to click on element
	public Boolean clickOnElement(By elem) {
		try {
			driver.findElement(elem).click();
			return true;
		} catch (Exception e){
			System.out.println("element was not clicked");
			return false;
		}
	}
	
	// function to clear field and then type text
	public Boolean clearAndTypeTextToElem(By elem, String text) {
		try {
			WebElement textField = driver.findElement(elem);
			textField.clear();
			textField.sendKeys(text);
			return true;
		} catch (Exception e) {
			System.out.println("element was not clear and text was not send to");
			return false;
		}
	}

	// function to wait for element to be visible
	public Boolean waitForElementToBeVisible(By elem) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
			return true;
		} catch (Exception e) {
			System.out.println("wait for element to be visible was not worked correct");
			return false;
		}
	}

	// function to create folder
	public void createFolder(String folderName) throws IOException {
		File storageDirectory = new File(folderName);
		if (!storageDirectory.exists()) {
			if (!storageDirectory.mkdir()) {
				throw new IOException("Error creating directory.");
			}
		}
	}

	// function to take screenshot
	public Boolean takeScreenShot() {
		try{
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =((TakesScreenshot) getDriver());
			//Call getScreenshotAs method to create image file
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
			// take the tile and path
			String path = "C://Pictures//"+timestamp.getTime()+".png";
			//Move image file to new destination
			File DestFile = new File(path);
			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
			return true;
		} catch (Exception e) {
			System.out.println("No screenshot was made");
			return false;
		}

	}

}
