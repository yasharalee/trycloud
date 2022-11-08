package com.ty_cloud.step_defs;

import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.Utils;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class AddFolder_StepDefs {

    FilePage filePage = new FilePage();
    @When("users clicks on the submenu option")
    public void users_clicks_on_the_submenu_option(String submenu) {
      filePage.addBtnSubMenu(submenu).click();

    }
    @When("user write a {string}")
    public void user_write_a(String folderName) {
        WaitFor.clickable(filePage.newFolderNameInputBox);
        filePage.newFolderNameInputBox.clear();
        filePage.newFolderNameInputBox.sendKeys(folderName);
    }
    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        WaitFor.clickable(filePage.folderNameEnterBtn);
        filePage.folderNameEnterBtn.click();
    }
    @Then("Verify the {string} is displayed on the page")
    public void verify_the_is_displayed_on_the_page(String folderName) {
        WaitFor.Seconds(1);
        Assert.assertTrue(Utils.giveMeElementTexes(filePage.allElementsInLowerTable).contains(folderName.trim()));
    }
}
