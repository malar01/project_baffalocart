package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.SalesCommAgentsPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.RandomDataUtility;
import com.buffalocart.utilities.TableUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SalesCommAgentsTest extends Base {
    SalesCommAgentsPage salesCommAgentsPage;
    TableUtility table;
    HomePage home;
    LoginPage login;
    ExcelUtility excel;
    RandomDataUtility random;

    @Test(priority = 29,description = "TC_029_Verify  user can add sales agent ")
    public void verify_user_can_add_sales_agent() {
        random = new RandomDataUtility();
        table = new TableUtility();
        salesCommAgentsPage = new SalesCommAgentsPage(driver);
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
        salesCommAgentsPage = home.click_sub_menu_sales_comm();
        salesCommAgentsPage.click_add_button();
        String fname =random.getRandomString("uname");
        salesCommAgentsPage.get_sales_agent_firstname(fname);
        String lname =random.getRandomString("uname");
        salesCommAgentsPage.get_sales_agent_lastname(lname);
        String email =random.getRandomString("email");
        salesCommAgentsPage.get_sales_agent_email(email);
        String contact = salesCommAgentsPage.get_sales_agent_contact("8864326893");
        String address =random.getRandomString("uname");
        salesCommAgentsPage.get_sales_agent_address(address);
        String sales_per = salesCommAgentsPage.get_sales_agent_comm_per("10.00");
        salesCommAgentsPage.click_save_button();
        salesCommAgentsPage.search_Sales_Agent(email);
        String[] data = {fname.concat(" " + lname), email, contact, address, sales_per};
        List<ArrayList<String>> expectedTable_data = new ArrayList<ArrayList<String>>();
        expectedTable_data.add(new ArrayList<String>(Arrays.asList(data)));
        List<ArrayList<String>> actualTable_data = salesCommAgentsPage.getTableData();
        System.out.println(expectedTable_data);
        System.out.println(actualTable_data);
        Assert.assertEquals(actualTable_data, expectedTable_data, "Error:Invalid data- User doesn't exist");
    }

    @Test(priority = 30,description = "TC_030_Verify Edit sales agent details")
    public void verify_Edit_sales_agent_details() {
        random = new RandomDataUtility();
        table = new TableUtility();
        salesCommAgentsPage = new SalesCommAgentsPage(driver);
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
        salesCommAgentsPage = home.click_sub_menu_sales_comm();
        salesCommAgentsPage.click_add_button();
        String fname =random.getRandomString("uname");
        salesCommAgentsPage.get_sales_agent_firstname(fname);
        String lname =random.getRandomString("uname");
        salesCommAgentsPage.get_sales_agent_lastname(lname);
        String email =random.getRandomString("email");
        salesCommAgentsPage.get_sales_agent_email(email);
        String contact = salesCommAgentsPage.get_sales_agent_contact("8864326893");
        String address =random.getRandomString("uname");
        salesCommAgentsPage.get_sales_agent_address(address);
        String sales_per = salesCommAgentsPage.get_sales_agent_comm_per("10.00");
        salesCommAgentsPage.click_save_button();
        salesCommAgentsPage.search_Sales_Agent(email);
        salesCommAgentsPage.edit_changes();
        salesCommAgentsPage.clear_email();
        String new_mail =random.getRandomString("email");
        salesCommAgentsPage.get_sales_agent_email(new_mail);
        salesCommAgentsPage.click_save_button();
        salesCommAgentsPage.clear_search();
        salesCommAgentsPage.search_Sales_Agent(fname.concat(" "+lname));
        String[] data = {fname.concat(" " +lname),email,contact,address,sales_per};
        List<ArrayList<String>> expectedTable_data = new ArrayList<ArrayList<String>>();
        expectedTable_data.add(new ArrayList<String>(Arrays.asList(data)));
        List<ArrayList<String>> actualTable_data = salesCommAgentsPage.getTableData();
        Assert.assertEquals(actualTable_data,expectedTable_data,"Error:Invalid data- User doesn't exist");
    }
    @Test(priority = 31,description = "TC_031_Verify user can delete a Sales Commission Agents")
    public void verify_user_can_delete_a_Sales_Commission_Agents(){
        random = new RandomDataUtility();
        table = new TableUtility();
        salesCommAgentsPage = new SalesCommAgentsPage(driver);
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
        salesCommAgentsPage = home.click_sub_menu_sales_comm();
        salesCommAgentsPage.click_add_button();
        String first_name =random.getRandomString("uname");
        salesCommAgentsPage.get_sales_agent_firstname(first_name);
        String last_name =random.getRandomString("uname");
        salesCommAgentsPage.get_sales_agent_lastname(last_name);
        String email =random.getRandomString("email");
        salesCommAgentsPage.get_sales_agent_email(email);
        String contact = salesCommAgentsPage.get_sales_agent_contact("8864326893");
        String address =random.getRandomString("uname");
        salesCommAgentsPage.get_sales_agent_address(address);
        String sales_per = salesCommAgentsPage.get_sales_agent_comm_per("10.00");
        salesCommAgentsPage.click_save_button();
        salesCommAgentsPage.search_Sales_Agent(email);
        salesCommAgentsPage.click_delete_sales_agent();
        salesCommAgentsPage.click_delete_ok_button();
        salesCommAgentsPage.clear_search();
        salesCommAgentsPage.search_Sales_Agent(email);
        List<ArrayList<String>> expectedTable_data=salesCommAgentsPage.getSearchDataAfterDelete();
        List<ArrayList<String>> actualTable_data=salesCommAgentsPage.getTableData();
        Assert.assertEquals(actualTable_data,expectedTable_data,"ERROR:Search found with invalid data");
    }
}


