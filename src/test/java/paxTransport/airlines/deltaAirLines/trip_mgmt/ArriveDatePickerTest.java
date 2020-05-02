package paxTransport.airlines.deltaAirLines.trip_mgmt;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.datePicker.TwoBoxDatePicker.twoBoxDatePicker;
//replace depart with arrive, everywhere. And do the same with a new set of params in the xml file
public class ArriveDatePickerTest extends VerificationTest {
	@Parameters({"xpathArriveDatePickerOpenerProp", "xpathArrivePathToOpenFirstBoxYearProp", "xpathArrivePathToOpenFirstBoxMonthProp", "xpathArrivePathToOpenSecondBoxYearProp", "xpathArrivePathToOpenSecondBoxMonthProp", "arriveDateYearProp", "arriveDateMonthFirstLetterCapitalProp", "xpathArrivePathToNextArrowProp", "xpathArriveNumericDatePathFirstBoxProp", "xpathArriveNumericDatePathSecondBoxProp", "arriveDateNumericDateProp"})
	@Test
	public static void arriveDatePickerTest(String xpathArriveDatePickerOpenerProp, String xpathArrivePathToOpenFirstBoxYearProp, String xpathArrivePathToOpenFirstBoxMonthProp, String xpathArrivePathToOpenSecondBoxYearProp, String xpathArrivePathToOpenSecondBoxMonthProp, String arriveDateYearProp, String arriveDateMonthFirstLetterCapitalProp, String xpathArrivePathToNextArrowProp, String xpathArriveNumericDatePathFirstBoxProp, String xpathArriveNumericDatePathSecondBoxProp, String arriveDateNumericDateProp){
		boolean endOfDatePickerReached = twoBoxDatePicker(xpathArriveDatePickerOpenerProp, xpathArrivePathToOpenFirstBoxYearProp, xpathArrivePathToOpenFirstBoxMonthProp, xpathArrivePathToOpenSecondBoxYearProp, xpathArrivePathToOpenSecondBoxMonthProp, arriveDateYearProp, arriveDateMonthFirstLetterCapitalProp, xpathArrivePathToNextArrowProp, xpathArriveNumericDatePathFirstBoxProp, xpathArriveNumericDatePathSecondBoxProp, arriveDateNumericDateProp);
		Assert.assertFalse(endOfDatePickerReached); //If the end of the datepicker was reached, an invalid date was given and this boolean can be used to make the test fail.
	}
	@Parameters({"xpathArriveDatePickerDoneButtonProp"})
	@Test (dependsOnMethods = "arriveDatePickerTest")
	public static void clickDoneButton(String xpathArriveDatePickerDoneButtonProp){
		clickAnyButton(xpathArriveDatePickerDoneButtonProp); //clicks on the done button once date is selected.
	}
}
