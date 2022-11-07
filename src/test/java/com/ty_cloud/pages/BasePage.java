package com.ty_cloud.pages;

import com.ty_cloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BasePage {

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





}
