package paxTransport.airlines.deltaAirLines.trip_mgmt;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.inputBox.SelectAndVerifyDynamicDropDown.selectAndVerifyDynamicDropDown;
import static paxTransport.commonWebSiteFeatures.webElements.ScrollToWebElement.scrollToElement;

public class TripSelectorTest extends VerificationTest {
	@Parameters({"xpathTripTypeOptionSelectorProp"})
	@Test
	public static void selectTripTypeButton(String xpathTripTypeOptionSelectorProp){ //this method is for if the trip type is a radio button or just a button.
		clickAnyButton(xpathTripTypeOptionSelectorProp);
	}
	@Parameters({"xpathTripTypeSelectorProp", "xpathTripTypeOptionSelectorProp"})
	@Test
	public static void selectTripTypeDropDown(String xpathTripTypeSelectorProp, String xpathTripTypeOptionSelectorProp){ //this method is for if the trip type to select is in a drop down
		selectAndVerifyDynamicDropDown(xpathTripTypeSelectorProp, xpathTripTypeOptionSelectorProp);
	}
}
