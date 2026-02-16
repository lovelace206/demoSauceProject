package testlistener;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	@Test
	
	public void testreport() {
		//Create Extent Report
		
		ExtentReports extent=new ExtentReports();
		//location fro Report
		
		ExtentSparkReporter spark=new ExtentSparkReporter(System.getProperty("user.dir")+"//TestReports//ExtentReport"+System.currentTimeMillis()+".html");
		//set the Configurations
		spark.config().setDocumentTitle("ReportsTest");
		
		spark.config().setReportName("demoSauceReport");
		
		spark.config().setTheme(Theme.DARK);
		//Attached Reports
		extent.attachReporter(spark);
		
		//to create log create  test first
	ExtentTest test=	extent.createTest("TestReport");
		
		//log
	
	test.log(Status.PASS,"Test case is Pass");
	test.log(Status.FAIL, "Test Case is Fail");
	
	test.log(Status.SKIP, "Test Case is Skip");
	
	test.log(Status.INFO, "Test Case is INFORMATIONS");


	test.log(Status.WARNING, "its is warning");
	
	
	//close the reports
	extent.flush();
	
	}

}
