package paxTransport.commonWebSiteFeatures.datePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;
import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayedDirectXpath;

public class TwoBoxDatePicker {
	static Actions a = new Actions(dr);
	public static boolean twoBoxDatePicker(String xpathDatePickerOpenerProp, String xpathFirstBoxYearProp, String xpathFirstBoxMonthProp, String xpathSecondBoxYearProp, String xpathSecondBoxMonthProp, String departDesiredDateYearProp, String departDesiredDateMonthFirstLetterCapitalProp, String xpathDatePickerNextArrowProp, String xpathDepartNumericDatePathFirstBoxProp, String xpathDepartNumericDatePathSecondBoxProp, String departDateNumericDateProp){
		openDatePicker(xpathDatePickerOpenerProp);
		boolean endOfDatePickerReached = cycleToCorrectYearMonth(xpathFirstBoxYearProp, xpathFirstBoxMonthProp, xpathSecondBoxYearProp, xpathSecondBoxMonthProp, departDesiredDateYearProp, departDesiredDateMonthFirstLetterCapitalProp, xpathDatePickerNextArrowProp, xpathDepartNumericDatePathFirstBoxProp, xpathDepartNumericDatePathSecondBoxProp, departDateNumericDateProp);
		return endOfDatePickerReached;
	}
	static void openDatePicker(String DatePickerSelectorOpener){
		clickAnyButton(DatePickerSelectorOpener); //opens the datePicker
	}
	static boolean cycleToCorrectYearMonth(String xpathFirstBoxYearProp, String xpathFirstBoxMonthProp, String xpathSecondBoxYearProp, String xpathSecondBoxMonthProp, String departDesiredDateYearProp, String departDesiredDateMonthFirstLetterCapitalProp, String xpathDatePickerNextArrowProp, String xpathDepartNumericDatePathFirstBoxProp, String xpathDepartNumericDatePathSecondBoxProp, String departDateNumericDateProp) { //this program uses the second box to find and select dates. This method cycles through the datepicker until it reaches the year and month specified in properties.

		final String firstBoxYear = dr.findElement(By.xpath(proSpecific.getProperty(xpathFirstBoxYearProp))).getText();
		final String firstBoxMonth = dr.findElement(By.xpath(proSpecific.getProperty(xpathFirstBoxMonthProp))).getText(); //gets the year and month in the first box at the start of the loop, and keeps these values, as the first box changes with each iteration of the loop
		String desiredDepartDateYear = proSpecific.getProperty(departDesiredDateYearProp);
		String desiredDepartDateMonth = proSpecific.getProperty(departDesiredDateMonthFirstLetterCapitalProp); //these two strings store the date and year being tested for, gotten from properties
		String nextArrowXpath = proSpecific.getProperty(xpathDatePickerNextArrowProp);
		WebElement nextArrow = dr.findElement(By.xpath(nextArrowXpath)); //the arrow that moves the datepicker to the next month

		List<String> monthStorageList = new ArrayList<>();
		monthStorageList.add("dummyMonthOne");
		monthStorageList.add("dummyMonthTwo");
		List<String> yearStorageList = new ArrayList<>();
		yearStorageList.add("dummyYearOne");
		yearStorageList.add("dummyYearTwo");

		boolean endOfDatePickerReached = false; //given an initial value of false as the datepicker doesn't start at the end!
		//a key part in determining the end of the list

		while (true) {
			if (firstBoxYear.contains(desiredDepartDateYear) && firstBoxMonth.contains(desiredDepartDateMonth)) { //checks if the month and year in the first box of the datepicker matches the specified month and year in properties
				System.out.println("Desired date is on the first box, selecting date and ending loop");
				selectDate(xpathDepartNumericDatePathFirstBoxProp, departDateNumericDateProp); //selects the date, from the first box
				break;
			}
			String secondBoxYear = dr.findElement(By.xpath(proSpecific.getProperty(xpathSecondBoxYearProp))).getText();
			String secondBoxMonth = dr.findElement(By.xpath(proSpecific.getProperty(xpathSecondBoxMonthProp))).getText();
			if (secondBoxYear.contains(desiredDepartDateYear) && secondBoxMonth.contains(desiredDepartDateMonth)){
				System.out.println("Desired date reached in the second box, selecting date and ending loop");
				selectDate(xpathDepartNumericDatePathSecondBoxProp, departDateNumericDateProp); //selects the date, from the second box
				break;
			}
			endOfDatePickerReached = !checkIfElementIsDisplayedDirectXpath(nextArrowXpath);
			if (endOfDatePickerReached){
				System.out.println("The next arrow is no longer displayed! We've reached the end of the calendar, invalid date given");
				break;
			} /*The above statement is another loop breaker; certain websites have the next arrow on their datepickers disappear after the end of the datepicker is reached.
			Here, if the next arrow is not displayed, checkIfElementIsDisplayedDirectXpath will display false, which, because of the '!' will make endOfDatePickerReached true, and subsequently break the loop.*/
			monthStorageList.add(secondBoxMonth);
			yearStorageList.add(secondBoxYear);
			/*the above "add" methods add the current month and year to a list that stores months and years from previous iterations of this loop.
			Once the loop reaches a point where the current month and year are equal to the month and year that immediately preceded them (i.e. List stored February and 2021 but the previous iteration was also February and 2021), it is understood that we are at the end of the datepicker, since only the end would result in duplicate months and years.
			If this point, the loop breaks. */
			endOfDatePickerReached = (monthStorageList.get(monthStorageList.size() - 1)
					.equalsIgnoreCase
							(monthStorageList.get(monthStorageList.size() - 2))
					&&
					yearStorageList.get(yearStorageList.size() - 1)
							.equalsIgnoreCase
									(yearStorageList.get(yearStorageList.size() - 2)));
			//made a boolean just to use it on multiple points without copying the entire condition.
			if(endOfDatePickerReached){
				System.out.println("Reached the end of the datepicker, invalid desired date provided");
				break;
			} //Breaks the loop if the end of datepicker has been reached.
			a
					.moveToElement(nextArrow)
					.click()
					.build()
					.perform();
		}
		return endOfDatePickerReached; //for use in the actual test. If the end of the datepicker was reached, an invalid date was given and this boolean can be used to make the test fail.
	}
	private static void selectDate(String xpathPathToDatesProp, String numericDateProp){
		String xpathToDates = (proSpecific.getProperty(xpathPathToDatesProp)).concat("'%s']"); //as this xpath is always dynamic, we can leave the '%s'] part fixed as the xpaths will be written to always have that incorporated at the end.
		String dateToClick = proSpecific.getProperty(numericDateProp);

		WebElement dateToPick = dr.findElement(By.xpath(String.format(xpathToDates, dateToClick)));
		a
				.moveToElement(dateToPick)
				.click()
				.build()
				.perform();
	}
}
