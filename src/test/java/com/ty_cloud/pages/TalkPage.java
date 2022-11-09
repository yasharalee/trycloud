package com.ty_cloud.pages;

import com.ty_cloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalkPage {

    public TalkPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Search conversations or users']")
    public WebElement searchBox;


    @FindBy(xpath = "//div[@placeholder='Write message, @ to mention someone …']")
    public WebElement chatTextBox;

    @FindBy(xpath = "//button[@aria-label='Send message']")
    public WebElement chatSubmitBtn;

    @FindBy(xpath = "//div[@class='message__main__text']/div")
    public List<WebElement> chatListHistory;

    public List<WebElement> usersListUnderSearchBox(){
        try {
            return Driver.getDriver().findElements(By.xpath("//div[@class='acli__content__line-one']//span[normalize-space()]"));
        }catch (StaleElementReferenceException e){
            return Driver.getDriver().findElements(By.xpath("//div[@class='acli__content__line-one']//span[normalize-space()]"));
        }
    }

    public WebElement findUser(String userName){
        return Driver.getDriver().findElement(By.xpath("" +
                "//div[@class='acli__content__line-one']//span[normalize-space()='"+userName+"']"));
    }

//body-user

}
//*[.=normalize-space('User4')