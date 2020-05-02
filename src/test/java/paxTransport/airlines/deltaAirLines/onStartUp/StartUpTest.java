package paxTransport.airlines.deltaAirLines.onStartUp;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;

import static paxTransport.commonCodeFeatures.Initializer.initialStartUpTasksUnifiedMethod;
import static paxTransport.commonCodeFeatures.Initializer.quitter;

public class StartUpTest {

	@Parameters({"specificPropertiesFile"})
	@BeforeSuite
	public static void initializer(String specificPropertiesFile) throws IOException {
		initialStartUpTasksUnifiedMethod(specificPropertiesFile);
	}
	@AfterSuite
	public static void end(){
		quitter();
	}
}
