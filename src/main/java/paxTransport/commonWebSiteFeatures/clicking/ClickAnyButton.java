package paxTransport.commonWebSiteFeatures.clicking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;
import static paxTransport.commonWebSiteFeatures.webElements.ScrollToWebElement.scrollToElement;
import static paxTransport.commonWebSiteFeatures.webElements.ScrollToWebElement.scrollToElementDirectXpath;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayed;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayedDirectXpath;

public class ClickAnyButton { //in addition to clicking any button, this class will also scroll to a button if it exists in the page but throws a MoveTargetOutOfBoundsException, and verifies if that element is visible.
	static Actions a = new Actions(dr);
	public static void clickAnyButton(String xpathButtonProp){
		a
				.moveToElement(dr.findElement(By.xpath(proSpecific.getProperty(xpathButtonProp))))
				.click()
				.build()
				.perform();
	}
	public static void clickAnyButtonDirectXpath(String xpathButton) { //same as above but uses a direct xpath rather than a property.
		WebElement buttonToClick = dr.findElement(By.xpath(xpathButton));
		a
				.moveToElement(buttonToClick)
				.click()
				.build()
				.perform();
	}
}
/*I want to find a way to
 * catch any MoveTargetOutOfBoundsException in any method
 * if it is caught, Identify the webelement being searched for and scroll to immediately. scrollToElement() can do the scrolling part, but it needs the webelement xpath property.
 * */
