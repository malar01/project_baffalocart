package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddUsersPage extends ObjectUtility {
    public WebDriver driver;

    public AddUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='surname']")
    WebElement surname;

    @FindBy(xpath="//input[@id='first_name']")
    WebElement first_name;
    @FindBy(xpath="//input[@id='last_name']")
    WebElement last_name;
    @FindBy(xpath="//input[@id='email']")
    WebElement email;

    @FindBy(xpath="//select[@id='role']")
    WebElement select_role;


    @FindBy(xpath="//div[@class='form-group']//input[@id='username']")
    WebElement username;
    @FindBy(xpath="//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='confirm_password']")
    WebElement confirm_password;
    @FindBy(xpath="//input[@id='cmmsn_percent']")
    WebElement commission_percent;
    @FindBy(xpath = "//ins[@class='iCheck-helper']")
    WebElement check1;
    @FindBy(xpath="//select[@class='form-control select2 select2-hidden-accessible']")
    WebElement select_contacts;
    @FindBy(xpath = "//ins[@class='iCheck-helper']")
    WebElement is_active;
    @FindBy(xpath="//button[@id='submit_user_button']")
    WebElement save_button;

    @FindBy(xpath="xpath=\"//select[@id='role']")
    List<WebElement> list_role;

   public String set_surname(String sur_name) {
        page.enterText(surname, sur_name);
        return sur_name;
    }
    public void set_first_name(String fname){
        page.enterText(first_name,fname);
    }
    public void set_last_name(String lname){
        page.enterText(last_name,lname);
    }
    public void set_email(String email_id){
        page.enterText(email,email_id);
    }


    public String select_role_from_drop_down(String selectrole){
        page.getSelectByVisibleText(select_role,selectrole);
        return selectrole;
    }

    public void set_username(String user_name){
        page.enterText(username, user_name);
    }
    public void set_password(String pass){
        page.enterText(password,pass);
    }
    public void set_confirm_password(String confirm_pass){
        page.enterText(confirm_password,confirm_pass);
    }
    public void set_commission_percentage(String comm_per){
        page.enterText(commission_percent,comm_per);
    }
    public void select_check1(){
        page.clickOnElement(check1);
    }
    public void select_contacts(String contacts){
        page.getSelectByVisibleText(select_contacts,contacts);
    }
    public void select_isactive(){
        page.getSelectByIndex(is_active,2);
    }

    public UsersPage click_save_button(){
        wait.waitUntilVisibilityOfElement(10,driver,save_button);
       // wait.hardWait(1000);
        page.clickOnElement(save_button);
        return new UsersPage(driver);
    }

}
