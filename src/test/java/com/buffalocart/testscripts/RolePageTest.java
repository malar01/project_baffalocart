package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

public class RolePageTest extends Base {
    AddUsersPage addUsersPage;
    EditRollPage editRollPage;
    AddRollPage addRolePage;
    HomePage home;
    LoginPage login;
    ExcelUtility excel;
    WaitUtility wait;
    RolePage rolePage;
    UsersPage usersPage;
@Test(priority = 22,description = "TC_022_Verify Add Roles page title")
    public void  verify_Add_Roles_page_title(){
    addRolePage=new AddRollPage(driver);
    rolePage=new RolePage(driver);
    home = new HomePage(driver);
    excel = new ExcelUtility();
    login = new LoginPage(driver);
    String name = excel.readSingleData(1, 0, "LoginPage");
    login.enterUserName(name);
    String pass = excel.readSingleData(1, 1, "LoginPage");
    login.enterPassword(pass);
    home = login.enterLoginButton();
    home.enterButtonEndTour();
    home.clickUserManagement();
    rolePage=home.click_sub_menu_role();
    addRolePage=rolePage.click_add_role();
    String actual_title= addRolePage.get_add_role_page_title();
    String expected_title= excel.readSingleData(1,0,"AddRolePageTitle");
    Assert.assertEquals(actual_title,expected_title,"ERROR:Title Mismatch");
}
@Test(priority = 24,description ="TC_024_Verify Edit Role page title")
    public void verify_Edit_Role_page_title(){
    addRolePage=new AddRollPage(driver);
    rolePage=new RolePage(driver);
    home = new HomePage(driver);
    excel = new ExcelUtility();
    login = new LoginPage(driver);
    String name = excel.readSingleData(1, 0, "LoginPage");
    login.enterUserName(name);
    String pass = excel.readSingleData(1, 1, "LoginPage");
    login.enterPassword(pass);
    home = login.enterLoginButton();
    home.enterButtonEndTour();
    home.clickUserManagement();
    rolePage=home.click_sub_menu_role();
    editRollPage=rolePage.clickEditRolePage();
    String actual_title=rolePage.getEditRollPageTitle();
    String expected_title=excel.readSingleData(1,0,"EditRolePageTitle");
    Assert.assertEquals(actual_title,expected_title,"ERROR:Title Mismatch");
    }
    @Test(priority = 23,description = "TC_023_Verify  user can add roles",groups = {"smoke"})
    public void verify_user_can_add_roles(){
        addRolePage=new AddRollPage(driver);
        rolePage=new RolePage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        rolePage=home.click_sub_menu_role();
        addRolePage=rolePage.click_add_role();
        addRolePage.set_role_name("Coordinator");
        addRolePage.chk_select_users();
        addRolePage.chk_select_roles();
        addRolePage.chk_select_supplier();
        addRolePage.chk_select_customer();
        addRolePage.chk_select_product();
        addRolePage.chk_select_purchase();
        addRolePage.chk_select_sell();
        addRolePage.chk_select_brand();
        addRolePage.chk_select_tax_rate();
        addRolePage.chk_select_unit();
        addRolePage.chk_select_category();
        addRolePage.chk_select_report();
        addRolePage.chk_select_settings();
        addRolePage.chk_select_account();
        rolePage=addRolePage.click_save_add_role_page();
        rolePage.search_added_role("Coordinator");
        List<ArrayList<String>> expectedTable_data=rolePage.getSearchData();
        List<ArrayList<String>> actualTable_data=rolePage.getTableData();
        Assert.assertEquals(actualTable_data,expectedTable_data,"ERROR:Search found with invalid data");
    }
    @Test(priority = 25,description = "TC_025_Verify user can update a role")
    public void verify_user_can_update_a_role(){
        addRolePage=new AddRollPage(driver);
        rolePage=new RolePage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        rolePage=home.click_sub_menu_role();
        addRolePage=rolePage.click_add_role();
        addRolePage.set_role_name("Coordinator");
        addRolePage.chk_select_users();
        addRolePage.chk_select_roles();
        addRolePage.chk_select_supplier();
        addRolePage.chk_select_customer();
        addRolePage.chk_select_product();
        addRolePage.chk_select_purchase();
        addRolePage.chk_select_sell();
        addRolePage.chk_select_brand();
        addRolePage.chk_select_tax_rate();
        addRolePage.chk_select_unit();
        addRolePage.chk_select_category();
        addRolePage.chk_select_report();
        addRolePage.chk_select_settings();
        addRolePage.chk_select_account();
        rolePage=addRolePage.click_save_add_role_page();
        rolePage.search_added_role("Coordinator");
        editRollPage=rolePage.click_edit_role_to_update();
        editRollPage.clear_text_area();
        String new_role=editRollPage.enter_new_role("Test");
        rolePage=editRollPage.click_update_role_button();
        rolePage.search_added_role(new_role);
        List<ArrayList<String>> expectedTable_data=rolePage.getSearchData();
        List<ArrayList<String>> actualTable_data=rolePage.getTableData();
        Assert.assertEquals(actualTable_data,expectedTable_data,"ERROR:Search found with invalid data");

    }
    @Test(priority = 26,description = "TC-026_Verify user can delete a role from the list")
    public void verify_user_can_delete_a_role_from_the_list(){
        addRolePage=new AddRollPage(driver);
        rolePage=new RolePage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        rolePage=home.click_sub_menu_role();
        addRolePage=rolePage.click_add_role();
        addRolePage.set_role_name("Test1");
        addRolePage.chk_select_users();
        addRolePage.chk_select_roles();
        addRolePage.chk_select_supplier();
        addRolePage.chk_select_customer();
        addRolePage.chk_select_product();
        addRolePage.chk_select_purchase();
        addRolePage.chk_select_sell();
        addRolePage.chk_select_brand();
        addRolePage.chk_select_tax_rate();
        addRolePage.chk_select_unit();
        addRolePage.chk_select_category();
        addRolePage.chk_select_report();
        addRolePage.chk_select_settings();
        addRolePage.chk_select_account();
        rolePage=addRolePage.click_save_add_role_page();
        rolePage.search_added_role("Test1");
        rolePage.click_delete_role();
        rolePage.click_delete_ok_button();
        List<ArrayList<String>> expectedTable_data=rolePage.getSearchData();
        List<ArrayList<String>> actualTable_data=rolePage.getTableData();
        Assert.assertEquals(actualTable_data,expectedTable_data,"ERROR:Search found with invalid data");
    }
}
