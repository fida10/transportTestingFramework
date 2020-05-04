package paxTransport.commonWebSiteTests.account_mgmt;

import org.testng.Assert;
import org.testng.annotations.Test;
import paxTransport.airlines.deltaAirLines.account_mgmt.SignInSignOut;
import paxTransport.commonWebSiteTests.onStartUp.VerificationTest;

import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;
import static paxTransport.commonWebSiteFeatures.inputBox.EnsureValueSentToInputBox.ensureValueSentToInputBox;
import static paxTransport.commonWebSiteFeatures.inputBox.StaleElementInputBoxHandling.handleStaleElement_InputBox;
import static paxTransport.commonWebSiteFeatures.clicking.CloseDialogBox.closePopUpDialogBox;
import static paxTransport.commonWebSiteFeatures.webElements.isDisplayedLoopThru.checkIfElementIsDisplayed;

public class SignInSignOutTest extends VerificationTest {
	/*@Parameters({"xpathLogInButton"})
	@Test (priority = 0)
	public static void nextWebElementPointerOne(String xpathLogInButton){
		nextWebElement = convertToWebElement(xpathLogInButton); /*A common web element. A nextWebElementPointer method will set this as the first webElement used for the next test. @BeforeMethods can then be used to run various actions on the element, i.e. check it's visibility, if it is enabled, scroll to it, etc.
	 It is set to commonElementOnAllWebSites which points to //html. This is a common element present on every website, and it also ensures that nullpointerexception is avoided.
	} */
	@Test (priority = 1)
	public static void validLoginTest(){
		clickAnyButton("xpathLogInButton"); //clicks the login button
		handleStaleElement_InputBox("xpathUserNameInputBox", "validUserName"); //takes care of username portion
		handleStaleElement_InputBox("xpathPasswordInputBox", "validPassword"); //takes care of password portion
	}
	/*@Parameters({"xpathLastNameInputBox"})
	@Test (priority = 2)
	public static void nextWebElementPointerFive(String xpathLastNameInputBox){
		nextWebElement = convertToWebElement(xpathLastNameInputBox); /*A common web element. A nextWebElementPointer method will set this as the first webElement used for the next test. @BeforeMethods can then be used to run various actions on the element, i.e. check it's visibility, if it is enabled, scroll to it, etc.
	 It is set to commonElementOnAllWebSites which points to //html. This is a common element present on every website, and it also ensures that nullpointerexception is avoided.
	}*/
	@Test (priority = 3)
	public static void validLastNameInput(){
		handleStaleElement_InputBox("xpathLastNameInputBox", "validLastName"); //verifies the last name was sent properly to box before clicking submit button
		ensureValueSentToInputBox("xpathLastNameInputBox", "validLastName");
	}
	/* @Parameters({"xpathLogInSubmitButton"})
	@Test (priority = 4)
	public static void nextWebElementPointerTwo(String xpathLogInSubmitButton){
		nextWebElement = convertToWebElement(xpathLogInSubmitButton);
	}*/
	@Test (priority = 5)
	public static void clickLoginSubmitButton(){
		ensureValueSentToInputBox("xpathUserNameInputBox", "validUserName"); //verifies the username was sent properly to box before clicking submit button
		ensureValueSentToInputBox("xpathPasswordInputBox", "validPassword"); //verifies the password was sent properly to box before clicking submit button
		clickAnyButton("xpathLogInSubmitButton"); //clicks the submit button
	}
	@Test (priority = 6)
	public static void closeLoginSurveyBox(){
		closePopUpDialogBox("xpathCloseFeedBackPopUp");
	}
	/*@Parameters({"xpathOpenAccountOptions"})
	@Test (priority = 7)
	public static void nextWebElementPointerThree(String xpathOpenAccountOptions){
		nextWebElement = convertToWebElement(xpathOpenAccountOptions);
	}*/
	@Test (priority = 8)
	public static void displayLogOutButton(){ //logout button sometimes needs to be displayed because it is hidden away in a menu somewhere. This opens that menu.
		SignInSignOut.displayLogOutButton("xpathOpenAccountOptions");
	}
	/*@Parameters({"xpathLogOutButton"})
	@Test (priority = 9)
	public static void nextWebElementPointerFour(String xpathLogOutButton){
		nextWebElement = convertToWebElement(xpathLogOutButton);
	}*/
	@Test (priority = 10)
	public static void logOut(){
		clickAnyButton("xpathLogOutButton"); //clicks the logout button
	}
	//Checks to ensure that the login button is present, which is evidence that logout has occured. It makes sense that the login button will be visible if logged out.
	@Test (priority = 11)
	public static void logoutConfirmationPage(){
		Assert.assertTrue(checkIfElementIsDisplayed("xpathLogInButton"));
	}
}
