package com.ty_cloud.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Common {
    public  List<WebElement> findElements(String xpath){
        List<WebElement> list = Driver.getDriver().findElements(By.xpath(xpath));
        return list;
    }

    public  WebElement findElement(String xpath){
        return  Driver.getDriver().findElement(By.xpath(xpath));
    }
}
