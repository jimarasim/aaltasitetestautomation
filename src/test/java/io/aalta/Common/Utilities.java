package io.aalta.Common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {
    public static String screenShot(WebDriver driver, String fileName) {
        String filePath = "screenshots/" + fileName + getDateStamp() + ".png";

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //save whole page screenshot for reference
        try {
            FileUtils.copyFile(screenshot, new File(filePath));
        } catch (IOException ex) {
            System.out.println("COULD NOT SAVE SCREENSHOT:" + ex.getMessage());
        }

        return filePath;
    }

    public static String getDateStamp() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        return myDateObj.format(myFormatObj);
    }
}
