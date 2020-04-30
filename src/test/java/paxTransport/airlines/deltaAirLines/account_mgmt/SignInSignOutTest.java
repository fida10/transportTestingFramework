package paxTransport.airlines.deltaAirLines.account_mgmt;

import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.account_mgmt.SignInSignOut.signIn;
import static paxTransport.commonWebSiteFeatures.account_mgmt.SignInSignOut.signOut;
import static paxTransport.commonWebSiteFeatures.randomFeatures.CloseDialogBox.closePopUpDialogBox;

public class SignInSignOutTest extends VerificationTest {
	@Test
	public static void loginTest() throws InterruptedException{
		signIn("xpathLogInButton", "xpathUserNameInputBox", "xpathPasswordInputBox", "xpathLogInSubmitButton");
	}
	@Test (dependsOnMethods = "loginTest")
	public static void logout(){
		closePopUpDialogBox("xpathCloseFeedBackPopUp");
		SignInSignOut.displayLogOutButton("xpathOpenAccountOptions");
		signOut("xpathLogOutButton");
	}
}
