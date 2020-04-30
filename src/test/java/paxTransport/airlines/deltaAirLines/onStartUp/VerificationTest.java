package paxTransport.airlines.deltaAirLines.onStartUp;

import org.testng.annotations.BeforeClass;

import static paxTransport.universal.HelperMethods.uRLVerificationMethod;
import static paxTransport.universal.Initializer.proSpecific;

public class VerificationTest {
	@BeforeClass
	public static void urlVerificationTest(){
		uRLVerificationMethod(proSpecific.getProperty("homeURL"));
	}
}
