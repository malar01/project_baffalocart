package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersPage extends ObjectUtility {
    public WebDriver driver;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='title']/following::span[2]")
    WebElement users;

    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement click_add_button;


    @FindBy(xpath="//table[@id='users_table']/tbody/tr/td[5]/a[1]")
    WebElement edit_user_page;


    @FindBy(xpath="//div[@id='users_table_filter']//input[@class='form-control input-sm']")
    WebElement search;

    @FindBy(xpath="//section[@class='content']//table[@id='users_table']/tbody/tr[1]/td[4]")
    WebElement actual_email_id;

    @FindBy(xpath = "//table[@id='users_table']/tbody/tr")
    List<WebElement> rowElements;
    @FindBy(xpath = "//table[@id='users_table']/tbody/tr/td")
    List<WebElement> cellElements;

    @FindBy(xpath="//label[@id='email-error']")
    WebElement error_message;
    @FindBy(xpath="//a[@class='dropdown-toggle']//span")
    WebElement locate_user_account;
    @FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
    WebElement sign_out_user_account;
    @FindBy(xpath="//table[@id='users_table']/tbody/tr/td[5]//button")
    WebElement delete_button;
    @FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
    WebElement delete_alert_button;
    @FindBy(xpath="//table[@id='users_table']/tbody/tr")
    List<WebElement> record_rows;
    @FindBy(xpath="//table[@id='users_table']/tbody/tr/td")
    List<WebElement> record_col;

    @FindBy(xpath="//table[@id='users_table']/tbody/tr/td[5]/a[2]")
    WebElement view_button;

    @FindBy(xpath="//table[@id='users_table']/tbody/tr/td[text()='No matching records found']")
    WebElement search_result;
    @FindBy(xpath="//table[@id='users_table']/tbody/tr/td[1]")
    WebElement no_records;

    @FindBy(xpath="//table[@id='users_table']/tbody/tr/td[1]")
    WebElement invalidUserSearchResult;
    public String list_record(){
        wait.hardWait(5000);
        String text=page.getElementText(no_records);
        return text;
    }
    public String getInvalidUserSearchResult(){
        wait.hardWait(5000);
        String text=page.getElementText(invalidUserSearchResult);
        return text;
    }
    public String get_search_result(){
        wait.hardWait(5000);
        String text=page.getElementText(search_result);
        return text;
    }
    public List<ArrayList<String>> getTableData(){
        wait.hardWait(5000);
        List<ArrayList<String>> tableData=table.getGridData(rowElements,cellElements);
        return tableData;
    }
    public List<ArrayList<String>> getInvalidSearchData(){
        wait.hardWait(5000);
        List<ArrayList<String>> search_data=table.getGridData(record_rows,record_col);
        return search_data;
    }
    public String getUsersPageTitle() {
        String title = page.getPageTitle(driver);
        return title;
    }


    public AddUsersPage set_Click_add_button() {
        wait.waitUntilVisibilityOfElement(10,driver,click_add_button);
        page.clickOnElement(click_add_button);
        return new AddUsersPage(driver);
    }

    public EditUserPage click_edit_user_page(){
        //wait.waitUntilVisibilityOfElement(50,driver,edit_user_page);
        wait.hardWait(5000);
        page.clickOnElement(edit_user_page);
        return new EditUserPage(driver);
    }


    public String get_edit_page_title(){
        String title=page.getPageTitle(driver);
        return title;
    }
    public void enter_search_value(String search_value){
        //wait.waitUntilVisibilityOfElement(100,driver,search);
        wait.hardWait(5000);
        page.enterText(search,search_value);
    }
    public void clear_search_value(){
        wait.hardWait(1000);
        page.clearText(search);
    }
    public String get_actual_email_id(){
        wait.waitUntilVisibilityOfElement(10,driver,actual_email_id);
        String email_id=page.getElementText(actual_email_id);
        return email_id;
    }
    public String display_error_message(){
        String err_mssg=page.getElementText(error_message);
        return err_mssg;
    }
    public String getAddUserPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }
    public void click_user_account(){
        // wait.waitUntilVisibilityOfElement(50,driver,locate_user_account);
        wait.hardWait(10000);
        page.clickOnElement(locate_user_account);
    }
    public LoginPage click_Sign_out_user_account(){
        wait.waitUntilVisibilityOfElement(10,driver,sign_out_user_account);
        page.clickOnElement(sign_out_user_account);
        return new LoginPage(driver);
    }
    public String getAccountName(){
        String actual_account_name=page.getElementText(locate_user_account);
        return actual_account_name;
    }
    public void click_delete_button(){
        wait.waitUntilVisibilityOfElement(100,driver,delete_button);
        page.clickOnElement(delete_button);
    }
    public void click_alert_ok_button(){
        wait.waitUntilVisibilityOfElement(20,driver,delete_alert_button);
        page.clickOnElement(delete_alert_button);
    }

    public ViewUserPage click_view_button(){
        //wait.waitUntilVisibilityOfElement(10,driver,edit_user_page);
        wait.hardWait(5000);
        page.clickOnElement(view_button);
        return new ViewUserPage(driver);
    }
}