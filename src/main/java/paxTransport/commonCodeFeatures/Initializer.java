package paxTransport.commonCodeFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static paxTransport.commonCodeFeatures.HelperMethods.getPathToProps;
import static paxTransport.commonWebSiteFeatures.webElements.ConvertPropToWebElement.convertPropToWebElement;

public class Initializer {
	public static Properties proUniv;
	public static Properties proSpecific;
	public static WebDriver dr;
	public static WebElement nextWebElement; //a common reference point for all tests
	private static void propertiesInitializer(String nameOfUnivPropFile, String nameOfSpecifPropFile) throws IOException {
		proUniv = new Properties(); //declare these and avoid nullpointerexception
		proSpecific = new Properties();

		proUniv.load(getPathToProps(nameOfUnivPropFile));
		proSpecific.load(getPathToProps(nameOfSpecifPropFile));//change based on test suite
	} //probably the only method in the the entire suite not drawing from properties, because this INITIALIZES properties!
	private static void webDriverInitializer(String browserToUse){
		//String browserToUse = proUniv.getProperty("browserToUse"); Formerly used this way, could change the browser from the properties. New format changes browser from testNG xml files directly
		if (browserToUse.equalsIgnoreCase("chrome")){
			System.setProperty(proUniv.getProperty("chromeKey"), proUniv.getProperty("chromeDriverPath"));
			dr = new ChromeDriver();
		} else if (browserToUse.equalsIgnoreCase("firefox")){
			System.setProperty(proUniv.getProperty("fireFoxKey"), proUniv.getProperty("firefoxDriverPath"));
			dr = new FirefoxDriver();
		}
		dr.manage().deleteAllCookies();
		dr.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		dr.manage().window().maximize();
	}
	private static void getHomePage(){
		String homeURL = proSpecific.getProperty("homeURL");
		dr.get(homeURL);
		nextWebElement = convertPropToWebElement("xpathAReliableElement");
	}
	public static void quitter(){
		dr.quit();
	}
	public static void initialStartUpTasksUnifiedMethod(String nameOfSpecifPropFile, String browserToUse) throws IOException {
		propertiesInitializer("universalProperties.properties", nameOfSpecifPropFile); //as the univeral property file will always stay the same, it can stay fixed pointed towards the universal properties file. The specific prop file is dynamic and is stated as such.
		webDriverInitializer(browserToUse);
		getHomePage();
	}
}
