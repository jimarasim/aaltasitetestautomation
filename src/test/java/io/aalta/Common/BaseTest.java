package io.aalta.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URL;


public class BaseTest {
    protected WebDriver driver = null;
    protected BrowserEnum browser;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void BeforeTest(@Optional("CHROME") String browser) throws Exception {
        //set desired browser
        try {
            this.browser = BrowserEnum.valueOf(browser);
        } catch (IllegalArgumentException ex) {
           Assert.fail("INVALID BROWSER VALUE PASSED:" + browser);
        }

        //Before each test, start the browser and assign the driver to it
        driver = StartDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void AfterTest(ITestResult testResult){

        //take a screenshot on failure
        if(!testResult.isSuccess()) {
            String screenshotFileName = Utilities.screenShot(driver,testResult.getInstanceName());
            System.out.println("TEST FAILURE SCREENSHOT TAKEN:" + screenshotFileName);
        }

        //After each test, close the browser and destroy the browser
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private WebDriver StartDriver() throws Exception {
        WebDriver driverToLaunch = null;
        DesiredCapabilities cap = new DesiredCapabilities();
        String accessKey = "qRNaU9uphj3nGGF3WzZv";
        String userName = "jamesarasim1";

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
        } else if (browser == BrowserEnum.SAFARI) {
            driverToLaunch = new SafariDriver();
        } else if (browser.toString().contains("BROWSERSTACK")) {
            if (browser == BrowserEnum.BROWSERSTACK_SAFARI_IPHONE){
                cap.setCapability("browserName", "iPhone");
                cap.setCapability("device", "iPhone 8 Plus");
                cap.setCapability("realMobile", "true");
                cap.setCapability("os_version", browser.version);
                cap.setCapability("name", "Aalta Iphone Test");
            } else {
                cap.setBrowserName(browser.browserName);
                cap.setPlatform(browser.platform);
                cap.setVersion(browser.version);
                cap.setCapability("name", "Aalta "+browser.browserName+" "+browser.platform+" TEST");
            }

            driverToLaunch = new RemoteWebDriver(new URL("http://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), cap);
        } else {
            throw new Exception("UNEXPECTED STARTDRIVER()");
        }




        return driverToLaunch;
    }
}
