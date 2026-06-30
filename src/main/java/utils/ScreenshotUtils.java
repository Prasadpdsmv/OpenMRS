package utils;

import Base.DriverManager;
import Base.DriverUtilites;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils extends DriverUtilites {

    public static byte[] captureScreenshot() {

        return ((TakesScreenshot)
                DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}