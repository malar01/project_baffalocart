package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.How.CSS;

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

    @FindBy(xpath = "//ul//a//span[normalize-space(text())='Users']")
    WebElement users;
    @FindBy(xpath = "//ul//a//span[normalize-space(text())='Roles']")
    WebElement roles;
    @FindBy(xpath = "//ul//a//span[normalize-space(text())='Sales Commission Agents']")
    WebElement sales;


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
        wait.waitUntilVisibilityOfElement(30, driver, user_account);
    }

    public void giveExplicitWaitOnSignOut() {
        wait.waitUntilVisibilityOfElement(30, driver, sign_out);
    }

    public void clickUserManagement() {
        page.clickOnElement(user_management);
    }

    public void clickUsers() {
        page.mouseHover(driver, users);
    }

    public UsersPage clickUserPage() {
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

    public void getAllElementsOptions() {
        Select s = new Select(user_management);
        List<WebElement> fromOptions = s.getOptions();
        for (int i = 0; i < fromOptions.size(); i++) {
            String options = fromOptions.get(i).getText();
            System.out.println(options);
        }
    }
}