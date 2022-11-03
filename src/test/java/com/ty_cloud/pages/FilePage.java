package com.ty_cloud.pages;

import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

public class FilePage {

    public FilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id='headerSelection']/label")
    public WebElement checkboxSelectAll;

    @FindBy(xpath = "//*[@id=\"fileList\"]/tr/td/input")
    public List<WebElement> allCheckboxes;

    @FindBy(xpath = "(//*[@id='fileList'])[1]//li[@class=' action-favorite-container']/a//*[.='Add to favorites']")
    WebElement addToFavorite;

    @FindBy(xpath = "(//*[@id='fileList'])[1]//li[@class=' action-favorite-container']//*[.='Remove from favorites']")
    public WebElement removeFromFavorite;


    @FindBy(xpath = "//*[@id='app-navigation']/ul/li[3]/a")
    public WebElement favoriteSideMenu;

    @FindBy(xpath = "//a[contains(@class, 'action action-menu permanent')]")
    public List<WebElement> actions;

    @FindBy(xpath = "(//tbody[@id='fileList'])[1]//span[@class='innernametext']")
    public List<WebElement> allFileElements;

    @FindBy(xpath = "(//*[@id='fileList'])[1]//li[@class=' action-favorite-container']/a/span[2]")
    public WebElement firstSubMenu;



    public WebElement sideMenuByName(String menu){
       return Driver.getDriver().findElement(By.xpath("//div[@id='app-navigation']//a[.='"+menu+"']"));
    }
    @FindBy(xpath = "//a[@class='button new']" )
    public WebElement addButton;

    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement inputFile;

    public WebElement subMenusOfAddButton(String subMenu){
        return Driver.getDriver().findElement(By.xpath("//span[normalize-space()='"+subMenu+"']"));
    }


// ==============================================================================================
    public List<String> addedFiles = new ArrayList<>();
    public List<String> removedFiles = new ArrayList<>();

    public void clickOnActions() {
        removeAllFillsInFilesPage();
        WaitFor.Seconds(2);
        addAllFillsInFilesPage();
    }

    public void removeAllFillsInFilesPage() {
        for (int i = 0; i < actions.size(); i++) {
            WebElement action = actions.get(i);
            WaitFor.clickable(action);
            action.click();
            WaitFor.clickable(firstSubMenu);
            try {
                clickRemoveFromFavoriteSubmenu();
                removedFiles.add(allFileElements.get(i).getText());
            } catch (RuntimeException e) {
                System.out.println("Remove Btn did not displayed");
            }
        }
    }

    public void addAllFillsInFilesPage() {
        for (int i = 0; i < actions.size(); i++) {
            WaitFor.clickable(actions.get(i));
            actions.get(i).click();
            WaitFor.clickable(addToFavorite);
            addToFromFavoriteSubmenu();
            addedFiles.add(allFileElements.get(i).getText());
        }
    }

    public void clickRemoveFromFavoriteSubmenu() {
        removeFromFavorite.click();
    }

    public void addToFromFavoriteSubmenu() {
        addToFavorite.click();
    }




}
