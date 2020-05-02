package paxTransport.commonWebSiteFeatures.resultsPage;

import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayed;

public class LoadAndCheckResultsPage {
	public static boolean doesResultPageAppear(String xpathResultsPageNoResultsFoundCommonElemProp, String xpathResultsPageFlightsFoundCommonElemProp) {
		if (checkIfElementIsDisplayed(xpathResultsPageNoResultsFoundCommonElemProp)) {
			System.out.println("Results page loaded successfully but no available flights were found");
		} else if (checkIfElementIsDisplayed(xpathResultsPageFlightsFoundCommonElemProp)) {
			System.out.println("Results page loaded successfully, flights found");
		} else {
			System.out.println("Something has gone wrong, results page failed to load up. Quitting test.");
		} //checks to see if the results page loads up. There are two versions: Flights found and flights not found. If neither are loaded, test will fail with the below statement, which checks if either one of these are displayed.
		return (checkIfElementIsDisplayed(xpathResultsPageNoResultsFoundCommonElemProp) || checkIfElementIsDisplayed(xpathResultsPageFlightsFoundCommonElemProp)); //because this checks for both, and fails one, the exception handling cause a slowdown in the test. An ideal solution would be if both versions of the results page had a common element that was not present in the start page.
	}
}
