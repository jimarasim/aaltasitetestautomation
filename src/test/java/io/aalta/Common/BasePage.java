package io.aalta.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        //SET THE WEBDRIVER USED BY THE PAGE OBJECT
        this.driver = driver;

        //THIS BINDS THE FINDBYs TO THEIR WEBELEMENTS.
        PageFactory.initElements(driver,this);
    }


    public boolean isElementEnabled(WebElement element){
        try {
            if(element.isEnabled() && element.isDisplayed()) {
                return true;
            }
            else{
                return false;
            }
        }catch(NoSuchElementException nsex){
            return false;
        }
    }

    public boolean isTextOnPage(String text) {
        return driver.findElements(By.xpath("//*[contains(text(),'"+text+"')]")).size() > 0;
    }
}
