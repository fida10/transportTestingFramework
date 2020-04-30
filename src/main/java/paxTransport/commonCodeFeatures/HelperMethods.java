package paxTransport.commonCodeFeatures;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static paxTransport.commonCodeFeatures.Initializer.dr;

public class HelperMethods {
	public static String getAbsPath(){
		String absPath = new File("").getAbsolutePath().concat("//"); //it'll add the backslashes after the absolute path
		return absPath;
	}
	public static FileInputStream getPathToProps(String nameOfPropFile) throws IOException {
		String absPath = getAbsPath().concat("");
		FileInputStream propertiesFile = new FileInputStream(absPath.concat(String.format("properties//%s", nameOfPropFile)));
		return propertiesFile;
	}
	public static void uRLVerificationMethod(String URLToMatch) {
		String currentURL = dr.getCurrentUrl();

		while (true) {
			if (currentURL.contains(URLToMatch)) {
				System.out.println("Currently on " + currentURL + " --- Good to continue");
				break;
			} else {
				System.out.println("Currently on " + currentURL + " --- Wrong URL, refreshing");
				dr.get(URLToMatch);
			}
		}
	}
}
