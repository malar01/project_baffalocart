package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewUserPage extends ObjectUtility {
    public WebDriver driver;

    public ViewUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//section[@class='content']//div[@class='col-md-12']//h3[@class='profile-username']")
    WebElement username;

    public String getViewUsername(){
        wait.waitUntilVisibilityOfElement(50,driver,username);
        String text=page.getElementText(username);
        return text;
    }
}
