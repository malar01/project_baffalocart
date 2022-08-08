package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends ObjectUtility {
    public WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement password_reset_link;

    @FindBy(xpath="//span[@class='help-block']//strong[text()=\"We can't find a user with that e-mail address.\"]")
    WebElement error_message;

    public void enterEmail(String userEmail) {
        page.enterText(email, userEmail);
    }
    public void clickResetLink(){
        page.clickOnElement(password_reset_link);
    }
    public String getErrorMessage(){
        String text=page.getElementText(error_message);
        return text;
    }
}
