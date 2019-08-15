package io.aalta.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.PrintWriter;
import java.util.logging.Level;

public class BaseTest {
    protected WebDriver driver = null;

    @BeforeMethod(alwaysRun = true)
    public void BeforeTest() throws Exception{
        //Before each test, start the browser and assign the driver to it
        driver = StartDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void AfterTest(ITestResult testResult){
        //After each test, close the browser and destroy the browser
        driver.quit();
        driver = null;
    }

    private WebDriver StartDriver() throws Exception{
        WebDriver driverToLaunch = null;

        //specify the location of chromedriver (download chromedriver to working directory)
        //you can get chromedriver at https://chromedriver.chromium.org/downloads
        //specify the right one for the version of chrome you have installed
        //you would do the same for other browsers like firefox, that uses the geckodriver
        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        //create the driver.
        //here you could also create a driver to a different browser, like FirefoxDriver()
        driverToLaunch = new ChromeDriver();

        return driverToLaunch;
    }
}
