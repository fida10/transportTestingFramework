package paxTransport.airlines.deltaAirLines.trip_mgmt;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButtonDirectXpath;
import static paxTransport.commonWebSiteFeatures.clicking.CloseDialogBox.closePopUpDialogBox;
import static paxTransport.commonWebSiteFeatures.inputBox.SendKeysAndAutoCompleteInputBox.selectFirstAutoCompleteOption;
import static paxTransport.commonWebSiteFeatures.inputBox.SendKeysAndAutoCompleteInputBox.sendKeysToInputBox;
import static paxTransport.commonWebSiteFeatures.webElements.DynamicXpathCreator.simpleDynamicXpathCreator;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayedDirectXpath;

public class DepartureAndArrivalCityPicker  { //as the elements appear dynamic, can define xpaths to click on them, which will be more reliable.
	@Parameters ({"xpathOpenDepCitySelectorProp"})
	@Test
	public static void openDepCityOptions(String xpathOpenDepCitySelectorProp){
		clickAnyButton(xpathOpenDepCitySelectorProp);
	}
	@Parameters ({"depCityCodeProp", "xpathCityAutoDropDownDynamicXpathProp", "xpathCityAutoDropDownCloseXpathProp"})
	@Test (dependsOnMethods = "openDepCityOptions")
	public static void selectDepCity(String depCityCodeProp, String xpathCityAutoDropDownDynamicXpathProp, String xpathCityAutoDropDownCloseXpathProp){
		sendKeysToInputBox(depCityCodeProp);
		String xpathToCityInAutoDropDownOptions = simpleDynamicXpathCreator(xpathCityAutoDropDownDynamicXpathProp, depCityCodeProp);
		//creates an xpath using the dynamic portion defined in properties with the airport code also in properties.
		boolean isElementDisplayed = checkIfElementIsDisplayedDirectXpath(xpathToCityInAutoDropDownOptions);
		if(!isElementDisplayed){
			System.out.println("Element is not displayed, closing city dialog box.");
			closePopUpDialogBox(xpathCityAutoDropDownCloseXpathProp);
		} //if the city is not displayed, it means the city is invalid, which means the box should be closed to not block off other tests and elements.
		Assert.assertTrue(isElementDisplayed);
		//verifies if the city desired is actually visible in the auto drop down options
		clickAnyButtonDirectXpath(xpathToCityInAutoDropDownOptions); //Clicks on the webelement the created dynamic xpath points to.
	}
	@Parameters({"xpathOpenArrCitySelectorProp"})
	@Test (dependsOnMethods = "selectDepCity")
	public static void openArrCityOptions(String xpathOpenArrCitySelectorProp){
		clickAnyButton(xpathOpenArrCitySelectorProp);
	}
	@Parameters({"arrCityCodeProp", "xpathCityAutoDropDownDynamicXpathProp", "xpathCityAutoDropDownCloseXpath", })
	@Test (dependsOnMethods = "openArrCityOptions")
	public static void selectArrCity(String arrCityCodeProp, String xpathCityAutoDropDownDynamicXpathProp, String xpathCityAutoDropDownCloseXpath){
		sendKeysToInputBox(arrCityCodeProp);
		String xpathToCityInAutoDropDownOptions = simpleDynamicXpathCreator(xpathCityAutoDropDownDynamicXpathProp, arrCityCodeProp); //creates an xpath using the dynamic portion defined in properties with the airport code also in properties.
		boolean isElementDisplayed = checkIfElementIsDisplayedDirectXpath(xpathToCityInAutoDropDownOptions);
		if(!isElementDisplayed){
			System.out.println("Element is not displayed, closing city dialog box.");
			closePopUpDialogBox(xpathCityAutoDropDownCloseXpath);
		}
		Assert.assertTrue(isElementDisplayed); //verifies if the city desired is actually visible in the auto drop down options
		clickAnyButtonDirectXpath(xpathToCityInAutoDropDownOptions); //clicks on the webelement the created dynamic xpath points to.
	}
}
