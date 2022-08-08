package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends ObjectUtility {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement login;

    @FindBy(xpath="//a[@class='btn btn-link']")
    WebElement forgot_link;
    @FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
    WebElement endTour;

    @FindBy(xpath = "//span[text()='Aju Mathew']")
    WebElement useraccountname;

    @FindBy(xpath="//strong[text()='These credentials do not match our records.']")
    WebElement error_mssg;

    @FindBy(xpath="//input[@name='remember']")
    WebElement remember_chk;
    public String getLoginPageTitle() {
        String title = page.getPageTitle(driver);
        return title;
    }

    public void readTitleFromExcel() {
        page.getPageTitle(driver);
    }
    public void enterUserName(String uname){
        page.enterText(username,uname);
    }

    public void giveExplicitWait(){
        wait.waitUntilVisibilityOfElement(30,driver,username);
            }
    public void enterPassword(String pass){
        page.enterText(password,pass);
    }

    public void clickCheckBox(){
        page.clickOnElement(remember_chk);
    }
    public ResetPasswordPage clickForgotPasswordLink(){
        page.clickOnElement(forgot_link);
        return new ResetPasswordPage(driver);
    }
    public HomePage enterLoginButton() {
        page.clickOnElement(login);
        return new HomePage(driver);
    }
    public String displayErrorMessage(){
        String text=page.getElementText(error_mssg);
        return text;
    }
    public boolean isCheckBoxSelected(){
        boolean check_selected=page.getElementIsSelected(remember_chk);
        return check_selected;
    }

    public void enterButtonEndTour() {
        page.clickOnElement(endTour);
    }
}

