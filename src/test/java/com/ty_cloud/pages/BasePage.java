package com.ty_cloud.pages;

import com.ty_cloud.utilities.Common;
import com.ty_cloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.stream.Collectors;

public class BasePage extends Common {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    Actions act = new Actions(Driver.getDriver());



    public String storageBeforeUpload = "someu";
    public void initialize(String str){
        storageBeforeUpload = String.valueOf(str);
    }



    @FindBy(xpath = "//ul[@id='appmenu']//li//a")
    public List<WebElement> moduleElements;


    public WebElement leftUpperSidebarMenusByText(String menuText){
     return    Driver.getDriver().findElement(By.xpath("" +
                "//div[@id='app-navigation']//ul//li//a[text()='"+menuText+"']"));
    }

    @FindBy(xpath = "//a[@class='icon-quota svg']/p")
    public WebElement usageInfoElement;



    @FindBy(xpath = "//button[@class='settings-button']")
    public WebElement settingsInsideMenu;



    // 4th element in below list is WebDAV input under settings menu
    @FindBy(xpath = "//div[contains(@id, 'app-settings-content')]//input")
    public List<WebElement> allInputsUnderSettingsMenu;


    @FindBy(xpath = "//div[@id='header-menu-unified-search']//input")
    public WebElement searchInputOfContacts;


    @FindBy(xpath = "//div[@class='full-name']")
    public List<WebElement> contactList;


        //TODO: this method is not working as should
    public List < WebElement> searchResults(){
         List < WebElement>  list= new ArrayList<>();

            list.addAll(findElements("//span[@class='unified-search__result-content']//h3"));
            list.addAll(findElements("//h4[@class='unified-search__result-line-two']"));

        return list;
    }

    public WebElement checkboxesOfSettingsByName(String menuText){
        return Driver.getDriver().findElement(By.xpath("" +
                "//div[contains(@id, '-setting-')]//*[.='"+menuText+"']/preceding-sibling::input[1]"));
    }


    public void hoverOver(){
        act.moveToElement(moduleElements.get(0)).build().perform();
    }

    public List<String> moduleTexts(){
        hoverOver();
       List<String> texes = moduleElements.stream().map(m->m.getText()).collect(Collectors.toList());
       texes.removeIf(m->m.equals(""));
       return texes;
    }

    public WebElement getModuleByVisibleText(String text){
        hoverOver();
        WebElement menu = null;
        for (WebElement each : moduleElements) {
            if (each.getText().trim().equals(text)){
                menu = each;
            }
        }
        return menu;
    }

    public WebElement rightSideModules(String menuName){
        Map<String, Integer> menus = new HashMap<>(Map.of(
                "search",1,"notification",2,"contacts",3,"avatar",4
        ));

        return    Driver.getDriver().findElement(By.xpath("" +
                "(//div[@class='header-right']/div)["+menus.get(menuName.toLowerCase())+"]"));

    }




}
