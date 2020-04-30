package paxTransport.universal;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static paxTransport.universal.HelperMethods.getAbsPath;
import static paxTransport.universal.Initializer.dr;

public class ScreenShotMethods {
	private static String getDateToStringPath(){
		String dateFormat = "yyyy/MM/dd hh:mm a";
		SimpleDateFormat sDF = new SimpleDateFormat(dateFormat); //formats a passed date value into the pattern specified

		Calendar cal = Calendar.getInstance(); //gets current date and time at point of creation
		String formattedDate = sDF.format(cal);
		String fileDirToSaveScreenShots = getAbsPath().concat("out//success_fail_screenshots").concat(formattedDate); //this path will be used to save screenshots
		return fileDirToSaveScreenShots;
	}
	private static String mkDirFromDatePath(){
		String fileDirToSaveScreenShots = getDateToStringPath();
		boolean fileMadeSuccess = new File(fileDirToSaveScreenShots).mkdir(); //gets the date path created above and makes an actual path of directories to it
		System.out.println("Was the screenshot directory made successfully? " + fileMadeSuccess);
		return fileDirToSaveScreenShots; //this was not directly called from the getDateToStringPath() because then the method would be run again, which would mean the time would be different on the second run resulting in a different directory.
	}
	public static void screenShotTaker(String passFailSkip) throws IOException {
		String fileDirToSaveScreenShots = mkDirFromDatePath();
		File screenShot = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		if(passFailSkip.equalsIgnoreCase("pass")){
			FileUtils.copyFileToDirectory(screenShot, new File(fileDirToSaveScreenShots.concat("//success")));
		} else if (passFailSkip.equalsIgnoreCase("fail")) {
			FileUtils.copyFileToDirectory(screenShot, new File(fileDirToSaveScreenShots.concat("//fail")));
		} else if (passFailSkip.equalsIgnoreCase("skip")){
			FileUtils.copyFileToDirectory(screenShot, new File(fileDirToSaveScreenShots.concat("//skip")));
		} else {
			FileUtils.copyFileToDirectory(screenShot, new File(fileDirToSaveScreenShots.concat("//unknown")));
		}
	}
	public static void deleteOldScreenShots() throws IOException{
		FileUtils.deleteDirectory(new File(getAbsPath().concat("out//success_fail_screenshots"))); //can be called to delete old screenshots
	}
}
