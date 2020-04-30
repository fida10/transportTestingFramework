package paxTransport.airlines.deltaAirLines.onStartUp;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static paxTransport.universal.Initializer.initialStartUpTasksUnifiedMethod;
import static paxTransport.universal.Initializer.quitter;

public class StartUpTest {
	@BeforeSuite
	public static void initializer() throws IOException {
		initialStartUpTasksUnifiedMethod("deltaAirLinesProperties.properties");
	}
	@AfterSuite
	public static void end(){
		quitter();
	}
}
