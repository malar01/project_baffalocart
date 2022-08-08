package com.buffalocart.testscripts;

import com.beust.ah.A;
import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class HomePageTest extends Base {
    WaitUtility wait;
    LoginPageTest loginPageTest;
    HomePage home;
    LoginPage login;
    ExcelUtility excel;
    DateUtility date;

    TableUtility table;

    @Test(description = "TC_006_Verify home page title")
    public void verifyHomePageTitle() throws InterruptedException {
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        login.giveExplicitWait();
        home = login.enterLoginButton();
        login.enterButtonEndTour();
        String expected_title = excel.readSingleData(1, 0, "HomePageTitle");
        String actual_title = home.getHomePageTitle();
        System.out.println(actual_title);
        Assert.assertEquals(actual_title, expected_title, "ERROR: Title Mismatch");
    }

    @Test(description = "TC_007_Verify date displayed in home page ")
    public void verifyDateDisplayed() {
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        login.giveExplicitWait();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        login.enterButtonEndTour();
        date = new DateUtility();
        String expected_date = date.getCurrentDate();
        System.out.println(expected_date);
        String actual_date = home.getCurrentDateDisplayed();
        System.out.println(actual_date);
        Assert.assertEquals(actual_date, expected_date, "ERROR:Date Mismatch");
    }

    @Test(description = "TC_008_Verify whether user is navigating to login page by clicking on Sign out button", groups = {"smoke"})
    public void verifySignOutButton() {
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        login.giveExplicitWait();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        login.enterButtonEndTour();
        home.giveExplicitWaitOnUser();
        home.clickOnUserAccount();
        home.giveExplicitWaitOnSignOut();
        home.clickSignOut();
        String expected_title = excel.readSingleData(1, 0, "LoginPageTitle");
        String actual_title = login.getLoginPageTitle();
        Assert.assertEquals(actual_title, expected_title, "ERROR:Title mismatch");
    }

    @Test(description = "TC_009_Verify the User management sub tabs")
    public void verifyUserManagementSubTabs() {
        table = new TableUtility();
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
        boolean actual_user = home.getUser();
        System.out.println(actual_user);
        Assert.assertTrue(actual_user);
        boolean actual_role = home.getRoles();
        System.out.println(actual_role);
        Assert.assertTrue(actual_role);
        boolean actual_sale = home.getSales();
        System.out.println(actual_sale);
        Assert.assertTrue(actual_sale);
    }
}
