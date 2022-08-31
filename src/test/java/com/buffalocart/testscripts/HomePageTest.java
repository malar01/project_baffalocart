package com.buffalocart.testscripts;

import com.beust.ah.A;
import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.RolePage;
import com.buffalocart.pages.SalesCommAgentsPage;
import com.buffalocart.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HomePageTest extends Base {
    WaitUtility wait;

    SalesCommAgentsPage salesCommAgentsPage;
    LoginPageTest loginPageTest;
    HomePage home;
    LoginPage login;
    ExcelUtility excel;
    DateUtility date;

    TableUtility table;

    RolePage rolePage;
    @Test(priority=6,description = "TC_006_Verify home page title")
    public void verifyHomePageTitle() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        String expected_title = excel.readSingleData(1, 0, "HomePageTitle");
        String actual_title = home.getHomePageTitle();
        System.out.println(actual_title);
        Assert.assertEquals(actual_title, expected_title, "ERROR: Title Mismatch");
    }

    @Test(priority=7,description = "TC_007_Verify date displayed in home page ")
    public void verifyDateDisplayed() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        date = new DateUtility();
        String expected_date = date.getCurrentDate();
        System.out.println(expected_date);
        String actual_date = home.getCurrentDateDisplayed();
        System.out.println(actual_date);
        Assert.assertEquals(actual_date, expected_date, "ERROR:Date Mismatch");
    }

    @Test(priority=8,description = "TC_008_Verify whether user is navigating to login page by clicking on Sign out button", groups = {"smoke"})
    public void verifySignOutButton() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.giveExplicitWaitOnUser();
        home.clickOnUserAccount();
        home.giveExplicitWaitOnSignOut();
        home.clickSignOut();
        String expected_title = excel.readSingleData(1, 0, "LoginPageTitle");
        String actual_title = login.getLoginPageTitle();
        Assert.assertEquals(actual_title, expected_title, "ERROR:Title mismatch");
    }


    @Test(description = "TC_021_Verify Roles page title")
    public void verify_Role_Page_Title(){
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
        String actual_title=rolePage.getRolePgeTitle();
        String expected_title= excel.readSingleData(1,0,"RolePageTitle");
        Assert.assertEquals(actual_title,expected_title,"ERROR:Title Mismatch");
    }
    @Test(description = "TC_028_Verify  Sales Commission Agents page title")
    public void verify_Sales_Commission_Agents_page_title(){
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
        salesCommAgentsPage=home.click_sub_menu_sales_comm();
        String actual_title=salesCommAgentsPage.getSalesCommAgentPageTitle();
        String expected_title=excel.readSingleData(1,0,"SalesCommAgentPageTitle");
        Assert.assertEquals(actual_title,expected_title,"ERROR:Title Mismatch");
    }
}
