package com.ty_cloud.step_defs;

import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.ConfigReader;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.Utils;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class WriteComment_StepDefs {

    FilePage filePage = new FilePage();
    @When("user write a comment inside the input box")
    public void user_write_a_comment_inside_the_input_box() {
        WaitFor.clickable(filePage.commentsMenu);
        filePage.commentsMenu.click();
        filePage.appSidebarCommentInput.sendKeys(ConfigReader.getProperty("comment"));

    }
    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        filePage.appSidebarCmmntEntrBtn.click();
        WaitFor.milliSeconds(500);
    }
    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        List<String> comments = Utils.giveMeElementTexes(filePage.appSidebarComments());
        System.out.println(ConfigReader.getProperty("comment"));
        Assert.assertTrue(comments.contains(ConfigReader.getProperty("comment")));

    }

}
