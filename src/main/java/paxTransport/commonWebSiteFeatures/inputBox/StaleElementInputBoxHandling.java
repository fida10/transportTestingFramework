package paxTransport.commonWebSiteFeatures.inputBox;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;
import static paxTransport.commonWebSiteFeatures.inputBox.EnsureValueSentToInputBox.ensureValueSentToInputBox;

public class StaleElementInputBoxHandling {
	public static void handleStaleElement(String xpathToPotentialStaleElementProp){
		while(true){
			try{
				dr.findElement(By.xpath(proSpecific.getProperty(xpathToPotentialStaleElementProp)));
				System.out.println("WebElement found successfully!");
				break; //this ensures that the webelement is first found and it is not stale, before sending values to it.
			} catch (StaleElementReferenceException e){
				System.out.println("Stale element exception is thrown, refreshing.");
				dr.navigate().refresh();
			}

		}
	}
	public static void handleStaleElement_InputBox(String xpathInputBoxProp, String valueToSendProp){ // a unifed method that sends desired values to a specified input box, and checks each step of the way for a stale exception
		while(true){
			try{
				ensureValueSentToInputBox(xpathInputBoxProp, valueToSendProp);
				System.out.println("WebElement found successfully!");
				break; //this ensures that the webelement is first found and it is not stale, before sending values to it.
			} catch (StaleElementReferenceException e){
				System.out.println("Stale element exception is thrown, refreshing.");
				dr.navigate().refresh();
			}

		}
	}
}
