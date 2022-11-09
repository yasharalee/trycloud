package com.ty_cloud.step_defs;

import com.ty_cloud.pages.TalkPage;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.Utils;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class SendMessage_Stepdefs {

    TalkPage talkPage = new TalkPage();
    @When("user search user from the search box")
    public void user_search_user_from_the_search_box(String user) {
        talkPage.searchBox.sendKeys(user + Keys.ENTER);
    }
    @When("user chose correct option from result list and clicks")
    public void user_chose_correct_option_from_result_list_and_clicks(String user) {

        try {
            talkPage.findUser(user).click();
        }catch (NoSuchElementException e){
            System.out.println("User Not Found");
        }

    }
    @When("user write a message to chosen user")
    public void user_write_a_message_to_chosen_user(String comment) {
        try {
            WebElement load = Driver.getDriver().findElement(By.xpath("//li[14]//*[name()='svg']//*[name()='rect'][2]"));
            WaitFor.invisibilityOf(load);
        }catch (Exception e){
            WaitFor.Seconds(1);
        }
        talkPage.chatTextBox.sendKeys(comment.trim());
        System.out.println("1  "+comment);
    }
    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {

        talkPage.chatSubmitBtn.click();
    }
    @Then("the user should be able to see the message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log(String comment) {

        WaitFor.Seconds(1);
        System.out.println(Utils.giveMeElementTexes(talkPage.chatListHistory));

        Assert.assertTrue(Utils.giveMeElementTexes(talkPage.chatListHistory).contains(comment.trim()));
    }

}
