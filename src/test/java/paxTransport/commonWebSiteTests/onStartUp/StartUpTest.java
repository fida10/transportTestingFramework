package paxTransport.commonWebSiteTests.onStartUp;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;

import static paxTransport.commonCodeFeatures.Initializer.initialStartUpTasksUnifiedMethod;
import static paxTransport.commonCodeFeatures.Initializer.quitter;

public class StartUpTest {
	@Parameters({"specificPropertiesFile", "browserToUse"})
	@BeforeSuite
	public static void initializer(String specificPropertiesFile, String browserToUse) throws IOException {
		initialStartUpTasksUnifiedMethod(specificPropertiesFile, browserToUse);
	}
	@AfterSuite
	public static void end(){
		quitter();
	}
}
