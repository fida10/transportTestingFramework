package paxTransport.commonWebSiteFeatures.inputBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;

public class EnsureValueSentToInputBox {
	public static void ensureValueSentToInputBox(String xpathToInputBoxProp, String valueToSendProp){
		WebElement inputBox = dr.findElement(By.xpath(proSpecific.getProperty(xpathToInputBoxProp)));
		Actions a = new Actions(dr);
		while(true) {
			a
					.moveToElement(inputBox)
					.click()
					.sendKeys(proSpecific.getProperty(valueToSendProp))
					.build()
					.perform();
			String inputBoxCurrentValue = inputBox.getAttribute("value");
			if (inputBoxCurrentValue.contains(proSpecific.getProperty(valueToSendProp))) {
				System.out.println("Value was sent properly" + " Current value is " + inputBoxCurrentValue);
				break;
			}
			else {
				System.out.println("values not equal, restarting");
				System.out.println("Current value is " + inputBoxCurrentValue);
			}
		}
	}
}
