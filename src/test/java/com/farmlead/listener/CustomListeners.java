package com.farmlead.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.farmlead.Base.TestBase;
//import com.farmlead.Utilities.ExtentManager;
import com.farmlead.Utilities.ExtentManager;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {

	ExtentTest test;
	static String messageBody;
	ExtentReports extent = ExtentManager.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);

//String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
//extentTest.get().pass("<b>" + "<font color=" + "red>" + "Exception Occured:Click to see" + "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",",  "<br>")+"</details>"+"\n");

		try {
//TestUtil.captureScreenshot();
//extentTest.get().pass("<b>" + "<font color=" + "red" + "Screenshot of failure" + "</font>" + "</b>", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName).build());
//test.info(""+test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)));
//test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
			Thread.sleep(2000);
			extentTest.get().log(Status.PASS, "Test Passed");
			test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));

		} catch (Exception e) {
			extentTest.get().log(Status.PASS, e.getMessage());
// TODO Auto-generated catch block
			/*
			 * String failureLogg=" TEST CASE FAILED"; Markup m =
			 * MarkupHelper.createLabel(failureLogg,ExtentColor.RED);
			 * extentTest.get().log(Status.FAIL,m);
			 */

		}
//extentTest.get().log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
// TODO Auto-generated method stub

//String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
//extentTest.get().fail("<b>" + "<font color=" + "red>" + "Exception Occured:Click to see" + "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",",  "<br>")+"</details>"+"\n");

		try {
//TestUtil.captureScreenshot();
//extentTest.get().fail("<b>" + "<font color=" + "red" + "Screenshot of failure" + "</font>" + "</b>", MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName).build());
//test.fail("Passed  "+test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)));
			Thread.sleep(2000);
			String failureLogg = " TEST CASE FAILED";
			Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
			extentTest.get().log(Status.FAIL, m);
//extentTest.get().log(Status.FAIL, "Test Failed");
			test.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));

		} catch (Exception e) {
			extentTest.get().log(Status.PASS, e.getMessage());
			/*
			 * String failureLogg=" TEST CASE FAILED"; Markup m =
			 * MarkupHelper.createLabel(failureLogg,ExtentColor.RED);
			 * extentTest.get().log(Status.FAIL,m);
			 */

		}
//extentTest.get().log(Status.FAIL, "Test Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
// TODO Auto-generated method stub

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:-" + methodName + "Skipped" + "</b>";
		ITestListener.super.onTestSkipped(result);
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().skip(m);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	public void onFinish(ISuite arg0) {
		/*
		 * MonitoringMail mail =new MonitoringMail();
		 *
		 * try { messageBody = "http:// "+InetAddress.getLocalHost().getHostAddress() +
		 * ":8080/job/LanterProject/Extent_Reports/";
		 *
		 * }catch(UnknownHostException e) { e.printStackTrace(); }
		 *
		 *
		 * try { mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to,
		 * TestConfig.subject, TestConfig.messageBody); }catch(AddressException e){
		 * e.printStackTrace(); }catch(MessagingException e) { e.printStackTrace();
		 *
		 * }
		 */
	}

	public void onStart(ISuite arg0) {

	}

	@Override
	public void onFinish(ITestContext context) {
// TODO Auto-generated method stub
		
		if (extent != null) {
			System.out.print("Flush report");
			extent.flush();
		}else {
			System.out.print("No Flush report");
		}

		ITestListener.super.onFinish(context);
	}

}
