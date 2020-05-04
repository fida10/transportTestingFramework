package paxTransport.commonWebSiteTests.trip_mgmt;

import org.testng.Assert;

import org.testng.annotations.Test;
import paxTransport.commonWebSiteTests.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.datePicker.TwoBoxDatePicker.twoBoxDatePicker;

public class ReturnDatePickerTest extends VerificationTest {
/*	@Test (priority = 0)
	public static void nextWebElementPointerOne(String xpathArriveDatePickerOpener){
		nextWebElement = convertToWebElement(xpathArriveDatePickerOpener);
	} /*A common web element. A nextWebElementPointer method will set this as the first webElement used for the next test. @BeforeMethods can then be used to run various actions on the element, i.e. check it's visibility, if it is enabled, scroll to it, etc.
	 It is set to commonElementOnAllWebSites which points to //html. This is a common element present on every website, and it also ensures that nullpointerexception is avoided.*/
	@Test (priority = 1)
	public static void arriveDatePickerTest(String xpathArriveDatePickerOpener, String xpathArrivePathToOpenFirstBoxYear, String xpathArrivePathToOpenFirstBoxMonth, String xpathArrivePathToOpenSecondBoxYear, String xpathArrivePathToOpenSecondBoxMonth, String arriveDateYear, String arriveDateMonthFirstLetterCapital, String xpathArrivePathToNextArrow, String xpathArriveNumericDatePathFirstBox, String xpathArriveNumericDatePathSecondBox, String arriveDateNumericDate){
		boolean endOfDatePickerReached = twoBoxDatePicker(xpathArriveDatePickerOpener, xpathArrivePathToOpenFirstBoxYear, xpathArrivePathToOpenFirstBoxMonth, xpathArrivePathToOpenSecondBoxYear, xpathArrivePathToOpenSecondBoxMonth, arriveDateYear, arriveDateMonthFirstLetterCapital, xpathArrivePathToNextArrow, xpathArriveNumericDatePathFirstBox, xpathArriveNumericDatePathSecondBox, arriveDateNumericDate);
		Assert.assertFalse(endOfDatePickerReached); //If the end of the datepicker was reached, an invalid date was given and this boolean can be used to make the test fail.
	}
	@Test (priority = 3)
	public static void clickDoneButton(String xpathArriveDatePickerDoneButton){
		clickAnyButton(xpathArriveDatePickerDoneButton); //clicks on the done button once date is selected.
	}
}
