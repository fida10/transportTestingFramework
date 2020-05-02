package paxTransport.commonWebSiteFeatures.inputBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static paxTransport.commonCodeFeatures.Initializer.dr;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;
import static paxTransport.commonWebSiteFeatures.clicking.ClickAnyButton.clickAnyButton;

public class SelectAndVerifyDynamicDropDown { //note that this method uses "getText" to get the values of the drop down element and the current value within the dropdown. May not work for items that don't have text or use another attribute. Direct input box will need a version of this method that uses getAttribute("value").
	static Actions a = new Actions(dr);
	public static void selectAndVerifyDynamicDropDown(String xpathDropDownProp, String xpathToDropDownElementProp){
		openDropDown(xpathDropDownProp);
		selectAndVerifyDropDownContents(xpathDropDownProp, xpathToDropDownElementProp);
	}
	public static void selectAndVerifyDynamicDropDownDynamicXpath(String xpathDropDownProp, String xpathToDropDownElement){ //this basically does the same thing as the above but is used for dynamic xpaths that are made within the program. The second argument takes a direct xpath rather than a property from props.
		openDropDown(xpathDropDownProp);
		selectAndVerifyDropDownContentsSecondElementDirectXpath(xpathDropDownProp, xpathToDropDownElement);
	}
	private static void openDropDown(String xpathDropDownProp){ //this method will find the dropdown to open, and click on it, thereby opening it up. It will additionally set this dropdown as the global dropDownBeingAnalyzed WebElement variable, for use in the second method.
		clickAnyButton(xpathDropDownProp);
	}
	private static String returnDropDownValue(String xpathDropDownProp){
		WebElement dropDown = dr.findElement(By.xpath(proSpecific.getProperty(xpathDropDownProp)));
		String dropDownCurrentValue = dropDown.getText();
		return dropDownCurrentValue;
	}
	private static void selectAndVerifyDropDownContents(String xpathDropDownProp, String xpathToDropDownElementProp){ //this method selects the element within the dropdown specified in properties. It also gets its text, and then clicks on it. It then compares this text with the text currently in the dropdown. If they are the same, the loop is exited. If they are not, it runs openDropDown and tries to select the right option from the dropdown again.
		WebElement dropDownElementToSelect = dr.findElement(By.xpath(proSpecific.getProperty(xpathToDropDownElementProp)));
		String dropDownElementToSelectValue = dropDownElementToSelect.getText();
		while(true) {
			a
					.moveToElement(dropDownElementToSelect)
					.click()
					.build()
					.perform();
			String currentDropDownValue = returnDropDownValue(xpathDropDownProp);
			if (currentDropDownValue.contains(dropDownElementToSelectValue)){
				System.out.println("Desired value is selected, breaking loop");
				break;
			} else {
				System.out.println("Selected the wrong value! Trying again.");
				openDropDown(xpathDropDownProp);
			}
		}
	}
	private static void selectAndVerifyDropDownContentsSecondElementDirectXpath(String xpathDropDownProp, String xpathToDropDownElement){ //this method selects the element within the dropdown specified in properties. It also gets its text, and then clicks on it. It then compares this text with the text currently in the dropdown. If they are the same, the loop is exited. If they are not, it runs openDropDown and tries to select the right option from the dropdown again.
		WebElement dropDownElementToSelect = dr.findElement(By.xpath(xpathToDropDownElement));
		String dropDownElementToSelectValue = dropDownElementToSelect.getText();
		while(true) {
			a
					.moveToElement(dropDownElementToSelect)
					.click()
					.build()
					.perform();
			String currentDropDownValue = returnDropDownValue(xpathDropDownProp);
			if (currentDropDownValue.contains(dropDownElementToSelectValue)){
				System.out.println("Desired value is selected, breaking loop");
				break;
			} else {
				System.out.println("Selected the wrong value! Trying again.");
				openDropDown(xpathDropDownProp);
			}
		}
	}
}
