package paxTransport.airlines.deltaAirLines.account_mgmt;

import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.inputBox.StaleElementInputBoxHandling.handleStaleElement_InputBox;
import static paxTransport.commonWebSiteFeatures.clicking.CloseDialogBox.closePopUpDialogBox;
//program to use parameters to increase dynamic nature
public class SignInSignOutTest extends VerificationTest {
	@Test
	public static void validLoginTest() throws InterruptedException{
		clickAnyButton("xpathLogInButton"); //clicks the login button
		handleStaleElement_InputBox("xpathUserNameInputBox", "validUserName"); //takes care of username portion
		handleStaleElement_InputBox("xpathPasswordInputBox", "validPassword"); //takes care of password portion
		clickAnyButton("xpathLogInSubmitButton"); //clicks the submit button
	}
	@Test (dependsOnMethods = "validLoginTest")
	public static void logout(){
		closePopUpDialogBox("xpathCloseFeedBackPopUp");
		SignInSignOut.displayLogOutButton("xpathOpenAccountOptions");
		clickAnyButton("xpathLogOutButton"); //clicks the logout button
	}
}
