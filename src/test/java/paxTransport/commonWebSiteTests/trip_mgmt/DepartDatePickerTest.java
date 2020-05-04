package paxTransport.commonWebSiteTests.trip_mgmt;

import org.testng.Assert;
import org.testng.annotations.Test;
import paxTransport.commonWebSiteTests.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.datePicker.TwoBoxDatePicker.twoBoxDatePicker;
/*import static paxTransport.commonCodeFeatures.Initializer.nextWebElement;*/

public class DepartDatePickerTest extends VerificationTest { //the same, only no done button, just a direct click on the dates.
	/*@Parameters({"xpathDepartDatePickerOpener"})
	@Test (priority = 0)
	public static void nextWebElementPointerOne(String xpathDepartDatePickerOpener){
		nextWebElement = convertToWebElement(xpathDepartDatePickerOpener);
	} /*A common web element. A nextWebElementPointer method will set this as the first webElement used for the next test. @BeforeMethods can then be used to run various actions on the element, i.e. check it's visibility, if it is enabled, scroll to it, etc.
	 It is set to commonElementOnAllWebSites which points to //html. This is a common element present on every website, and it also ensures that nullpointerexception is avoided.*/
	@Test (priority = 1)
	public static void departDatePickerTest(String xpathDepartDatePickerOpener, String xpathDepartPathToOpenFirstBoxYear, String xpathDepartPathToOpenFirstBoxMonth, String xpathDepartPathToOpenSecondBoxYear, String xpathDepartPathToOpenSecondBoxMonth, String departDateYear, String departDateMonthFirstLetterCapital, String xpathDepartPathToNextArrow, String xpathDepartNumericDatePathFirstBox, String xpathDepartNumericDatePathSecondBox, String departDateNumericDate){
		boolean endOfDatePickerReached = twoBoxDatePicker(xpathDepartDatePickerOpener, xpathDepartPathToOpenFirstBoxYear, xpathDepartPathToOpenFirstBoxMonth, xpathDepartPathToOpenSecondBoxYear, xpathDepartPathToOpenSecondBoxMonth, departDateYear, departDateMonthFirstLetterCapital, xpathDepartPathToNextArrow, xpathDepartNumericDatePathFirstBox, xpathDepartNumericDatePathSecondBox, departDateNumericDate);
		Assert.assertFalse(endOfDatePickerReached); //If the end of the datepicker was reached, an invalid date was given and this boolean can be used to make the test fail.
	}
	@Test (priority = 3)
	public static void clickDoneButton(String xpathDepartDatePickerDoneButton){
		clickAnyButton(xpathDepartDatePickerDoneButton); //clicks on the done button once date is selected.
	}
}