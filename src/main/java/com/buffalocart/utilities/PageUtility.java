package com.buffalocart.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class PageUtility {
    public String getPageTitle(WebDriver driver) {
        String title = driver.getTitle();
        return title;
    }

    public String getElementText(WebElement element) {
        String text = element.getText();
        return text;
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public String getAttributeValue(WebElement element, String attribute) {
        String value = element.getAttribute(attribute);
        return value;
    }

    public void closeAllTabs(WebDriver driver) {
        driver.quit();
    }

    public void closeTab(WebDriver driver) {
        driver.close();
    }

    public void getSelectByIndex(WebElement element, int index) {
        Select s = new Select(element);
        s.selectByIndex(index);
    }

    public void getSelectByValue(WebElement element, String value) {
        Select s = new Select(element);
        s.deselectByValue(value);
    }

    public void getSelectByVisibleText(WebElement element, String value) {
        Select s = new Select(element);
        s.deselectByVisibleText(value);
    }

    public WebElement getFirstElementSelected(WebElement element) {
        Select s = new Select(element);
        WebElement element1 = s.getFirstSelectedOption();
        return element1;
    }

    public List<WebElement> getAllSelectedElements(WebElement element) {
        Select s = new Select(element);
        List<WebElement> elements = s.getAllSelectedOptions();
        return elements;
    }

    public List<WebElement> getAllElements(WebElement element) {
        Select s = new Select(element);
        List<WebElement> elements = s.getOptions();
        return elements;
    }
    public boolean getElementIsSelected(WebElement element){
        boolean check_selected=element.isSelected();
        return check_selected;
    }
    public boolean getElementIsDisplayed(WebElement element){
        boolean check_displayed=element.isDisplayed();
        return check_displayed;
    }
    public boolean getElementIsEnabled(WebElement element){
        boolean check_enabled=element.isEnabled();
        return check_enabled;
    }
    public void rightClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void doubleClickOnElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public void dragAndDropOfElements(WebDriver driver, WebElement source, WebElement dest) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, dest).perform();
    }

    public void mouseHover(WebDriver driver, WebElement target) {
        Actions actions = new Actions(driver);
        actions.moveToElement(target).perform();
    }


    public String getMainWindow(WebDriver driver) {
        String window = driver.getWindowHandle();
        return window;
    }

    public Set<String> getAllWindows(WebDriver driver) {
        Set<String> windows = driver.getWindowHandles();
        return windows;
    }
}
