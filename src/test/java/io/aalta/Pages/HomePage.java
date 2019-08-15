package io.aalta.Pages;

import io.aalta.Common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(id="form-field-name")
    private WebElement nameTextBox;

    @FindBy(id="form-field-email")
    private WebElement emailTextBox;

    @FindBy(id="form-field-message")
    private WebElement messageTextbox;

    @FindBy(css="button.elementor-button")
    private WebElement sendButton;

    @FindBy(xpath="//div[@role='alert' and contains(text(),'An error occured.')]")
    private WebElement errorMessage;

    private String homePageUrl = "https://aalta.io";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage navigate() {
        //load the home page
        driver.get(homePageUrl);

        return this;
    }

    public boolean formElementsEnabled() {
        return(isElementEnabled(nameTextBox) && isElementEnabled(emailTextBox) && isElementEnabled(messageTextbox));
    }

    public HomePage filloutName(String name) {
        nameTextBox.sendKeys(name);

        return this;
    }

    public HomePage filloutEmail(String email) {
        emailTextBox.sendKeys(email);

        return this;
    }

    public HomePage filloutMessage(String message) {
        messageTextbox.sendKeys(message);

        return this;
    }

    public HomePage clickSendButton() {
        sendButton.click();

        return this;
    }

    public HomePage waitForErrorMessage() {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOf(errorMessage));

        return this;
    }
}
