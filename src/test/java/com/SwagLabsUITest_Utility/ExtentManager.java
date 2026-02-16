package com.SwagLabsUITest_Utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    private static void createInstance() {

        // Fixed file name (NO timestamp)
        String reportPath = System.getProperty("user.dir")
                + "/TestReports/ExtentReport.html";

        

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter(reportPath);

        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setReportName("Demo Sauce Project Test Report");
        sparkReporter.config().setDocumentTitle("Automation Report");
       

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // ✅ System info
        extent.setSystemInfo("Framework", "TestNG + Selenium");
        extent.setSystemInfo("Tester", "Anand");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("OS Version", System.getProperty("os.version"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
    }
}
