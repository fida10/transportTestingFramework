package paxTransport.commonWebSiteFeatures.clicking;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;

public class ClickAnyButton {
	public static void clickAnyButton(String xpathButtonProp){
		Actions a = new Actions(dr);
		a
				.moveToElement(dr.findElement(By.xpath(proSpecific.getProperty(xpathButtonProp))))
				.click()
				.build()
				.perform();
	}
}
