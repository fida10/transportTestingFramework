package paxTransport.airlines.deltaAirLines.trip_mgmt;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.datePicker.TwoBoxDatePicker.twoBoxDatePicker;

public class DepartDatePickerTest extends VerificationTest {
	@Parameters({"xpathDepartDatePickerOpenerProp", "xpathDepartPathToOpenFirstBoxYearProp", "xpathDepartPathToOpenFirstBoxMonthProp", "xpathDepartPathToOpenSecondBoxYearProp", "xpathDepartPathToOpenSecondBoxMonthProp", "departDateYearProp", "departDateMonthFirstLetterCapitalProp", "xpathDepartPathToNextArrowProp", "xpathDepartNumericDatePathFirstBoxProp", "xpathDepartNumericDatePathSecondBoxProp", "departDateNumericDateProp"})
	@Test
	public static void departDatePickerTest(String xpathDepartDatePickerOpenerProp, String xpathDepartPathToOpenFirstBoxYearProp, String xpathDepartPathToOpenFirstBoxMonthProp, String xpathDepartPathToOpenSecondBoxYearProp, String xpathDepartPathToOpenSecondBoxMonthProp, String departDateYearProp, String departDateMonthFirstLetterCapitalProp, String xpathDepartPathToNextArrowProp, String xpathDepartNumericDatePathFirstBoxProp, String xpathDepartNumericDatePathSecondBoxProp, String departDateNumericDateProp){
		boolean endOfDatePickerReached = twoBoxDatePicker(xpathDepartDatePickerOpenerProp, xpathDepartPathToOpenFirstBoxYearProp, xpathDepartPathToOpenFirstBoxMonthProp, xpathDepartPathToOpenSecondBoxYearProp, xpathDepartPathToOpenSecondBoxMonthProp, departDateYearProp, departDateMonthFirstLetterCapitalProp, xpathDepartPathToNextArrowProp, xpathDepartNumericDatePathFirstBoxProp, xpathDepartNumericDatePathSecondBoxProp, departDateNumericDateProp);
		Assert.assertFalse(endOfDatePickerReached); //If the end of the datepicker was reached, an invalid date was given and this boolean can be used to make the test fail.
	}
	@Parameters({"xpathDepartDatePickerDoneButtonProp"})
	@Test (dependsOnMethods = "departDatePickerTest")
	public static void clickDoneButton(String xpathDepartDatePickerDoneButtonProp){
		clickAnyButton(xpathDepartDatePickerDoneButtonProp); //clicks on the done button once date is selected.
	}
}
