package com.ty_cloud.pages;

import com.ty_cloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FavoritePage {
    public FavoritePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//tbody[@id='fileList'])[3]//span[@class='innernametext']")
    public List<WebElement> filesOnFavorites;






}
