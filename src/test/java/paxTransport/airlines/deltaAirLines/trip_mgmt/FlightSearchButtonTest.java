package paxTransport.airlines.deltaAirLines.trip_mgmt;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;

public class FlightSearchButtonTest extends VerificationTest {
	@Parameters({"xpathSearchButtonProp"})
	@Test
	public static void clickFlightSearchButton(String xpathSearchButtonProp){
		clickAnyButton(xpathSearchButtonProp);
	}
}
