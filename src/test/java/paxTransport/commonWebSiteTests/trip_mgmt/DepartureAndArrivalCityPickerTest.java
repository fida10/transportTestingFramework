package paxTransport.commonWebSiteTests.trip_mgmt;

import org.testng.Assert;
import org.testng.annotations.Test;

import static paxTransport.commonCodeFeatures.Initializer.nextWebElement;
import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButtonDirectXpath;
import static paxTransport.commonWebSiteFeatures.clicking.CloseDialogBox.closePopUpDialogBox;
import static paxTransport.commonWebSiteFeatures.inputBox.ClearPreFilledInputBox.clearPreFilledInputBox;
import static paxTransport.commonWebSiteFeatures.inputBox.SendKeysAndAutoCompleteInputBox.sendKeysToInputBox;
import static paxTransport.commonWebSiteFeatures.webElements.DynamicXpathCreator.simpleDynamicXpathCreator;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayedDirectXpath;

public class DepartureAndArrivalCityPickerTest { //as the elements appear dynamic, can define xpaths to click on them, which will be more reliable.
	public static String xpathToCityInAutoDropDownOptions = "";
	/*@Test (priority = 0)
	public static void nextWebElementPointerOne(String xpathOpenDepCitySelector){
		nextWebElement = convertToWebElement(xpathOpenDepCitySelector);
	} /*A common web element. A nextWebElementPointer method will set this as the first webElement used for the next test. @BeforeMethods can then be used to run various actions on the element, i.e. check it's visibility, if it is enabled, scroll to it, etc.
	 It is set to commonElementOnAllWebSites which points to //html. This is a common element present on every website, and it also ensures that nullpointerexception is avoided.*/
	@Test (priority = 1)
	public static void openDepCityOptions(String xpathOpenDepCitySelector){
		clickAnyButton(xpathOpenDepCitySelector);
	}
	@Test (priority = 1)
	public static void clearDepCityInputBox(String xpathOpenDepCitySelector){ //if there is already a value the input field for airport code, this test will clear it.
		clearPreFilledInputBox(xpathOpenDepCitySelector);
	}
	@Test (priority = 2)
	public static void sendKeysDynamicXpathToDepCity(String depCityCode, String xpathCityAutoDropDownDynamicXpath){
		xpathToCityInAutoDropDownOptions = simpleDynamicXpathCreator(xpathCityAutoDropDownDynamicXpath, depCityCode);
		//creates an xpath using the dynamic portion defined in properties with the airport code also in properties. Stored globally for use in the next test.
		sendKeysToInputBox(depCityCode);
		//Verification that dep city is displayed done below.
	}
	@Test (priority = 4)
	public static void depCityNotDisplayedHandler(String xpathCityAutoDropDownCloseXpath){
		boolean isElementDisplayed = checkIfElementIsDisplayedDirectXpath(xpathToCityInAutoDropDownOptions);
		if(!isElementDisplayed){
			System.out.println("Element is not displayed, closing city dialog box.");
			closePopUpDialogBox(xpathCityAutoDropDownCloseXpath);
		} //if the city is not displayed, it means the city is invalid, which means the box should be closed to not block off other tests and elements.
		Assert.assertTrue(isElementDisplayed);
		//verifies if the city desired is actually visible in the auto drop down options
	}
	@Test (priority = 4)
	public static void selectDepCity(){
		clickAnyButtonDirectXpath(xpathToCityInAutoDropDownOptions); //clicks on the departure city set above.
	}
	/*@Test (priority = 5)
	public static void nextWebElementPointerThree(String xpathOpenArrCitySelector){
		nextWebElement = convertToWebElement(xpathOpenArrCitySelector);
	}*/
	@Test (priority = 6)
	public static void openArrCityOptions(String xpathOpenArrCitySelector){
		clickAnyButton(xpathOpenArrCitySelector);
	}
	@Test (priority = 7)
	public static void sendKeysDynamicXpathToArrCity(String arrCityCode, String xpathCityAutoDropDownDynamicXpath){
		xpathToCityInAutoDropDownOptions = simpleDynamicXpathCreator(xpathCityAutoDropDownDynamicXpath, arrCityCode); //creates an xpath using the dynamic portion defined in properties with the airport code also in properties.
		sendKeysToInputBox(arrCityCode);
	}
	@Test (priority = 9)
	public static void arrCityNotDisplayedHandler(String xpathCityAutoDropDownCloseXpath){
		boolean isElementDisplayed = checkIfElementIsDisplayedDirectXpath(xpathToCityInAutoDropDownOptions);
		if(!isElementDisplayed){
			System.out.println("Element is not displayed, closing city dialog box.");
			closePopUpDialogBox(xpathCityAutoDropDownCloseXpath);
		} //if the city is not displayed, it means the city is invalid, which means the box should be closed to not block off other tests and elements.
		Assert.assertTrue(isElementDisplayed);
		//verifies if the city desired is actually visible in the auto drop down options
	}
	@Test (priority = 10)
	public static void selectArrCity(){
		clickAnyButtonDirectXpath(xpathToCityInAutoDropDownOptions);//verifies if the city desired is actually visible in the auto drop down options, and clicks on it as well.
	}
}