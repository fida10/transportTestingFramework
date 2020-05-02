package paxTransport.airlines.deltaAirLines.onStartUp;

import org.testng.annotations.BeforeClass;

import static paxTransport.commonCodeFeatures.HelperMethods.uRLVerificationMethod;
import static paxTransport.commonCodeFeatures.Initializer.proSpecific;

public class VerificationTest {
	@BeforeClass
	public static void urlVerificationTest(){ //verifies that test is running on correct URL
		uRLVerificationMethod(proSpecific.getProperty("homeURL"));
	}
}
