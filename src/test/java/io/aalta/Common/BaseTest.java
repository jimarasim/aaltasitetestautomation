package io.aalta.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.PrintWriter;
import java.util.logging.Level;

public class BaseTest {
    protected WebDriver driver = null;
    protected BrowserEnum browser = BrowserEnum.CHROME;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void BeforeTest(@Optional("CHROME") String browser) throws Exception{
        //set desired browser
        this.browser = BrowserEnum.valueOf(browser);

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

        if(browser == BrowserEnum.CHROME) {
            //specify the location of chromedriver (download chromedriver to working directory)
            //you can get chromedriver at https://chromedriver.chromium.org/downloads
            //specify the right one for the version of chrome you have installed
            System.setProperty("webdriver.chrome.driver", "./chromedriver");

            //create the driver.
            driverToLaunch = new ChromeDriver();
        } else if (browser == BrowserEnum.FIREFOX) {
            //https://github.com/mozilla/geckodriver
            System.setProperty("webdriver.gecko.driver", "./geckodriver");

            //create the driver.
            driverToLaunch = new FirefoxDriver();
        }

        return driverToLaunch;
    }
}
