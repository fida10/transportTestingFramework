package paxTransport.commonWebSiteTests.trip_mgmt;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static paxTransport.commonWebSiteFeatures.resultsPage.LoadAndCheckResultsPage.doesResultPageAppear;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayed;

public class CheckResultsPageTest { //no verification test extended here as the results page is a brand new page from home.
	@Test
	public static void resultsPageAppearsTest(String xpathResultsPageNoResultsFound, String xpathResultsPageFlightsFound){
		Assert.assertTrue(doesResultPageAppear(xpathResultsPageNoResultsFound, xpathResultsPageFlightsFound));
	}
}