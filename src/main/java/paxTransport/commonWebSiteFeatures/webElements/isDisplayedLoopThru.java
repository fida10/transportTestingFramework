package paxTransport.commonWebSiteFeatures.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;
import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.webElements.ConvertPropToWebElement.convertPropToWebElement;

public class isDisplayedLoopThru {
	static WebElement webElementToCheck;
	public static boolean checkIfElementIsDisplayed(String xpathWebElementToCheckProp){ //Just checks if an element is displayed. No clicking.
		boolean isWebElementDisplayed = true; //avoid nullpointerexception by presetting the value
		WebDriverWait wd = new WebDriverWait(dr, 5);
		try {
			wd.until(ExpectedConditions.visibilityOf(convertPropToWebElement(xpathWebElementToCheckProp)));
			webElementToCheck = convertPropToWebElement(xpathWebElementToCheckProp);
			 //finds the webelement to check, and by extension sees if it is displayed. Waits 5 seconds for it to display.
			System.out.println("Element is displayed, exiting loop.");
			isWebElementDisplayed = webElementToCheck.isDisplayed(); //if it's displayed, this will display as true
			} catch (NoSuchElementException e) {
				//System.out.println("Element not currently not displayed, failing test");
				isWebElementDisplayed = false;
			}
		return isWebElementDisplayed; //ideally this would be passed into an assert statement during actual tests
	}
	public static boolean checkIfElementIsDisplayedDirectXpath(String xpathWebElementToCheck){ //Just checks if an element is displayed. No clicking. Same as above but takes a direct xpath, usually created by DynamicXpathCreator
		boolean isWebElementDisplayed = true; //avoid nullpointerexception by presetting the value
		WebDriverWait wd = new WebDriverWait(dr, 5);
		try {
			wd.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath(xpathWebElementToCheck))));
			webElementToCheck = dr.findElement(By.xpath(xpathWebElementToCheck)); //finds the webelement to check, and by extension sees if it is displayed.
			System.out.println("Element is displayed, exiting loop.");
			isWebElementDisplayed = webElementToCheck.isDisplayed(); //if it's displayed, this will display as true
		} catch (NoSuchElementException e) {
			System.out.println("Element not currently not displayed, failing test");
			isWebElementDisplayed = false;
		}
		return isWebElementDisplayed; //ideally this would be passed into an assert statement during actual tests
	}
	public static void clickAndCheckIfElementIsDisplayed(String xpathWebElementToCheckProp, String xpathToWebElementToClickProp){ //xpathToWebElementToClickProp is the webelement you need to click to display xpathWebElementToCheckProp, i.e. click a dynamic dropdown menu, display the contents. Contents here would be xpathWebElementToCheckProp. Clicking on a button is also integrated for convenience.
		while(true) {
			try {
				clickAnyButton(xpathToWebElementToClickProp);
				dr.findElement(By.xpath(proSpecific.getProperty(xpathWebElementToCheckProp))).isDisplayed(); //can change this to isDisplayed, isEnabled, etc. as needed
				System.out.println("Element is displayed, exiting loop.");
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element not currently not displayed, trying again.");
			}
		}
	}
}
