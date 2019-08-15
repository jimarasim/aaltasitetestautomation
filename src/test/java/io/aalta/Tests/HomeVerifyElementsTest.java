package io.aalta.Tests;


import io.aalta.Common.BaseTest;
import io.aalta.Pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Home page test for
 */
public class HomeVerifyElementsTest extends BaseTest
{
    @Test
    public void shouldHaveElements()
    {
        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.navigate().formElementsEnabled());
    }

}
