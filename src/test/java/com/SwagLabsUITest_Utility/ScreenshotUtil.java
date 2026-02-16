package com.SwagLabsUITest_Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        String time = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss")
                .format(new Date());

        String path = System.getProperty("user.dir")
                + "/Screenshot/" + testName + "_" + time + ".png";

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}
