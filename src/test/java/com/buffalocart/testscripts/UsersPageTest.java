package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersPageTest extends Base {
HomePage home;
ExcelUtility excel;
LoginPage login;
UsersPage usersPage;
    @Test(description = "TC_0010_Verify Users page title")
    public void verifyUsersPage(){
        usersPage=new UsersPage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        login.giveExplicitWait();
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        login.enterButtonEndTour();
        home.clickUserManagement();
        home.clickUsers();
        home.clickUsers();
        usersPage=home.clickUserPage();
        String expected_title=excel.readSingleData(1,0,"UsersPageTitle");
        String actual_title=usersPage.getUsersPageTitle();
        Assert.assertEquals(actual_title,expected_title,"ERROR:Title Mismatch");
    }
}
