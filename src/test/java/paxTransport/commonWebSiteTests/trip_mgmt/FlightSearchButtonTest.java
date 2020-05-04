package paxTransport.commonWebSiteTests.trip_mgmt;

import org.testng.annotations.Test;
import paxTransport.commonWebSiteTests.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;

public class FlightSearchButtonTest extends VerificationTest {
/*	@Test (priority = 0)
	public static void nextWebElementPointerOne(String xpathSearchButton){
		nextWebElement = convertToWebElement(xpathSearchButton);
	} /*A common web element. A nextWebElementPointer method will set this as the first webElement used for the next test. @BeforeMethods can then be used to run various actions on the element, i.e. check it's visibility, if it is enabled, scroll to it, etc.
	 It is set to commonElementOnAllWebSites which points to //html. This is a common element present on every website, and it also ensures that nullpointerexception is avoided.*/
	@Test (priority = 1)
	public static void clickFlightSearchButton(){
		clickAnyButton("xpathSearchButton");
	}
}
