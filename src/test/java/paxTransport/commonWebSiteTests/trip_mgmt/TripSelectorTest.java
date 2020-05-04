package paxTransport.commonWebSiteTests.trip_mgmt;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paxTransport.commonWebSiteTests.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.inputBox.SelectAndVerifyDynamicDropDown.selectAndVerifyDynamicDropDown;

public class TripSelectorTest extends VerificationTest {
/*	@Parameters({"xpathTripTypeOptionSelector"})
	@Test (priority = 0)
	public static void nextWebElementPointerOne(String xpathTripTypeOptionSelector){
		nextWebElement = convertToWebElement(xpathTripTypeOptionSelector);
	} /*A common web element. A nextWebElementPointer method will set this as the first webElement used for the next test. @BeforeMethods can then be used to run various actions on the element, i.e. check it's visibility, if it is enabled, scroll to it, etc.
	 It is set to commonElementOnAllWebSites which points to //html. This is a common element present on every website, and it also ensures that nullpointerexception is avoided.*/
	@Parameters({"xpathTripTypeOptionSelector"})
	@Test
	public static void selectTripTypeButton(String xpathTripTypeOptionSelector){ //this method is for if the trip type is a radio button or just a button.
		clickAnyButton(xpathTripTypeOptionSelector);
	}
/*	@Parameters({"xpathTripTypeSelector"})
	@Test (priority = 0)
	public static void nextWebElementPointerTwo(String xpathTripTypeSelector){
		nextWebElement = convertToWebElement(xpathTripTypeSelector);
	} */
	@Parameters({"xpathTripTypeSelector", "xpathTripTypeOptionSelector"})
	@Test
	public static void selectTripTypeDropDown(String xpathTripTypeSelector, String xpathTripTypeOptionSelector){ //this method is for if the trip type to select is in a drop down
		selectAndVerifyDynamicDropDown(xpathTripTypeSelector, xpathTripTypeOptionSelector);
	}
}
