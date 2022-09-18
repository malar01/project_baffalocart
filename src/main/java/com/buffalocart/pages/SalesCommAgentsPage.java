package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SalesCommAgentsPage extends ObjectUtility {
    public WebDriver driver;

    public SalesCommAgentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn btn-primary btn-modal pull-right']")
    WebElement add_button;

    @FindBy(xpath = "//input[@id='surname']")
    WebElement sales_agent_surname;
    @FindBy(xpath = "//input[@id='first_name']")
    WebElement sales_agent_firstname;
    @FindBy(xpath = "//input[@id='last_name']")
    WebElement sales_agent_lastname;
    @FindBy(xpath = "//input[@id='email']")
    WebElement sales_agent_email;
    @FindBy(xpath = "//input[@id='contact_no']")
    WebElement contact_no;
    @FindBy(xpath = "//textarea[@id='address']")
    WebElement sales_agent_address;
    @FindBy(xpath = "//input[@id='cmmsn_percent']")
    WebElement sales_comm_percentage;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement save_button;
    @FindBy(xpath = "//div[@id='sales_commission_agent_table_filter']//label//input[@class='form-control input-sm']")
    WebElement search_sales_agent;
    @FindBy(xpath = "//table[@id='sales_commission_agent_table']/tbody/tr")
    List<WebElement> rowElements;
    @FindBy(xpath = "//table[@id='sales_commission_agent_table']/tbody/tr/td")
    List<WebElement> cellElements;
    @FindBy(xpath = "//table[@id='sales_commission_agent_table']/tbody/tr/td//button[@class='btn btn-xs btn-modal btn-primary']")
    WebElement edit_sales_agent;

    @FindBy(xpath="//table[@id='sales_commission_agent_table']/tbody/tr/td[6]//button[@class='btn btn-xs btn-modal btn-primary']")
    WebElement edit_changes;

    @FindBy(xpath="//table[@id='sales_commission_agent_table']/tbody/tr/td[6]/button[2]")
    WebElement delete_sale_agent;
    @FindBy(xpath="//div[@class='swal-modal']//div[@class='swal-button-container']//button[@class='swal-button swal-button--confirm swal-button--danger']")
    WebElement ok_button;
    public String getSalesCommAgentPageTitle() {
        String title = page.getPageTitle(driver);
        return title;
    }

    public void click_add_button() {
        wait.waitUntilVisibilityOfElement(10, driver, add_button);
        page.clickOnElement(add_button);
    }

    public void enter_sales_agent_surname(String surname_sales) {
        page.enterText(sales_agent_surname, surname_sales);
    }

    public void get_sales_agent_firstname(String first_name) {
        wait.waitUntilVisibilityOfElement(30, driver, sales_agent_firstname);
        page.enterText(sales_agent_firstname,first_name);
    }

    public void get_sales_agent_lastname(String last_name) {
        page.enterText(sales_agent_lastname, last_name);
    }

    public String get_sales_agent_contact(String contact) {
        page.enterText(contact_no, contact);
        return contact;

    }

    public void get_sales_agent_email(String email) {
        page.enterText(sales_agent_email, email);
    }

    public void get_sales_agent_address(String address) {
        page.enterText(sales_agent_address, address);
    }

    public String get_sales_agent_comm_per(String comm_percent) {
        page.enterText(sales_comm_percentage, comm_percent);
        return comm_percent;
    }

    public void click_save_button() {
        wait.waitUntilVisibilityOfElement(20, driver, save_button);
        page.clickOnElement(save_button);
    }

    public void search_Sales_Agent(String sales_agent) {
        wait.hardWait(500);
        page.enterText(search_sales_agent,sales_agent);
    }

    public List<ArrayList<String>> getTableData() {
        wait.hardWait(5000);
        List<ArrayList<String>> tableData = table.getGridData(rowElements, cellElements);
        return tableData;
    }

    public void click_edit_sales_agent() {
        wait.waitUntilVisibilityOfElement(30,driver,edit_sales_agent);
        page.clickOnElement(edit_sales_agent);
    }

    public void clear_email() {
        wait.hardWait(1000);
        page.clearText(sales_agent_email);
    }

    public void clear_search() {
        wait.hardWait(1000);
        page.clearText(search_sales_agent);
    }
    public void edit_changes(){
        wait.hardWait(1000);
        page.clickOnElement(edit_changes);
    }
    public void click_delete_sales_agent(){
        wait.hardWait(5000);
        page.clickOnElement(delete_sale_agent);
    }
    public void click_delete_ok_button(){
        wait.waitUntilVisibilityOfElement(10,driver,ok_button);
        page.clickOnElement(ok_button);
    }
    public List<ArrayList<String>> getSearchDataAfterDelete() {
        wait.hardWait(5000);
        List<ArrayList<String>> search_data = table.getGridData(rowElements, cellElements);
        return search_data;
    }
}