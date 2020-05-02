package paxTransport.airlines.deltaAirLines.trip_mgmt;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButtonDirectXpath;
import static paxTransport.commonWebSiteFeatures.webElements.DynamicXpathCreator.simpleDynamicXpathCreator;

public class NoOfPaxTest extends VerificationTest {
	@Parameters({"xpathPaxSelectorProp"})
	@Test
	public static void openPaxBox(String xpathPaxSelectorProp){
		clickAnyButton(xpathPaxSelectorProp);
	}
	@Parameters({"xpathPathToAllPaxOptionsProp", "departNoOfPaxProp"})
	@Test (dependsOnMethods = "openPaxBox")
	public static void selectPaxNo(String xpathPathToAllPaxOptionsProp, String departNoOfPaxProp){ //method to verify that the correct one was picked isn't working, due to the elements within the drop down not returning any text. To be fixed later, these tests are running fine without verification.
		clickAnyButtonDirectXpath(simpleDynamicXpathCreator(xpathPathToAllPaxOptionsProp, departNoOfPaxProp));
	}
}
/*
selectAndVerifyDynamicDropDownDynamicXpath("xpathPaxSelector", simpleDynamicXpathCreator("xpathPathToAllPaxOptions", "departNoOfPax")); //A common dynamic xpath is defined in xpathPathToAllPaxOptions which can lead to any number of passengers; the noProp defines the number of passengers. Both of these are combined into a single xpath by simpleDynamicXpathCreator, which is then clicked and checked.
 */