package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditRollPage extends ObjectUtility {
    public WebDriver driver;

    public EditRollPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;
    @FindBy(xpath = "//button[@id='submit_user_button']")
    WebElement update_button;
    @FindBy(xpath="//ins[@class='iCheck-helper']")
    WebElement demo_company;

    @FindBy(xpath = "//input[@id='name']")
    WebElement role_name;
    @FindBy(xpath="//button[@class='btn btn-primary pull-right']")
    WebElement update_role_button;
    public void clear_email_id() {
        wait.hardWait(1000);
        page.clearText(email);
    }

    public void set_email(String email_id) {
        page.enterText(email, email_id);
    }

    public UsersPage click_update_button() {
        //wait.waitUntilVisibilityOfElement(10, driver, update_button);
        page.clickOnElement(update_button);
        return new UsersPage(driver);
    }
    public void click_demo_company(){
        page.clickOnElement(demo_company);
    }
    public void clear_text_area(){
        page.clearText(role_name);
    }
    public String enter_new_role(String new_role_name){
    page.enterText(role_name,new_role_name);
    return new_role_name;
    }

    public RolePage click_update_role_button(){
        page.clickOnElement(update_role_button);
        return new RolePage(driver);
    }
}
