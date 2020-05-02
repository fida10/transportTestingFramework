package paxTransport.airlines.deltaAirLines.trip_mgmt;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static paxTransport.commonWebSiteFeatures.resultsPage.LoadAndCheckResultsPage.doesResultPageAppear;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayed;

public class CheckResultsPageTest { //no verification test extended here as the results page is a brand new page from home.
	@Parameters({"xpathResultsPageNoResultsFoundProp", "xpathResultsPageFlightsFoundProp"})
	@Test
	public static void resultsPageAppearsTest(String xpathResultsPageNoResultsFoundProp, String xpathResultsPageFlightsFoundProp){
		Assert.assertTrue(doesResultPageAppear(xpathResultsPageNoResultsFoundProp, xpathResultsPageFlightsFoundProp));
	}
}