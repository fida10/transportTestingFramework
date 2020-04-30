package paxTransport.commonCodeFeatures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static paxTransport.commonCodeFeatures.HelperMethods.getPathToProps;

public class Initializer {
	public static Properties proUniv;
	public static Properties proSpecific;
	public static WebDriver dr;
	private static void propertiesInitializer(String nameOfUnivPropFile, String nameOfSpecifPropFile) throws IOException {
		proUniv = new Properties(); //declare these and avoid nullpointerexception
		proSpecific = new Properties();

		proUniv.load(getPathToProps(nameOfUnivPropFile));
		proSpecific.load(getPathToProps(nameOfSpecifPropFile));//change based on test suite
	} //probably the only method in the the entire suite not drawing from properties, because this INITIALIZES properties!
	private static void webDriverInitializer(){
		String browserToUse = proUniv.getProperty("browserToUse");
		if (browserToUse.equalsIgnoreCase("chrome")){
			System.setProperty(proUniv.getProperty("chromeKey"), proUniv.getProperty("chromeDriverPath"));
			dr = new ChromeDriver();
		} else if (browserToUse.equalsIgnoreCase("firefox")){
			System.setProperty(proUniv.getProperty("fireFoxKey"), proUniv.getProperty("firefoxDriverPath"));
			dr = new FirefoxDriver();
		}
		dr.manage().deleteAllCookies();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.manage().window().maximize();
	}
	private static void getHomePage(){
		String homeURL = proSpecific.getProperty("homeURL");
		dr.get(homeURL);
	}
	public static void quitter(){
		dr.quit();
	}
	public static void initialStartUpTasksUnifiedMethod(String nameOfSpecifPropFile) throws IOException {
		propertiesInitializer("universalProperties.properties", nameOfSpecifPropFile); //as the univeral property file will always stay the same, it can stay fixed pointed towards the universal properties file. The specific prop file is dynamic and is stated as such.
		webDriverInitializer();
		getHomePage();
	}
}
