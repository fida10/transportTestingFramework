package paxTransport.commonWebSiteFeatures.webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;

public class ScrollToWebElement {
	public static void scrollToElement(String xpathToElementProp){
		WebDriverWait w = new WebDriverWait(dr, 3);
		WebElement elementToScrollTo = dr.findElement(By.xpath(proSpecific.getProperty(xpathToElementProp)));
		JavascriptExecutor js = ((JavascriptExecutor)dr);
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
		w.until(ExpectedConditions.visibilityOf(elementToScrollTo));
		System.out.println("Successfully scrolled to specified element");
	}
	public static void scrollToElementDirectXpath(String xpathToElement){
		WebDriverWait w = new WebDriverWait(dr, 3);
		WebElement elementToScrollTo = dr.findElement(By.xpath(xpathToElement));
		JavascriptExecutor js = ((JavascriptExecutor)dr);
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
		w.until(ExpectedConditions.visibilityOf(elementToScrollTo));
		System.out.println("Successfully scrolled to specified element");
	}
	public static void scrollToElementDirectWebElement(WebElement wbToScrollTo){
		WebDriverWait w = new WebDriverWait(dr, 3);
		JavascriptExecutor js = ((JavascriptExecutor)dr);
		js.executeScript("arguments[0].scrollIntoView(true);", wbToScrollTo);
		w.until(ExpectedConditions.visibilityOf(wbToScrollTo));
		System.out.println("Successfully scrolled to specified element");
	}
}