package paxTransport.airlines.deltaAirLines.trip_mgmt;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.onStartUp.VerificationTest;

import javax.annotation.ParametersAreNonnullByDefault;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButtonDirectXpath;
import static paxTransport.commonWebSiteFeatures.clicking.CloseDialogBox.closePopUpDialogBox;
import static paxTransport.commonWebSiteFeatures.inputBox.ClearPreFilledInputBox.clearPreFilledInputBox;
import static paxTransport.commonWebSiteFeatures.inputBox.SendKeysAndAutoCompleteInputBox.selectFirstAutoCompleteOption;
import static paxTransport.commonWebSiteFeatures.inputBox.SendKeysAndAutoCompleteInputBox.sendKeysToInputBox;
import static paxTransport.commonWebSiteFeatures.webElements.DynamicXpathCreator.simpleDynamicXpathCreator;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayedDirectXpath;

public class DepartureAndArrivalCityPickerTest { //as the elements appear dynamic, can define xpaths to click on them, which will be more reliable.
	public static String xpathToCityInAutoDropDownOptions = "";
	@Parameters ({"xpathOpenDepCitySelectorProp"})
	@Test (priority = 0)
	public static void openDepCityOptions(String xpathOpenDepCitySelectorProp){
		clickAnyButton(xpathOpenDepCitySelectorProp);
	}
	@Parameters ({"xpathOpenDepCitySelectorProp"})
	@Test (priority = 1)
	public static void clearDepCityInputBox(String xpathOpenDepCitySelectorProp){ //if there is already a value the input field for airport code, this test will clear it.
		clearPreFilledInputBox(xpathOpenDepCitySelectorProp);
	}
	@Parameters ({"depCityCodeProp", "xpathCityAutoDropDownDynamicXpathProp"})
	@Test (priority = 2)
	public static void sendKeysDynamicXpathToDepCity(String depCityCodeProp, String xpathCityAutoDropDownDynamicXpathProp){
		xpathToCityInAutoDropDownOptions = simpleDynamicXpathCreator(xpathCityAutoDropDownDynamicXpathProp, depCityCodeProp);
		//creates an xpath using the dynamic portion defined in properties with the airport code also in properties. Stored globally for use in the next test.
		sendKeysToInputBox(depCityCodeProp);
		//Verification that dep city is displayed done below.
	}
	@Parameters({"xpathCityAutoDropDownCloseXpathProp"})
	@Test (priority = 3)
	public static void depCityNotDisplayedHandler(String xpathCityAutoDropDownCloseXpathProp){
		boolean isElementDisplayed = checkIfElementIsDisplayedDirectXpath(xpathToCityInAutoDropDownOptions);
		if(!isElementDisplayed){
			System.out.println("Element is not displayed, closing city dialog box.");
			closePopUpDialogBox(xpathCityAutoDropDownCloseXpathProp);
		} //if the city is not displayed, it means the city is invalid, which means the box should be closed to not block off other tests and elements.
		Assert.assertTrue(isElementDisplayed);
		//verifies if the city desired is actually visible in the auto drop down options
	}
	@Test (priority = 4)
	public static void selectDepCity(){
		clickAnyButtonDirectXpath(xpathToCityInAutoDropDownOptions); //clicks on the departure city set above.
	}
	@Parameters({"xpathOpenArrCitySelectorProp"})
	@Test (priority = 5)
	public static void openArrCityOptions(String xpathOpenArrCitySelectorProp){
		clickAnyButton(xpathOpenArrCitySelectorProp);
	}
	@Parameters({"arrCityCodeProp", "xpathCityAutoDropDownDynamicXpathProp"})
	@Test (priority = 6)
	public static void sendKeysDynamicXpathToArrCity(String arrCityCodeProp, String xpathCityAutoDropDownDynamicXpathProp){
		xpathToCityInAutoDropDownOptions = simpleDynamicXpathCreator(xpathCityAutoDropDownDynamicXpathProp, arrCityCodeProp); //creates an xpath using the dynamic portion defined in properties with the airport code also in properties.
		sendKeysToInputBox(arrCityCodeProp);
	}
	@Parameters({"xpathCityAutoDropDownCloseXpathProp"})
	@Test (priority = 7)
	public static void arrCityNotDisplayedHandler(String xpathCityAutoDropDownCloseXpathProp){
		boolean isElementDisplayed = checkIfElementIsDisplayedDirectXpath(xpathToCityInAutoDropDownOptions);
		if(!isElementDisplayed){
			System.out.println("Element is not displayed, closing city dialog box.");
			closePopUpDialogBox(xpathCityAutoDropDownCloseXpathProp);
		} //if the city is not displayed, it means the city is invalid, which means the box should be closed to not block off other tests and elements.
		Assert.assertTrue(isElementDisplayed);
		//verifies if the city desired is actually visible in the auto drop down options
	}
	@Test (priority = 8)
	public static void selectArrCity(){
		clickAnyButtonDirectXpath(xpathToCityInAutoDropDownOptions);//verifies if the city desired is actually visible in the auto drop down options, and clicks on it as well.
	}
}