package io.aalta.Tests;


import io.aalta.Common.BaseTest;
import io.aalta.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Home page test for
 */
public class HomeFillOutFormNoCaptchcaTest extends BaseTest
{
    @Test
    public void fillOutAndSubmitFormWithNoCaptchca() throws InterruptedException
    {
        HomePage homePage = new HomePage(driver);

        homePage.navigate();

        homePage.filloutName("James").filloutEmail("james@aalta.io").filloutMessage("Filling out the form");
        homePage.clickSendButton().waitForErrorMessage();

        Assert.assertTrue(homePage.isTextOnPage("The Captcha field cannot be blanka."));
    }
}
