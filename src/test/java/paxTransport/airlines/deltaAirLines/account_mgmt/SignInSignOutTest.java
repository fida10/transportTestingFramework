package paxTransport.airlines.deltaAirLines.account_mgmt;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.inputBox.StaleElementInputBoxHandling.handleStaleElement_InputBox;
import static paxTransport.commonWebSiteFeatures.clicking.CloseDialogBox.closePopUpDialogBox;
import static paxTransport.commonWebSiteFeatures.webElements.ScrollToWebElement.scrollToElement;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayed;

public class SignInSignOutTest extends VerificationTest {
	@Parameters({"xpathLogInButtonProp", "xpathUserNameInputBoxProp", "validUserNameProp", "xpathPasswordInputBoxProp", "validPasswordProp"})
	@Test (priority = 0)
	public static void validLoginTest(String xpathLogInButtonProp, String xpathUserNameInputBoxProp, String validUserNameProp, String xpathPasswordInputBoxProp, String validPasswordProp){
		clickAnyButton(xpathLogInButtonProp); //clicks the login button
		handleStaleElement_InputBox(xpathUserNameInputBoxProp, validUserNameProp); //takes care of username portion
		handleStaleElement_InputBox(xpathPasswordInputBoxProp, validPasswordProp); //takes care of password portion
	}
	@Parameters({"xpathLastNameInputBoxProp", "validLastNameProp"})
	@Test (priority = 1)
	public static void validLastNameInput(String xpathLastNameInputBoxProp, String validLastNameProp){
		handleStaleElement_InputBox(xpathLastNameInputBoxProp, validLastNameProp);
	}
	@Parameters({"xpathLogInSubmitButtonProp"})
	@Test (priority = 2)
	public static void clickLoginSubmitButton(String xpathLogInSubmitButtonProp){
		clickAnyButton(xpathLogInSubmitButtonProp); //clicks the submit button
	}
	@Parameters({"xpathCloseFeedBackPopUpProp"})
	@Test (priority = 3)
	public static void closeLoginSurveyBox(String xpathCloseFeedBackPopUpProp){
		closePopUpDialogBox(xpathCloseFeedBackPopUpProp);
	}
	@Parameters({"xpathOpenAccountOptionsProp"})
	@Test (priority = 4)
	public static void displayLogOutButton(String xpathOpenAccountOptionsProp){ //logout button sometimes needs to be displayed because it is hidden away in a menu somewhere. This opens that menu.
		SignInSignOut.displayLogOutButton(xpathOpenAccountOptionsProp);
	}
	@Parameters({"xpathLogOutButtonProp"})
	@Test (priority = 5)
	public static void scrollToLogOutButton(String xpathLogOutButtonProp){ //scrolls to the logout button
		scrollToElement(xpathLogOutButtonProp);
	}
	@Parameters({"xpathLogOutButtonProp"})
	@Test (priority = 6)
	public static void logOut(String xpathLogOutButtonProp){
		clickAnyButton(xpathLogOutButtonProp); //clicks the logout button
	}
	@Parameters({"xpathLogInButtonProp"}) //Checks to ensure that the login button is present, which is evidence that logout has occured. It makes sense that the login button will be visible if logged out.
	@Test (priority = 7)
	public static void logoutConfirmationPage(String xpathLogInButtonProp){
		Assert.assertTrue(checkIfElementIsDisplayed(xpathLogInButtonProp));
	}
}
