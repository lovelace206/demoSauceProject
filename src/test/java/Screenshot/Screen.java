package Screenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screen {

    public static void capture(WebDriver driver, String testName)
            throws IOException {

        // create folder if missing
        File folder = new File("Screenshottestcase");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File(
            folder + "/" + testName + "_" +
            System.currentTimeMillis() + ".png"
        );

        FileHandler.copy(source, destination);

        System.out.println("Screenshot saved → " + destination.getAbsolutePath());
    }
}
