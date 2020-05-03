package paxTransport.commonWebSiteFeatures.clicking;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;

public class CloseDialogBox {
	public static void closePopUpDialogBox(String xpathClosePopUpButtonProp){ //good for handling the random dialog boxes (i.e. for surveys, etc.) that appear sometimes and stop workflow.
		Actions a = new Actions(dr);
		try{ //sometimes a survey prompt appears. If this will take care of that. This works for most other dialog boxes too.
			WebDriverWait w = new WebDriverWait(dr, 3);
			w.until(ExpectedConditions.visibilityOf(dr.findElement(By.xpath(proSpecific.getProperty(xpathClosePopUpButtonProp)))));
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
