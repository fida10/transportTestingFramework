package paxTransport.commonWebSiteFeatures.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;

public class ConvertPropToWebElement {
	public static WebElement convertPropToWebElement(String xpathToConvertToWebElementProp) { //takes an xpathProperty from properties file and converts it into the respective WebElement that xpath points to.
		WebElement webElementFromProp = dr.findElement(By.xpath(proSpecific.getProperty(xpathToConvertToWebElementProp)));
		return webElementFromProp;
	}
}
