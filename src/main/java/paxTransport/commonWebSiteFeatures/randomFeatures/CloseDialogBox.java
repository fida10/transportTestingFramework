package paxTransport.commonWebSiteFeatures.randomFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

import static paxTransport.universal.Initializer.dr;
import static paxTransport.universal.Initializer.proSpecific;

public class CloseDialogBox {
	public static void closePopUpDialogBox(String xpathClosePopUpButtonProp){ //good for handling the random dialog boxes (i.e. for surveys, etc.) that appear sometimes and stop workflow.
		Actions a = new Actions(dr);
		try{ //sometimes a survey prompt appears. If this will take care of that.
			a
					.moveToElement(dr.findElement(By.xpath(proSpecific.getProperty(xpathClosePopUpButtonProp))))
					.click()
					.build()
					.perform();
		} catch (NoSuchElementException e) {
			System.out.println("Survey prompt did not appear this time, skipping");
		}
	}
}
