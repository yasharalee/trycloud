package com.ty_cloud.pages;

import com.ty_cloud.utilities.Driver;
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

    public List<WebElement> appSidebarComments(){
      return   Driver.getDriver().findElements(By.xpath("//li[@class='comment']//div[@class='message']"));
    }


    @FindBy(xpath = "//a[@class='action more icon icon-more has-tooltip']")
    public List<WebElement> appSidebarActions;

    public WebElement appSidebarActionSubmenu(String submenu){
     return    Driver.getDriver().findElement(By.xpath(
     "(//div[@class='commentsModifyMenu popovermenu bubble menu menu-left']//span[.='"+submenu+"'])[2]"
        ));
    }


    @FindBy(xpath = "//*[@id='uploadprogressbar']")
    public WebElement progressBar;

    public List<WebElement> allElementsInLowerTable(){
       return Driver.getDriver().findElements(By.xpath("(//tbody[@id='fileList'])[1]//span[@class='innernametext']"));
    }


    @FindBy(xpath = "(//*[@id=\"fileList\"])[1]//span[@class='nametext']")
    public List<WebElement> allFilesInsideFolder;


    public WebElement actionSubMenus(String subMenu) {
        return Driver.getDriver().findElement(By.xpath("//div[contains(@class, 'fileActionsMenu popovermenu bubble')]//*[.='"+subMenu+"']"));
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


    public boolean isItFolder(String name){
        boolean is = false;
        WebElement item;
       try {
            item = Driver.getDriver().findElement(By.xpath
                   ("(//*[@id='fileList'])[1]//span[.='"+name+"']/..//preceding-sibling::div[1]/div"));
        }catch (NoSuchElementException e){
            return false;
       }
        String styleVal = item.getAttribute("style");
        if (styleVal.contains("folder.svg")){
            is = true;
        }
        return is;
    }


    public int randomNumUpTo(int zeroTo){
        Random random = new Random();
        return random.nextInt(zeroTo);
    }

    public void generateFolder(){
        WaitFor.clickable(addBtn);
        addBtn.click();
        addBtnSubMenu("New folder").click();
        newFolderNameInputBox.clear();
        newFolderNameInputBox.sendKeys("Generatedfldr");
        folderNameEnterBtn.click();
        WaitFor.invisibilityOf(folderNameEnterBtn);
    }


    public List<String> nameOfAllAddedFiles = new ArrayList<>();

    private boolean isIt(String str) {
        boolean isIt = false;
        WebElement is = Driver.getDriver().findElement(By.xpath("(//*[@id=\"fileList\"])[1]//li[@class=' action-favorite-container']//span[2]"));
        if (is.getText().equals(str)) {
            isIt = true;
        }
        return isIt;
    }

    public WebElement findFileByName(String fileName){
      return   Driver.getDriver().findElement(By.xpath("(//*[@id=\"fileList\"])[1]//span[.='"+fileName+"']"));
    }

    public void addAllFilesToFavorites() {

        for (int i = 0; i < actions.size(); i++) {

            WebElement action = actions.get(i);
            WaitFor.clickable(action);
            action.click();
            if (isIt("Remove from favorites")) {
                action.click();
                continue;
            }
            try {
                actionSubMenus("Add to favorites").click();
                nameOfAllAddedFiles.add(allElementsInLowerTable().get(i).getText());
            } catch (RuntimeException e) {
                e.getStackTrace();
            }
        }
    }

    public List<String> nameOfAllRemovedFiles = new ArrayList<>();
    public List<String> copy;

    public void removeAllFilesToFavorites() {
        for (int i = 0; i < actions.size(); i++) {

            WebElement action = actions.get(i);
            WaitFor.clickable(action);
            action.click();
            if (isIt("Add to favorites")) {
                action.click();
                continue;
            }
            try {
                actionSubMenus("Remove from favorites").click();
                nameOfAllRemovedFiles.add(allElementsInLowerTable().get(i).getText());
            } catch (RuntimeException e) {
               e.getStackTrace();
            }
        }
        copy = new ArrayList<>(nameOfAllRemovedFiles);
    }



}
