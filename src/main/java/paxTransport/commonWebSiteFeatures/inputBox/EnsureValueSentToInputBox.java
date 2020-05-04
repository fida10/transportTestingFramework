package paxTransport.commonWebSiteFeatures.inputBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;

public class EnsureValueSentToInputBox {
	public static void ensureValueSentToInputBox(String xpathToInputBoxProp, String valueToSendProp){ //assumes that box is prepopulated, thought it doesn't have to be. Method works fine on blank boxes as well. Combine with handleStaleElement_InputBox() method to ensure stale element issue is handled.
		WebElement inputBox = dr.findElement(By.xpath(proSpecific.getProperty(xpathToInputBoxProp)));

		Actions a = new Actions(dr);
		while(true) {
			String inputBoxCurrentValue = inputBox.getAttribute("value");
			if (inputBoxCurrentValue.contains(proSpecific.getProperty(valueToSendProp))) {
				System.out.println("Value was sent properly" + " Current value is " + inputBoxCurrentValue);
				break;
			}
			else {
				System.out.println("values not equal, restarting");
				System.out.println("Current value is " + inputBoxCurrentValue);
				inputBox.click(); //in case there is already a value and it is wrong, input box will be cleared to input the correct value using 'a' below.
			}
			a
					.moveToElement(inputBox)
					.click()
					.sendKeys(proSpecific.getProperty(valueToSendProp))
					.build()
					.perform();
		}
	}
}
