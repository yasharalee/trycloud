package com.ty_cloud.pages;

import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    Actions act = new Actions(Driver.getDriver());


    @FindBy(xpath = "//ul[@id='appmenu']//li//a")
    public List<WebElement> moduleElements;





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
