package com.SwagLabsUITest_Utility;


	import org.testng.ITestContext;
	import com.SwagLabsUITest_Utility.ScreenshotUtil;
	import com.SwagLabsUITest.Base.BaseClass;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.*;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.markuputils.ExtentColor;

	public class ExtentITestNGListeners implements ITestListener {

	    ExtentReports extent = ExtentManager.getInstance();
	    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTest extentTest =
	                extent.createTest(result.getMethod().getMethodName());

	        test.set(extentTest);
	        test.get().info("Test Started");
	        test.get().info("Method|Mean|Error|Stdev");
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.get().pass(
	                MarkupHelper.createLabel("TEST PASSED", ExtentColor.GREEN));
	        String path = ScreenshotUtil.capture(
	                BaseClass.driver,
	                result.getMethod().getMethodName());

	        test.get().addScreenCaptureFromPath(path, "Pass Screenshot");
	    }
	    

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.get().fail(
	                MarkupHelper.createLabel("TEST FAILED", ExtentColor.RED));
	        test.get().fail(result.getThrowable());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.get().skip(
	                MarkupHelper.createLabel("TEST SKIPPED", ExtentColor.ORANGE));
	    }
	    
	    

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	}



