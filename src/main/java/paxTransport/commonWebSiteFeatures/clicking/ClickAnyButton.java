package paxTransport.commonWebSiteFeatures.clicking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;

public class ClickAnyButton {
	static Actions a = new Actions(dr);
	public static void clickAnyButton(String xpathButtonProp){
		a
				.moveToElement(dr.findElement(By.xpath(proSpecific.getProperty(xpathButtonProp))))
				.click()
				.build()
				.perform();
	}
	public static void clickAnyButtonDirectXpath(String xpathButton){ //same as above but uses a direct xpath rather than a property.
		WebElement buttonToClick = dr.findElement(By.xpath(xpathButton));
		a
				.moveToElement(buttonToClick)
				.click()
				.build()
				.perform();
	}
}
