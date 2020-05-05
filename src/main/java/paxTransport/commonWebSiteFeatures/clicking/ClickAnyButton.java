package paxTransport.commonWebSiteFeatures.clicking;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;
import static paxTransport.commonWebSiteFeatures.webElements.ScrollToWebElement.scrollToElement;
import static paxTransport.commonWebSiteFeatures.webElements.ScrollToWebElement.scrollToElementDirectXpath;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayed;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayedDirectXpath;

public class ClickAnyButton { //in addition to clicking any button, this class will also scroll to a button if it exists in the page but throws a MoveTargetOutOfBoundsException and is not clickable at first due to this, and verifies if that element is visible.
	static Actions a = new Actions(dr);
	static WebDriverWait w = new WebDriverWait(dr, 5);
	public static void clickAnyButton(String xpathButtonProp){
		while(true) {
			try {
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(proSpecific.getProperty(xpathButtonProp))));
				WebElement buttonToClick = dr.findElement(By.xpath(proSpecific.getProperty(xpathButtonProp)));
				a
						.moveToElement(buttonToClick)
						.click()
						.build()
						.perform();
				break;
			}
			catch (MoveTargetOutOfBoundsException e){
				System.out.println("Element is out of bounds, scrolling to it.");
				scrollToElement(xpathButtonProp);
			}
			catch (StaleElementReferenceException e){
				System.out.println("Element is stale currently, trying to click again.");
			}
		}
	}
	public static void clickAnyButtonDirectXpath(String xpathButton) { //same as above but uses a direct xpath rather than a property.
		while(true) {
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathButton)));
			WebElement buttonToClick = dr.findElement(By.xpath(xpathButton));
			try {
				a
						.moveToElement(buttonToClick)
						.click()
						.build()
						.perform();
				break;
			}
			catch (MoveTargetOutOfBoundsException e){
				System.out.println("Element is out of bounds, scrolling to it.");
				scrollToElementDirectXpath(xpathButton);
			}
			catch (StaleElementReferenceException e){
				System.out.println("Element is stale currently, trying to click again.");
			}
		}
	}
}
/*I want to find a way to
 * catch any MoveTargetOutOfBoundsException in any method
 * if it is caught, Identify the webelement being searched for and scroll to immediately. scrollToElement() can do the scrolling part, but it needs the webelement xpath property.
 * */
