package com.ty_cloud.pages;

import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.Utils;
import com.ty_cloud.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

public class FilePage {

    public FilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String fileName;
    public WebElement fileElement;

    @FindBy(xpath = "//*[@id='headerSelection']/label")
    public WebElement checkboxSelectAll;


    @FindBy(xpath = "//*[@id=\"fileList\"]/tr/td/input")
    public List<WebElement> allCheckboxes;

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement addBtn;

    @FindBy(xpath = "//a[contains(@class, 'action action-menu permanent')]")
    public List<WebElement> actions;


    @FindBy(xpath = "//div[@id='filelist-header']//span[@class='name']")
    public List<WebElement> allFileElementsInUpperTable;

    @FindBy(xpath = "//div[@class='app-sidebar-header__info']")
    public WebElement appSidebarHeader;

    @FindBy(xpath = "//a[@id='commentsTabView']")
    public WebElement commentsMenu;


    @FindBy(xpath = "//div[@class='message']")
    public WebElement appSidebarCommentInput;

    @FindBy(xpath = "//input[@class='submit icon-confirm has-tooltip']")
    public WebElement appSidebarCmmntEntrBtn;

    public List<WebElement> appSidebarComments() {
        return Driver.getDriver().findElements(By.xpath("//li[@class='comment']//div[@class='message']"));
    }


    @FindBy(xpath = "//a[@class='action more icon icon-more has-tooltip']")
    public List<WebElement> appSidebarActions;

    public WebElement appSidebarActionSubmenu(String submenu) {
        return Driver.getDriver().findElement(By.xpath(
                "(//div[@class='commentsModifyMenu popovermenu bubble menu menu-left']//span[.='" + submenu + "'])[2]"
        ));
    }


    @FindBy(xpath = "//*[@id='uploadprogressbar']")
    public WebElement progressBar;


    @FindBy(xpath = "(//tbody[@id='fileList'])[1]//span[@class='innernametext']")
    public List<WebElement> allElementsInLowerTable;


    public List<WebElement> findElementByTextInLowerTable(String text) {
        List<WebElement> list = allElementsInLowerTable.stream().filter(m -> m.getText().equals(text)).collect(Collectors.toList());
        return list;
    }


    @FindBy(xpath = "(//*[@id=\"fileList\"])[1]//span[@class='nametext']")
    public List<WebElement> allFilesInsideFolder;


    public WebElement actionSubMenus(String subMenu) {
        return Driver.getDriver().findElement(By.xpath("//div[contains(@class, 'fileActionsMenu popovermenu bubble')]//*[.='" + subMenu + "']/.."));
    }

    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement inputFile;


    public WebElement addBtnSubMenu(String subMenu) {
        return Driver.getDriver().findElement(By.xpath("//span[normalize-space()='" + subMenu + "']"));
    }

    public WebElement leftSideBarMenu(String menuName) {
        return Driver.getDriver().findElement(By.xpath("//div[@id='app-navigation']//a[.='" + menuName + "']"));
    }

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement newFolderNameInputBox;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement folderNameEnterBtn;

    @FindBy(xpath = "(//*[@id='fileList'])[1]//div[contains(@class, 'fileActionsMenu popovermenu bubble open menu')]")
    public WebElement actionSubContainer;


    public boolean isItFolder(String name) {
        boolean is = false;
        WebElement item;
        try {
            item = Driver.getDriver().findElement(By.xpath
                    ("(//*[@id='fileList'])[1]//span[.='" + name + "']/..//preceding-sibling::div[1]/div"));
        } catch (NoSuchElementException e) {
            return false;
        }
        String styleVal = item.getAttribute("style");
        if (styleVal.contains("folder.svg")) {
            is = true;
        }
        return is;
    }


    public int randomNumUpTo(int zeroTo) {
        Random random = new Random();
        return random.nextInt(zeroTo);
    }

    public void generateFolder() {
        WaitFor.clickable(addBtn);
        addBtn.click();
        addBtnSubMenu("New folder").click();
        newFolderNameInputBox.clear();
        newFolderNameInputBox.sendKeys("Generatedfldr");
        folderNameEnterBtn.click();
        WaitFor.invisibilityOf(folderNameEnterBtn);
    }


    public List<String> nameOfAllAddedFiles = new ArrayList<>();

    public boolean subMenusTextIs(String str) {
        boolean isIt = false;
        WebElement is;
        try {
            is = Driver.getDriver().findElement(By.xpath("(//*[@id=\"fileList\"])[1]//li[@class=' action-favorite-container']//span[2]"));
        } catch (NoSuchElementException e) {
            return false;
        }
        if (is.getText().equals(str)) {
            isIt = true;
        }
        return isIt;
    }

    public WebElement findFileByName(String fileName) {
        return Driver.getDriver().findElement(By.xpath("(//*[@id=\"fileList\"])[1]//span[.='" + fileName + "']"));
    }

    public void removeFromFavoriteSubmenu() {
        int index = 0;
        if (subMenusTextIs("Add to favorites")) {
            List<String> names = Utils.giveMeElementTexes(allElementsInLowerTable);
            System.out.println(names);
            System.out.println(fileName);
            index = names.indexOf(fileName.trim());
            System.out.println(index);
            actions.get(index).click();
            index = randomNumUpTo(allElementsInLowerTable.size() - 1);
            actions.get(index);
            fileName = allElementsInLowerTable.get(index).getText();
            removeFromFavoriteSubmenu();
        } else {
            actionSubMenus("Remove from favorites").click();
        }
    }

    public void addToFavoriteSubmenu() {
        int index;
        if (subMenusTextIs("Remove from favorites")) {
            List<String> names = Utils.giveMeElementTexes(allElementsInLowerTable);
            index = names.indexOf(fileName);
            actions.get(index).click();
            index = randomNumUpTo(allElementsInLowerTable.size() - 1);
            actions.get(index).click();
            fileName = allElementsInLowerTable.get(index).getText();
            addToFavoriteSubmenu();
        } else {
            actionSubMenus("Add to favorites").click();
        }
    }


}
