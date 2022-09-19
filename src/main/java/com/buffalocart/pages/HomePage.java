package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class HomePage extends ObjectUtility {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Aju Mathew']")
    WebElement accountName;

    @FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']/strong")
    WebElement current_date;

    @FindBy(xpath = "//span[text()='Aju Mathew']")
    WebElement user_account;
    @FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
    WebElement sign_out;

    @FindBy(xpath = "//span[@class='title']")
    WebElement user_management;
    @FindBy(xpath = "//ul[@class='treeview-menu menu-open']//span")
    List<WebElement> user_management_sub_menu;

    @FindBy(xpath = "//ul[@class='treeview-menu menu-open']//span[1]")
    WebElement users;
    @FindBy(xpath = "//ul//span[@class='title']/following::span[3]")
    WebElement roles;
    @FindBy(xpath = "//ul//a//span[normalize-space(text())='Sales Commission Agents']")
    WebElement sales;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
    WebElement endTour;

    @FindBy(xpath="//span[@class='title']")
    WebElement click_sales_comm;

    public void enterButtonEndTour() {
        wait.waitUntilVisibilityOfElement(10,driver,endTour);
        page.clickOnElement(endTour);
    }
    public String getAccountName() {
        String account_name = page.getElementText(accountName);
        return account_name;
    }

    public String getHomePageTitle() {
        String title = page.getPageTitle(driver);
        return title;
    }

    public String getCurrentDateDisplayed() {
        String date = page.getElementText(current_date);
        return date;
    }

    public void clickOnUserAccount() {
        page.clickOnElement(user_account);
    }

    public LoginPage clickSignOut() {
        page.clickOnElement(sign_out);
        return new LoginPage(driver);
    }

    public void giveExplicitWaitOnUser() {
        wait.waitUntilVisibilityOfElement(20, driver, user_account);
    }

    public void giveExplicitWaitOnSignOut() {
        wait.waitUntilVisibilityOfElement(30, driver, sign_out);
    }

    public void clickUserManagement() {
        wait.waitUntilVisibilityOfElement(30,driver,user_management);
        page.clickOnElement(user_management);
    }

    public void clickUsers() {
        wait.waitUntilVisibilityOfElement(20, driver, users);
        //wait.hardWait(1000);
        page.mouseHover(driver, users);
    }
    public SalesCommAgentsPage click_sales_comm(){
        page.mouseHover(driver,click_sales_comm);
        page.clickOnElement(click_sales_comm);
        return new SalesCommAgentsPage(driver);
    }

    public UsersPage clickUserPage() {
        wait.waitUntilVisibilityOfElement(30, driver, users);
        //wait.hardWait(1000);
        page.clickOnElement(users);
        return new UsersPage(driver);
    }

    public boolean getUser() {
        boolean user = page.getElementIsEnabled(users);
        return user;
    }

    public boolean getSales() {
        boolean sale = page.getElementIsEnabled(sales);
        return sale;
    }

    public boolean getRoles() {
        boolean role = page.getElementIsEnabled(roles);
        return role;
    }

    public List<WebElement> getSubMenuList() throws IOException {
        List<WebElement> menu_list=user_management_sub_menu;
        for(int i=0;i<menu_list.size();i++){
            String list_elements=menu_list.get(i).getText();
            System.out.println(list_elements);
        }
        return menu_list;
    }
    public RolePage click_sub_menu_role(){
        wait.waitUntilVisibilityOfElement(10,driver,roles);
        page.mouseHover(driver,roles);
        page.clickOnElement(roles);
        return new RolePage(driver);
    }
    public SalesCommAgentsPage click_sub_menu_sales_comm(){
        wait.waitUntilVisibilityOfElement(10,driver,sales);
        page.mouseHover(driver,sales);
        page.clickOnElement(sales);
        return new SalesCommAgentsPage(driver);
    }
}

