package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RolePage extends ObjectUtility {
    public WebDriver driver;

    public RolePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//a[@class='btn btn-block btn-primary']")
    WebElement add_role;
    @FindBy(xpath="//table[@id='roles_table']/tbody/tr[2]/td[2]/a")
    WebElement edit_role_page;
    @FindBy(xpath="//input[@class='form-control input-sm']")
    WebElement search_role;
    @FindBy(xpath="//table[@id='roles_table']/tbody/tr")
    List<WebElement> rowElements;
    @FindBy(xpath="//table[@id='roles_table']/tbody/tr/td")
    List<WebElement> cellElements;

    @FindBy(xpath="//a[@class='btn btn-xs btn-primary']")
    WebElement edit_role;
    @FindBy(xpath="//button[@class='btn btn-xs btn-danger delete_role_button']")
    WebElement delete_role;
    @FindBy(xpath="//div[@class='swal-modal']//div[@class='swal-footer']//button[@class='swal-button swal-button--confirm swal-button--danger']")
    WebElement delete_ok_button;

    @FindBy(xpath = "//ul[@class='treeview-menu']//span[1]")
    WebElement users;


    public UsersPage click_users() {
        wait.waitUntilVisibilityOfElement(20, driver, users);
        //wait.hardWait(1000);
        page.mouseHover(driver, users);
        page.clickOnElement(users);
        return new UsersPage(driver);
    }
    public String getRolePgeTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }
    public AddRollPage click_add_role(){
        page.clickOnElement(add_role);
        return new AddRollPage(driver);
    }
    public EditRollPage clickEditRolePage(){
        wait.waitUntilVisibilityOfElement(20,driver,edit_role_page);
        page.clickOnElement(edit_role_page);
    return new EditRollPage(driver);
    }
    public String getEditRollPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }
    public void search_added_role(String new_role){
        wait.hardWait(5000);
        page.enterText(search_role,new_role);
    }
    public List<ArrayList<String>> getTableData(){
        wait.hardWait(5000);
        List<ArrayList<String>> tableData=table.getGridData(rowElements,cellElements);
        return tableData;
    }
    public List<ArrayList<String>> getSearchData(){
        wait.hardWait(5000);
        List<ArrayList<String>> search_data=table.getGridData(rowElements,cellElements);
        return search_data;
    }
    public EditRollPage click_edit_role_to_update(){
        wait.hardWait(5000);
        page.clickOnElement(edit_role);
        return new EditRollPage(driver);
    }
    public void click_delete_role(){
        wait.hardWait(5000);
        page.clickOnElement(delete_role);
    }
    public void click_delete_ok_button(){
        page.clickOnElement(delete_ok_button);
    }
}
