package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRollPage extends ObjectUtility {
    public WebDriver driver;
    public AddRollPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//input[@id='name']")
    WebElement role_name;
    @FindBy(xpath="//ins[@class='iCheck-helper']")
    WebElement select_all_users;
    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[6]")
    WebElement select_all_roles;
    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[11]")
    WebElement select_all_supplier;
    @FindBy(xpath = "//input[@class='check_all input-icheck']/following::ins[16]")
    WebElement select_all_customer;
    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[21]")
    WebElement select_all_product;
    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[28]")
    WebElement select_all_purchase;
    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[34]")
    WebElement select_all_sell;
    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[44]")
    WebElement select_all_brand;
    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[49]")
    WebElement select_all_tax_rate;
    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[54]")
    WebElement select_all_unit;

    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[59]")
    WebElement select_all_category;

    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[64]")
    WebElement select_all_report;
    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[74]")
    WebElement select_all_settings;

    @FindBy(xpath="//input[@class='check_all input-icheck']/following::ins[80]")
    WebElement select_account;
    @FindBy(xpath="//button[@class='btn btn-primary pull-right']")
    WebElement click_save_button;
    public String get_add_role_page_title(){
        String title=page.getPageTitle(driver);
        return title;
    }
    public String set_role_name(String roleName){
        page.enterText(role_name,roleName);
        return roleName;
    }
    public void chk_select_users(){
        page.clickOnElement(select_all_users);
    }
    public void chk_select_roles(){
        page.clickOnElement(select_all_roles);
    }
    public void chk_select_supplier(){
        page.clickOnElement(select_all_supplier);
    }
    public void chk_select_customer(){
        page.clickOnElement(select_all_customer);
    }
    public void chk_select_product(){
        page.clickOnElement(select_all_product);
    }
    public void chk_select_purchase(){
        page.clickOnElement(select_all_purchase);
    }
    public void chk_select_sell(){
        page.clickOnElement(select_all_sell);
    }
    public void chk_select_brand(){
        page.clickOnElement(select_all_brand);
    }
    public void chk_select_tax_rate(){
        page.clickOnElement(select_all_tax_rate);
    }
    public void chk_select_unit(){
        page.clickOnElement(select_all_unit);
    }
    public void chk_select_category(){
        page.clickOnElement(select_all_category);
    }
    public void chk_select_report(){
        page.clickOnElement(select_all_report);
    }
    public void chk_select_settings(){
        page.clickOnElement(select_all_settings);
    }
    public void chk_select_account(){
        page.clickOnElement(select_account);
    }
    public RolePage click_save_add_role_page(){
        page.clickOnElement(click_save_button);
        return new RolePage(driver);
    }
}
