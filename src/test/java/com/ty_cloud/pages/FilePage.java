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

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement AddFileBtn;

    @FindBy(xpath = "//a[contains(@class, 'action action-menu permanent')]")
    public List<WebElement> actions;


    @FindBy(xpath = "//div[@id='filelist-header']//span[@class='name']")
    public List<WebElement> allFileElementsInUpperTable;




    @FindBy(xpath = "(//tbody[@id='fileList'])[1]//span[@class='innernametext']")
    public List<WebElement> allFileElementsInLowerTable;




    public WebElement actionSubMenus(String subMenu) {
        return Driver.getDriver().findElement(By.xpath("//*[@id=\"fileList\"]//div[contains(@class, 'fileActionsMenu popovermenu bubble')]//span[.='" + subMenu + "']"));
    }



    public WebElement addBtnSubMenu(String subMenu) {
        return Driver.getDriver().findElement(By.xpath("//span[normalize-space()='" + subMenu + "']"));
    }

    public WebElement leftSideBarMenu(String menuName){
        return Driver.getDriver().findElement(By.xpath("//div[@id='app-navigation']//a[.='"+menuName+"']"));
    }

    public void actionSubmenuClick(String submenu) {
        actionSubMenus(submenu);
    }


    public List<String> nameOfAllAddedFiles = new ArrayList<>();
    private boolean isIt(String str){
        boolean isIt = false;
        WebElement is = Driver.getDriver().findElement(By.xpath("(//*[@id=\"fileList\"])[1]//li[@class=' action-favorite-container']//span[2]"));
        if (is.getText().equals(str)){
            isIt = true;
        }
        return isIt;
    }

    public void addAllFilesToFavorites() {

        for (int i = 0; i < actions.size(); i++) {

            WebElement action = actions.get(i);
            action.click();
            if (isIt("Remove from favorites")){
                action.click();
                continue;
            }
            try {
                actionSubMenus("Add to favorites").click();
                nameOfAllAddedFiles.add( allFileElementsInLowerTable.get(i).getText());
                WaitFor.Seconds(1);
            }catch (RuntimeException e){
                actionSubMenus("Remove from favorites").click();
            }
        }
    }

    public List<String> nameOfAllRemovedFiles = new ArrayList<>();
    public List<String> copy;
    public void removeAllFilesToFavorites() {
        for (int i = 0; i < actions.size(); i++) {

            WebElement action = actions.get(i);
            action.click();
            if (isIt("Add to favorites")){
                action.click();
                continue;
            }
            try {
                actionSubMenus("Remove from favorites").click();
                nameOfAllRemovedFiles.add( allFileElementsInLowerTable.get(i).getText());
            }catch (RuntimeException e){
                actionSubMenus("Add to favorites").click();
            }
        }
        copy = new ArrayList<>(nameOfAllRemovedFiles);
    }


}
