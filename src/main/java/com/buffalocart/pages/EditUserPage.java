package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage extends ObjectUtility {
    public WebDriver driver;
    public EditUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//input[@id='email']")
    WebElement email;
    @FindBy(xpath="//button[@id='submit_user_button']")
    WebElement update_button;

    public void clear_email_field(){
        wait.waitUntilVisibilityOfElement(20,driver,email);
        //wait.hardWait(1000);
        page.clearText(email);
    }
    public String enter_edit_email(){
        //wait.hardWait(5000);
        wait.waitUntilVisibilityOfElement(20,driver,email);
        String new_email=random.getRandomString("email");
        page.enterText(email,new_email);
        return new_email;
    }
    public UsersPage update_editUser_changes(){
        wait.waitUntilVisibilityOfElement(10,driver,update_button);
        page.clickOnElement(update_button);
        return new UsersPage(driver);
    }
}
