package com.ty_cloud.step_defs;

import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.ConfigReader;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.Utils;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WriteComment_StepDefs {

    FilePage filePage = new FilePage();


    @When("the users click action-icon from random file or folder  on the page")
    public void the_users_click_action_icon_from_random_file_or_folder_on_the_page() {

        if (filePage.actions.size() > 0) {

           int index = filePage.actions.size() == 1 ? 0 : filePage.randomNumUpTo(filePage.actions.size() - 1);

                WebElement option = filePage.actions.get(index);
                filePage.fileName = filePage.allElementsInLowerTable.get(index).getText().trim();
                option.click();

        }else {
            System.out.println("No any item in the page");
        }
    }

    @When("user choose the submenu from given menu below")
    public void user_choose_the_submenu_from_given_below(List<String> list) {
            filePage.actionSubMenus(list.get(0).trim()).click();
    }


    @When("user write a comment inside the input box")
    public void user_write_a_comment_inside_the_input_box() {
        WaitFor.clickable(filePage.commentsMenu);
        filePage.commentsMenu.click();
        WebElement input = filePage.appSidebarCommentInput;
        WaitFor.clickable(input);
        input.sendKeys(ConfigReader.getProperty("comment").trim());

    }
    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        filePage.appSidebarCmmntEntrBtn.click();
        WaitFor.invisibilityOf(Driver.getDriver().findElement(By.xpath("//*[contains(@class,'submitLoading icon-loading-small')]")));
    }
    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        List<String> comments = Utils.giveMeElementTexes(filePage.appSidebarComments());
        Assert.assertTrue(comments.contains(ConfigReader.getProperty("comment").trim()));

    }

}
