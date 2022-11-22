package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * this class represents the test runner
 * @author Shlomi
 */

public class MainRunner extends BaseTest {

	String siteURL = "https://maps.google.com/";

	@Test(priority = 1, description = "google maps test")
	public void assignmentTest() {
		searchPage.getWebSite(siteURL);
		searchPage.searchText();
		searchPage.clickSearch();
		searchPage.waitForPageToBeLoad();
		Assert.assertTrue(searchPage.makeScreenShot(),"Take screenshot didn't worked");
		Assert.assertTrue(searchPage.clickZoomIn(), "zoom didn't worked");
		Assert.assertTrue(searchPage.makeScreenShot(),"Take screenshot didn't worked");
		Assert.assertTrue(searchPage.clickZoomIn(), "zoom didn't worked");
		Assert.assertTrue(searchPage.makeScreenShot(),"Take screenshot didn't worked");
		Assert.assertTrue(searchPage.clickZoomIn(), "zoom isn't worked");
	}

}
