package paxTransport.commonCodeFeatures;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import static paxTransport.commonCodeFeatures.HelperMethods.getAbsPath;
import static paxTransport.commonCodeFeatures.Initializer.dr;

public class ScreenShotMethods { //DateTimeFormatter is an older method. Attempt to do the below with a newer methodology.
	private static String fileDirectToSaveScreenShots;
	private static String getDateToStringPath(){
		String dateFormat = "yyyy/MM/dd hh:mm:ss a";
		DateTimeFormatter dtForm = DateTimeFormatter.ofPattern(dateFormat); //formats a passed date value into the pattern specified

		LocalDateTime current = LocalDateTime.now(); //gets current date and time at point of creation
		String formattedDate = dtForm.format(current);
		String fileDirToSaveScreenShots = getAbsPath().concat("out//success_fail_screenshots//").concat(formattedDate); //this path will be used to save screenshots
		return fileDirToSaveScreenShots;
	}
	public static void mkDirFromDatePath(){
		String fileDirToSaveScreenShots = getDateToStringPath();
		boolean fileMadeSuccess = new File(fileDirToSaveScreenShots).mkdir(); //gets the date path created above and makes an actual path of directories to it
		System.out.println("Was the screenshot directory made successfully? " + fileMadeSuccess);
		fileDirectToSaveScreenShots = fileDirToSaveScreenShots;
	}
	public static void screenShotTaker(String passFailSkip){ //defines screenshots for each test start, pass, fail, skip, and the suite start and suite finish. Test start, suite start and finish are tmp disabled on Listeners because they make too many folders, need a better way to organize this.
		try {
			//mkDirFromDatePath();
			File screenShot = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
			if(passFailSkip.equalsIgnoreCase("pass")){
				FileUtils.copyFileToDirectory(screenShot, new File(fileDirectToSaveScreenShots.concat("//success")));
			} else if (passFailSkip.equalsIgnoreCase("fail")) {
				FileUtils.copyFileToDirectory(screenShot, new File(fileDirectToSaveScreenShots.concat("//fail")));
			} else if (passFailSkip.equalsIgnoreCase("skip")) {
				FileUtils.copyFileToDirectory(screenShot, new File(fileDirectToSaveScreenShots.concat("//skip")));
			} else {
				FileUtils.copyFileToDirectory(screenShot, new File(fileDirectToSaveScreenShots.concat("//unknown")));
			}
		} catch (WebDriverException e) { //for exception handling as throws doesn't work in the listener methods
			System.out.println("Webdriver exception thrown.");
		} catch (IOException e) {
			System.out.println("IO exception thrown");
		}
	}
	public static void deleteOldScreenShots() throws IOException{
		FileUtils.deleteDirectory(new File(getAbsPath().concat("out//success_fail_screenshots"))); //can be called to delete old screenshots
	}
}
