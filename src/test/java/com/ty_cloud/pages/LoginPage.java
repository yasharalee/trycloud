package com.ty_cloud.pages;

import com.ty_cloud.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "user")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//div[@id='submit-wrapper']/following-sibling::p[1]")
    public WebElement errorMsg;

    public void with(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass + Keys.ENTER);
    }

}
