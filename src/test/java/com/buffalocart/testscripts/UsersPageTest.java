package com.buffalocart.testscripts;

import com.buffalocart.automationcore.Base;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.RandomDataUtility;
import com.buffalocart.utilities.TableUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersPageTest extends Base {

    ViewUserPage viewUserPage;
    AddUsersPage addUsersPage;
    TableUtility table;
    HomePage home;
    ExcelUtility excel;
    LoginPage login;
    UsersPage usersPage;
    RandomDataUtility random;
    AddRollPage addRolePage;
    RolePage rolePage;
    EditRollPage editRollPage;
    EditUserPage editUserPage;

    @Test(priority = 10, description = "TC_0010_Verify Users page title")
    public void verifyUsersPageTitle() {
        addUsersPage = new AddUsersPage(driver);
        usersPage = new UsersPage(driver);
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
        home.clickUsers();
        usersPage = home.clickUserPage();
        String expected_title = excel.readSingleData(1, 0, "UsersPageTitle");
        String actual_title = usersPage.getUsersPageTitle();
        Assert.assertEquals(actual_title, expected_title, "ERROR:Title Mismatch");
    }

    @Test(priority = 16, description = "TC_016_Verify  user can add user details", groups = {"smoke"})
    public void verify_user_can_add_user_details() {
        usersPage = new UsersPage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        random = new RandomDataUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        home.clickUsers();
        usersPage = home.clickUserPage();
        addUsersPage = usersPage.set_Click_add_button();
        String firstname = random.getRandomString("uname");
        addUsersPage.set_first_name(firstname);
        String lastname = random.getRandomString("uname");
        addUsersPage.set_last_name(lastname);
        String email_id = random.getRandomString("email");
        addUsersPage.set_email(email_id);
        String role = addUsersPage.select_role_from_drop_down("Coordinator");
        String username = random.getRandomString("uname");
        addUsersPage.set_username(username);
        String password = random.generateRandomPassword(8);
        addUsersPage.set_password(password);
        addUsersPage.set_confirm_password(password);
        addUsersPage.set_commission_percentage("50");
        addUsersPage.select_check1();
        addUsersPage.select_contacts("Shoney - bags(12)");
        usersPage = addUsersPage.click_save_button();
        usersPage.enter_search_value(email_id);
        String[] data = {username, firstname.concat(" " + lastname), role, email_id};
        List<ArrayList<String>> expectedTable_data = new ArrayList<ArrayList<String>>();
        expectedTable_data.add(new ArrayList<String>(Arrays.asList(data)));
        List<ArrayList<String>> actualTable_data = usersPage.getTableData();
        System.out.println(expectedTable_data);
        System.out.println(actualTable_data);
        Assert.assertEquals(actualTable_data, expectedTable_data, "Error:Invalid data- User doesn't exist");
    }

    @Test(priority = 17, description = "TC_017_Verify Edit User page title")
    public void verify_Edit_User_page_title() {
        editUserPage = new EditUserPage(driver);
        usersPage = new UsersPage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        random = new RandomDataUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        home.clickUsers();
        usersPage = home.clickUserPage();
        addUsersPage = usersPage.set_Click_add_button();
        String firstname = random.getRandomString("uname");
        addUsersPage.set_first_name(firstname);
        String lastname = random.getRandomString("uname");
        addUsersPage.set_last_name(lastname);
        String email_id = random.getRandomString("email");
        addUsersPage.set_email(email_id);
        String role = addUsersPage.select_role_from_drop_down("Coordinator");
        String username = random.getRandomString("uname");
        addUsersPage.set_username(username);
        String password = random.generateRandomPassword(8);
        addUsersPage.set_password(password);
        addUsersPage.set_confirm_password(password);
        addUsersPage.set_commission_percentage("50");
        addUsersPage.select_check1();
        addUsersPage.select_contacts("Shoney - bags(12)");
        usersPage = addUsersPage.click_save_button();
        usersPage.enter_search_value(email_id);
        editUserPage = usersPage.click_edit_user_page();
        String actual_title = usersPage.get_edit_page_title();
        String expected_title = excel.readSingleData(1, 0, "EditUserPageTitle");
        Assert.assertEquals(actual_title, expected_title, "ERROR:Title Mismatch");
    }

    @Test(priority = 11, description = "TC_0011_Verify user search with valid data")
    public void verify_user_search_with_valid_data() {
        usersPage = new UsersPage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        random = new RandomDataUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        home.clickUsers();
        usersPage = home.clickUserPage();
        addUsersPage = usersPage.set_Click_add_button();
        String firstname = random.getRandomString("uname");
        addUsersPage.set_first_name(firstname);
        String lastname = random.getRandomString("uname");
        addUsersPage.set_last_name(lastname);
        String email_id = random.getRandomString("email");
        addUsersPage.set_email(email_id);
        String role = addUsersPage.select_role_from_drop_down("Coordinator");
        String username = random.getRandomString("uname");
        addUsersPage.set_username(username);
        String password = random.generateRandomPassword(8);
        addUsersPage.set_password(password);
        addUsersPage.set_confirm_password(password);
        addUsersPage.set_commission_percentage("50");
        addUsersPage.select_check1();
        addUsersPage.select_contacts("Shoney - bags(12)");
        usersPage = addUsersPage.click_save_button();
        usersPage.enter_search_value(email_id);
        String[] data = {username, firstname.concat(" " + lastname), role, email_id};
        List<ArrayList<String>> expectedTable_data = new ArrayList<ArrayList<String>>();
        expectedTable_data.add(new ArrayList<String>(Arrays.asList(data)));
        List<ArrayList<String>> actualTable_data = usersPage.getTableData();
        System.out.println(expectedTable_data);
        System.out.println(actualTable_data);
        Assert.assertEquals(actualTable_data, expectedTable_data, "Error:Invalid data");
    }

    @Test(priority = 12, description = "TC_012_Verify message displayed by user search with invalid data", groups = {"smoke"})
    public void verify_user_search_with_invalid_data() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        usersPage = new UsersPage(driver);
        excel = new ExcelUtility();
        random = new RandomDataUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        home.clickUsers();
        usersPage = home.clickUserPage();
        addUsersPage = usersPage.set_Click_add_button();
        String firstname = random.getRandomString("uname");
        addUsersPage.set_first_name(firstname);
        String lastname = random.getRandomString("uname");
        addUsersPage.set_last_name(lastname);
        String email_id = random.getRandomString("email");
        addUsersPage.set_email(email_id);
        String role = addUsersPage.select_role_from_drop_down("Coordinator");
        String username = random.getRandomString("uname");
        addUsersPage.set_username(username);
        String password = random.generateRandomPassword(8);
        addUsersPage.set_password(password);
        addUsersPage.set_confirm_password(password);
        addUsersPage.set_commission_percentage("50");
        addUsersPage.select_check1();
        addUsersPage.select_contacts("Shoney - bags(12)");
        usersPage = addUsersPage.click_save_button();
        String mail = random.getRandomString("email");
        usersPage.enter_search_value(mail);
        //String actual_mail = usersPage.get_search_result();
        String actualTable_data = usersPage.get_search_result();
        String expected_mail = excel.readSingleData(1, 0, "UserwithInvalidData");
        Assert.assertEquals(actualTable_data, expected_mail, "Error:Invalid data");
    }

    @Test(priority = 13, description = "TC_013_Verify the error message displayed without filling mandatory fields in add user form")
    public void verify_the_error_message_displayed_without_filling_mandatory_fields() {
        usersPage = new UsersPage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        random = new RandomDataUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        home.clickUsers();
        usersPage = home.clickUserPage();
        addUsersPage = usersPage.set_Click_add_button();
        addUsersPage.set_surname("Mrs");
        String firstname = random.getRandomString("uname");
        addUsersPage.set_first_name(firstname);
        String lastname = random.getRandomString("uname");
        addUsersPage.set_last_name(lastname);
        addUsersPage.select_role_from_drop_down("Engineer");
        String username = random.getRandomString("uname");
        addUsersPage.set_username(username);
        String password = random.generateRandomPassword(8);
        addUsersPage.set_password(password);
        addUsersPage.set_confirm_password(password);
        addUsersPage.set_commission_percentage("50");
        addUsersPage.select_check1();
        addUsersPage.select_contacts("Shoney - bags(12)");
        addUsersPage.click_save_button();
        String expected_error_mssg = excel.readSingleData(1, 0, "AddUserPageErrormssg");
        String actual_error_mssg = usersPage.display_error_message();
        Assert.assertEquals(expected_error_mssg, actual_error_mssg, "ERROR:No error message displayed without filling mandatory fields in add user form");
    }

    @Test(priority = 15, description = "TC_015_Verify  Add Users page title")
    public void verify_Add_Users_page_title() {
        usersPage = new UsersPage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        random = new RandomDataUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        home.clickUsers();
        usersPage = home.clickUserPage();
        usersPage.set_Click_add_button();
        String expected_title = excel.readSingleData(1, 0, "AddUsersPageTitle");
        String actual_title = usersPage.getAddUserPageTitle();
        System.out.println(actual_title);
        Assert.assertEquals(actual_title, expected_title, "ERROR:Title Mismatch");
    }

    @Test(priority = 14, description = "TC_014_Verify user login with newly added user")
    public void verify_user_login_with_newly_added_user() {
        usersPage = new UsersPage(driver);
        home = new HomePage(driver);
        excel = new ExcelUtility();
        login = new LoginPage(driver);
        random = new RandomDataUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        home.clickUsers();
        usersPage = home.clickUserPage();
        addUsersPage = usersPage.set_Click_add_button();
        addUsersPage.set_surname("Mrs");
        String firstname = random.getRandomString("uname");
        addUsersPage.set_first_name(firstname);
        String lastname = random.getRandomString("uname");
        addUsersPage.set_last_name(lastname);
        String email_id = random.getRandomString("email");
        addUsersPage.set_email(email_id);
        addUsersPage.select_role_from_drop_down("Specialist");
        String username = random.getRandomString("uname");
        addUsersPage.set_username(username);
        String password = random.generateRandomPassword(8);
        addUsersPage.set_password(password);
        addUsersPage.set_confirm_password(password);
        addUsersPage.set_commission_percentage("50");
        addUsersPage.select_check1();
        addUsersPage.select_contacts("Shoney - bags(12)");
        usersPage = addUsersPage.click_save_button();
        usersPage.click_user_account();
        login = usersPage.click_Sign_out_user_account();
        login.enterUserName(username);
        login.enterPassword(password);
        home = login.enterLoginButton();
        // login.enterButtonEndTour();
        String expected_account_name = firstname.concat(" ").concat(lastname);
        String actual_account_name = usersPage.getAccountName();
        Assert.assertEquals(actual_account_name, expected_account_name, "ERROR: Account Name Mismatch");
    }

    @Test(priority = 19, description = "TC_019_Verify user can delete a user")
    public void verify_user_can_delete_a_user() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        usersPage = new UsersPage(driver);
        excel = new ExcelUtility();
        random = new RandomDataUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        home.clickUsers();
        usersPage = home.clickUserPage();
        addUsersPage = usersPage.set_Click_add_button();
        String surname = addUsersPage.set_surname("Mrs");
        String firstname = random.getRandomString("uname");
        addUsersPage.set_first_name(firstname);
        String lastname = random.getRandomString("uname");
        addUsersPage.set_last_name(lastname);
        String email_id = random.getRandomString("email");
        addUsersPage.set_email(email_id);
        String role = addUsersPage.select_role_from_drop_down("Coordinator");
        String username = random.getRandomString("uname");
        addUsersPage.set_username(username);
        String password = random.generateRandomPassword(8);
        addUsersPage.set_password(password);
        addUsersPage.set_confirm_password(password);
        addUsersPage.set_commission_percentage("50");
        addUsersPage.select_check1();
        addUsersPage.select_contacts("Shoney - bags(12)");
        usersPage = addUsersPage.click_save_button();
        usersPage.enter_search_value(email_id);
        usersPage.click_delete_button();
        usersPage.click_alert_ok_button();
        usersPage.clear_search_value();
        usersPage.enter_search_value(email_id);
        String actualTable_data = usersPage.list_record();
        String expectedTable_data = excel.readSingleData(1, 0, "DeleteUser");
        Assert.assertEquals(actualTable_data, expectedTable_data, "Error:Invalid data");
    }

    @Test(priority = 20, description = "TC_020_Verify  the details displayed on view user page")
    public void verify_detail_displayed_on_view_user_page() {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        usersPage = new UsersPage(driver);
        editUserPage = new EditUserPage(driver);
        excel = new ExcelUtility();
        random = new RandomDataUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        home.clickUsers();
        usersPage = home.clickUserPage();
        addUsersPage = usersPage.set_Click_add_button();
        String firstname = random.getRandomString("uname");
        addUsersPage.set_first_name(firstname);
        String lastname = random.getRandomString("uname");
        addUsersPage.set_last_name(lastname);
        String email_id = random.getRandomString("email");
        addUsersPage.set_email(email_id);
        String role = addUsersPage.select_role_from_drop_down("Coordinator");
        String username = random.getRandomString("uname");
        addUsersPage.set_username(username);
        String password = random.generateRandomPassword(8);
        addUsersPage.set_password(password);
        addUsersPage.set_confirm_password(password);
        addUsersPage.set_commission_percentage("50");
        addUsersPage.select_check1();
        addUsersPage.select_contacts("Shoney - bags(12)");
        usersPage = addUsersPage.click_save_button();
        usersPage.enter_search_value(email_id);
        viewUserPage = usersPage.click_view_button();
        String expected_user = firstname.concat(" " + lastname);
        String actual_user = viewUserPage.getViewUsername();
        Assert.assertEquals(actual_user, expected_user, "ERROR:Username Mismatch");
    }

    @Test(priority = 27, description = "TC_027_Verify whether the added role in Role page is listed in roles field in user add page")
    public void verify_added_role_in_user_add_page() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        usersPage = new UsersPage(driver);
        addUsersPage = new AddUsersPage(driver);
        rolePage = new RolePage(driver);
        addRolePage = new AddRollPage(driver);
        excel = new ExcelUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        rolePage = home.click_sub_menu_role();
        addRolePage = rolePage.click_add_role();
        String new_role = addRolePage.set_role_name("Security");
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
        rolePage = addRolePage.click_save_add_role_page();
        usersPage = rolePage.click_users();
        addUsersPage = usersPage.set_Click_add_button();
        String actual_role = addUsersPage.select_role_from_drop_down("Security");
        String expected_role = new_role;
        Assert.assertEquals(actual_role, expected_role, "ERROR: Role doesn't exist");
    }

    @Test(priority = 18, description = "TC_018_Verify user can edit the user details")
    public void verify_user_can_edit_the_user_details() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        usersPage = new UsersPage(driver);
        editUserPage = new EditUserPage(driver);
        excel = new ExcelUtility();
        random = new RandomDataUtility();
        String name = excel.readSingleData(1, 0, "LoginPage");
        login.enterUserName(name);
        String pass = excel.readSingleData(1, 1, "LoginPage");
        login.enterPassword(pass);
        home = login.enterLoginButton();
        home.enterButtonEndTour();
        home.clickUserManagement();
        home.clickUsers();
        usersPage = home.clickUserPage();
        addUsersPage = usersPage.set_Click_add_button();
        String firstname = random.getRandomString("uname");
        addUsersPage.set_first_name(firstname);
        String lastname = random.getRandomString("uname");
        addUsersPage.set_last_name(lastname);
        String email_id = random.getRandomString("email");
        addUsersPage.set_email(email_id);
        String role = addUsersPage.select_role_from_drop_down("Coordinator");
        String username = random.getRandomString("uname");
        addUsersPage.set_username(username);
        String password = random.generateRandomPassword(8);
        addUsersPage.set_password(password);
        addUsersPage.set_confirm_password(password);
        addUsersPage.set_commission_percentage("50");
        addUsersPage.select_check1();
        addUsersPage.select_contacts("Shoney - bags(12)");
        usersPage = addUsersPage.click_save_button();
        usersPage.enter_search_value(email_id);
        editUserPage = usersPage.click_edit_user_page();
        editUserPage.clear_email_field();
        String new_email = editUserPage.enter_edit_email();
        usersPage = editUserPage.update_editUser_changes();
        usersPage.enter_search_value(firstname.concat(" " + lastname));
        String[] data = {username, firstname.concat(" " + lastname), role, new_email};
        List<ArrayList<String>> expected_data = new ArrayList<ArrayList<String>>();
        expected_data.add(new ArrayList<String>(Arrays.asList(data)));
        List<ArrayList<String>> actual_data = usersPage.getTableData();
        Assert.assertEquals(actual_data, expected_data, "ERROR: Edited details mismatch");
    }
}

