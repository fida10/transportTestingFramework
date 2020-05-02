package paxTransport.commonWebSiteFeatures.inputBox;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;

public class SendKeysAndAutoCompleteInputBox {
	static Actions a = new Actions(dr);
	public static void sendKeysToInputBox(String keysToSendProp){
		a
				.sendKeys(proSpecific.getProperty(keysToSendProp))
				.build()
				.perform();
	}
	public static void selectFirstAutoCompleteOption(){
		a
				.sendKeys(Keys.ARROW_DOWN)
				.sendKeys(Keys.ENTER)
				.build()
				.perform();
	}
}
