package testlistener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {

	public void onTestStart(ITestResult res) {
		System.out.println("Test Start Pass..."+res.getTestName());
	}
	
	public void onTestSucess(ITestResult res) {
		System.out.println("Test Sucess Pass..."+res.getTestName());
	}
	
	public void onTestFailure(ITestResult res) {
		System.out.println("Test Failure Status.."+res.getTestName());
	}
}
