package paxTransport.commonWebSiteTests.onStartUp;

import org.testng.annotations.BeforeClass;

import static paxTransport.commonCodeFeatures.HelperMethods.uRLVerificationMethod;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;


public class VerificationTest {
	@BeforeClass
	public static void urlVerificationTest() { //verifies that test is running on correct URL
		uRLVerificationMethod(proSpecific.getProperty("homeURL"));
	}
	//can add all kinds of tests with the nextWebElement. For now just doing scrolling
	/* @BeforeMethod
	public static void handlingExceptions(){
		while(true) {
			WebDriverWait w = new WebDriverWait(dr, 5);
			try {
				System.out.println("Current webelement is " + nextWebElement);
				if(nextWebElement.isEnabled() && nextWebElement.isDisplayed()){
					break;
				}
			} catch (MoveTargetOutOfBoundsException e) {
				System.out.println("Element is out of bounds, scrolling to it.");
				scrollToElementDirectWebElement(nextWebElement);
			} catch (StaleElementReferenceException e) {
				System.out.println("Element is still stale, handling.");
			}
		}
	} */
}
