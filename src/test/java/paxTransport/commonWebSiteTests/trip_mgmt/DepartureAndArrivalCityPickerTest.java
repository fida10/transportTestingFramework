package paxTransport.commonWebSiteTests.trip_mgmt;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButtonDirectXpath;
import static paxTransport.commonWebSiteFeatures.clicking.CloseDialogBox.closePopUpDialogBox;
import static paxTransport.commonWebSiteFeatures.inputBox.ClearPreFilledInputBox.clearPreFilledInputBox;
import static paxTransport.commonWebSiteFeatures.inputBox.SendKeysAndAutoCompleteInputBox.sendKeysToInputBox;
import static paxTransport.commonWebSiteFeatures.webElements.DynamicXpathCreator.simpleDynamicXpathCreator;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayedDirectXpath;

public class DepartureAndArrivalCityPickerTest {
	public static String xpathToCityInAutoDropDownOptions = "";
	/*@Test (priority = 0)
	public static void nextWebElementPointerOne(String xpathOpenDepCitySelector){
		nextWebElement = convertToWebElement(xpathOpenDepCitySelector);
	} /*A common web element. A nextWebElementPointer method will set this as the first webElement used for the next test. @BeforeMethods can then be used to run various actions on the element, i.e. check it's visibility, if it is enabled, scroll to it, etc.
	 It is set to commonElementOnAllWebSites which points to //html. This is a common element present on every website, and it also ensures that nullpointerexception is avoided.*/
	@Test (priority = 1)
	public static void openDepCityOptions(){
		clickAnyButton("xpathOpenDepCitySelector");
	}
	@Test (priority = 1)
	public static void clearDepCityInputBox(){ //if there is already a value the input field for airport code, this test will clear it.
		clearPreFilledInputBox("xpathOpenDepCitySelector");
	}
	@Test (priority = 2)
	@Parameters({"depCityCodeProp"}) //has to be one way or round trip based on trip type
	public static void sendKeysDynamicXpathToDepCity(String depCityCodeProp){
		xpathToCityInAutoDropDownOptions = simpleDynamicXpathCreator("xpathCityAutoDropDownDynamicXpath", depCityCodeProp);
		//creates an xpath using the dynamic portion defined in properties with the airport code also in properties. Stored globally for use in the next test.
		sendKeysToInputBox(depCityCodeProp);
		//Verification that dep city is displayed done below.
	}
	@Test (priority = 4)
	public static void depCityNotDisplayedHandler(){
		boolean isElementDisplayed = checkIfElementIsDisplayedDirectXpath(xpathToCityInAutoDropDownOptions);
		if(!isElementDisplayed){
			System.out.println("Element is not displayed, closing city dialog box.");
			closePopUpDialogBox("xpathCityAutoDropDownCloseXpath");
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
	public static void openArrCityOptions(){
		clickAnyButton("xpathOpenArrCitySelector");
	}
	@Parameters({"arrCityCodeProp"}) //has to be one way or round trip based on trip type
	@Test (priority = 7)
	public static void sendKeysDynamicXpathToArrCity(String arrCityCodeProp){
		xpathToCityInAutoDropDownOptions = simpleDynamicXpathCreator("xpathCityAutoDropDownDynamicXpath", arrCityCodeProp); //creates an xpath using the dynamic portion defined in properties with the airport code also in properties.
		sendKeysToInputBox(arrCityCodeProp);
	}
	@Test (priority = 9)
	public static void arrCityNotDisplayedHandler(){
		boolean isElementDisplayed = checkIfElementIsDisplayedDirectXpath(xpathToCityInAutoDropDownOptions);
		if(!isElementDisplayed){
			System.out.println("Element is not displayed, closing city dialog box.");
			closePopUpDialogBox("xpathCityAutoDropDownCloseXpath");
		} //if the city is not displayed, it means the city is invalid, which means the box should be closed to not block off other tests and elements.
		Assert.assertTrue(isElementDisplayed);
		//verifies if the city desired is actually visible in the auto drop down options
	}
	@Test (priority = 10)
	public static void selectArrCity(){
		clickAnyButtonDirectXpath(xpathToCityInAutoDropDownOptions);//verifies if the city desired is actually visible in the auto drop down options, and clicks on it as well.
	}
}