
package genericUtility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static void captureScreenshot(
            WebDriver driver, String testName) throws IOException {

        if (driver == null) {
            return;
        }

        Path folder = Paths.get("ScreenShot");

        String safeName = testName.replaceAll(
                "[^a-zA-Z0-9._-]", "_");

        String timestamp = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));

        Path file = folder.resolve(
                safeName + "_" + timestamp + ".png");

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        Files.write(file, screenshot);

        System.out.println(
                "Screenshot saved: " + file.toAbsolutePath());
    }
}
