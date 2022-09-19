package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.HomePage;
import com.buffalocart.pages.LoginPage;
import com.buffalocart.pages.ResetPasswordPage;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginPageTest extends Base {

    ResetPasswordPage reset;
    ExcelUtility excel;
    RandomDataUtility random;
    LoginPage login;
    HomePage home;

    @Test(priority = 1, description = "TC_001_Verify Login page title")
    public void verify_Login_Page_Title() {
        login = new LoginPage(driver);
        excel = new ExcelUtility();
        String actual_title = login.getLoginPageTitle();
        String expected_title = excel.readSingleData(1, 0, "LoginPageTitle");
        Assert.assertEquals(actual_title, expected_title, "ERROR: Title Mismatch");
    }

    @Test(priority = 2, description = "TC_002_Verify user login with valid user credentials", groups = {"smoke"})
    public void verify_Valid_Login() {
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        String expected_Account_name = excel.readSingleData(1, 0, "AccountName");
        String actual_Account_name = home.getAccountName();
        Assert.assertEquals(actual_Account_name, expected_Account_name, "ERROR:Invalid AccountName");
    }

    @Test(priority = 3, description = "TC_003_Verify the error message displayed for user login with invalid credentials")
    public void verify_Invalid_Credentials() {
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        random = new RandomDataUtility();
        String username = random.getRandomString("uname");
        login.enterUserName(username);
        String password = random.generateRandomPassword(8);
        login.enterPassword(password);
        home = login.enterLoginButton();
        String expected_mssg = excel.readSingleData(1, 0, "InvalidLogin");
        String actual_mssg = login.displayErrorMessage();
        Assert.assertEquals(actual_mssg, expected_mssg, "ERROR:No error message displayed");
    }

    @Test(priority = 4, description = "TC_004_Verify whether the user is able to click on 'Remember me' checkbox")
    public void verifyCheckboxSelected() {
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        login.clickCheckBox();
        boolean check_enabled = login.isCheckBoxSelected();
        login.enterLoginButton();
        home.enterButtonEndTour();
        Assert.assertTrue(check_enabled);
    }

    @Test(priority = 5, description = "TC_005_Verify error message displayed on  Reset Password page with invalid email id")
    public void verify_Reset_Password_With_Invalid_Credentials() {
        excel = new ExcelUtility();
        random = new RandomDataUtility();
        login = new LoginPage(driver);
        reset = new ResetPasswordPage(driver);
        login.clickForgotPasswordLink();
        String value = random.getRandomString("email");
        reset.enterEmail(value);
        reset.clickResetLink();
        String expected_msg = excel.readSingleData(1, 0, "InvalidReset");
        String actual_msg = reset.getErrorMessage();
        Assert.assertEquals(actual_msg, expected_msg, "ERROR:No error message displayed");
    }
}
