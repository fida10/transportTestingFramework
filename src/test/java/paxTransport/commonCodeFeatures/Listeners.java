package paxTransport.commonCodeFeatures;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static paxTransport.commonCodeFeatures.ScreenShotMethods.mkDirFromDatePath;
import static paxTransport.commonCodeFeatures.ScreenShotMethods.screenShotTaker;

public class Listeners implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		// screenShotTaker("teststart");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		screenShotTaker("pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		screenShotTaker("fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		screenShotTaker("skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		mkDirFromDatePath();
	}

	@Override
	public void onFinish(ITestContext context) {
		//screenShotTaker("suitefinish");

	}
}
