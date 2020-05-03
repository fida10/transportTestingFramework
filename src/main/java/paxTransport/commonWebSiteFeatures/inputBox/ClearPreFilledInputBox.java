package paxTransport.commonWebSiteFeatures.inputBox;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;

public class ClearPreFilledInputBox {
	public static void clearPreFilledInputBox(String xpathOpenDepCitySelectorProp){ //will clear the box and click on it again, in case the clear operation deselects the box.
		Actions a = new Actions(dr);
		WebElement inputBoxToClear = dr.findElement(By.xpath(proSpecific.getProperty(xpathOpenDepCitySelectorProp)));
		inputBoxToClear.clear();
		a
				.moveToElement(inputBoxToClear)
				.click()
				.build()
				.perform();

	}
}
