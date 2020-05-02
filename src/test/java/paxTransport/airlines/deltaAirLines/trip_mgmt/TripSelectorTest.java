package paxTransport.airlines.deltaAirLines.trip_mgmt;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.inputBox.SelectAndVerifyDynamicDropDown.selectAndVerifyDynamicDropDown;

public class TripSelectorTest extends VerificationTest {
	@Parameters({"xpathTripTypeSelectorProp", "xpathTripTypeOptionSelectorProp"})
	@Test
	public static void selectOneWay(String xpathTripTypeSelectorProp, String xpathTripTypeOptionSelectorProp){
		selectAndVerifyDynamicDropDown(xpathTripTypeSelectorProp, xpathTripTypeOptionSelectorProp);
	}
}
