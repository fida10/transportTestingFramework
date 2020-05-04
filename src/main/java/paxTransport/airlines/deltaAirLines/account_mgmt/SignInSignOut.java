package paxTransport.airlines.deltaAirLines.account_mgmt;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;
import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.inputBox.StaleElementInputBoxHandling.handleStaleElement_InputBox;

public class SignInSignOut {
	public static void displayLogOutButton(String xpathOpenAccountOptionsProp){
		Actions a = new Actions(dr);
		a
				.moveToElement(dr.findElement(By.xpath(proSpecific.getProperty(xpathOpenAccountOptionsProp))))
				.click()
				.build()
				.perform();
	}
}
