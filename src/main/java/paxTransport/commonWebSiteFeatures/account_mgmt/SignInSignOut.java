package paxTransport.commonWebSiteFeatures.account_mgmt;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;

import static paxTransport.universal.Initializer.dr;
import static paxTransport.universal.Initializer.proSpecific;

public class SignInSignOut {
	public static void signIn(String xpathLogInButtonProp, String xpathUserNameInputBoxProp, String xpathPasswordInputBoxProp, String xpathLogInSubmitButtonProp) throws InterruptedException{
		Actions a = new Actions(dr);
		a
				.moveToElement(dr.findElement(By.xpath(proSpecific.getProperty(xpathLogInButtonProp))))
				.click()
				.build()
				.perform();
		while(true) {
			try { //the username box sometimes throws a stale element exception. needs to be handled
				a
						.moveToElement(dr.findElement(By.xpath(proSpecific.getProperty(xpathUserNameInputBoxProp))))
						.click()
						.build()
						.perform();
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale element exception is thrown, refreshing.");
				dr.navigate().refresh();
			}
		}
		Thread.sleep(100); //slight delay to slow down the program and allow the website to catch up to it. In this case, to accept input into the skymiles box.
		a //gap given because selenium is too fast for the website; sometimes it doesn't send the keys properly so having these actions separate should ensure keys are sent
				.sendKeys(proSpecific.getProperty("validUserName"))
				.build()
				.perform();
		a
				.moveToElement(dr.findElement(By.xpath(proSpecific.getProperty(xpathPasswordInputBoxProp))))
				.click()
				.build()
				.perform();
		a //gap given because selenium is too fast for the website; sometimes it doesn't send the keys properly so having these actions separate should ensure keys are sent
				.sendKeys(proSpecific.getProperty("validPassword"))
				.build()
				.perform();
		a
				.moveToElement(dr.findElement(By.xpath(proSpecific.getProperty(xpathLogInSubmitButtonProp))))
				.click()
				.build()
				.perform();
	}
	public static void signOut(String xpathLogOutButtonProp){
		Actions a = new Actions(dr);
		a
				.moveToElement(dr.findElement(By.xpath(proSpecific.getProperty(xpathLogOutButtonProp))))
				.click()
				.build()
				.perform();
	}
}
