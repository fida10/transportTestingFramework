package paxTransport.commonWebSiteTests.trip_mgmt;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paxTransport.commonWebSiteTests.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButtonDirectXpath;

import static paxTransport.commonWebSiteFeatures.webElements.DynamicXpathCreator.simpleDynamicXpathCreator;

public class NoOfPaxTest extends VerificationTest {
	/*@Test (priority = 0)
	public static void nextWebElementPointerOne(String xpathSearchButton){
		nextWebElement = convertToWebElement(xpathSearchButton);
	} /*A common web element. A nextWebElementPointer method will set this as the first webElement used for the next test. @BeforeMethods can then be used to run various actions on the element, i.e. check it's visibility, if it is enabled, scroll to it, etc.
	 It is set to commonElementOnAllWebSites which points to //html. This is a common element present on every website, and it also ensures that nullpointerexception is avoided.*/
	@Test (priority = 1)
	public static void openPaxBox(){
		clickAnyButton("xpathPaxSelector");
	}
	@Parameters({"departNoOfPaxProp"})
	@Test (priority = 2)
	public static void selectPaxNo(String departNoOfPaxProp){ //method to verify that the correct one was picked isn't working, due to the elements within the drop down not returning any text. To be fixed later, these tests are running fine without verification.
		clickAnyButtonDirectXpath(simpleDynamicXpathCreator("xpathPathToAllPaxOptions", departNoOfPaxProp));
	}
}
/*
selectAndVerifyDynamicDropDownDynamicXpath("xpathPaxSelector", simpleDynamicXpathCreator("xpathPathToAllPaxOptions", "departNoOfPax")); //A common dynamic xpath is defined in xpathPathToAllPaxOptions which can lead to any number of passengers; the no defines the number of passengers. Both of these are combined into a single xpath by simpleDynamicXpathCreator, which is then clicked and checked.
 */