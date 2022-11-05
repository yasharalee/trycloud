package com.ty_cloud.step_defs;

import com.ty_cloud.pages.FavoritePage;
import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveFilesStepDefs {

    FilePage filePage = new FilePage();
    FavoritePage favor = new FavoritePage();

    @When("the users click action-icon from any file on the page to remove")
    public void the_users_click_action_icon_from_any_file_on_the_page_to_remove() {

    }

    @When("user choose the Remove from favorites option")
    public void user_choose_the_option() {
//        filePage.addAllFilesToFavorites();
//        WaitFor.Seconds(1);
        filePage.removeAllFilesToFavorites();

    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String menu) {
        filePage.leftSideBarMenu("Favorites").click();

    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {

        List<String> favorFiles = favor.filesOnFavorites.stream().map(WebElement::getText)
                .filter(m->filePage.nameOfAllRemovedFiles.contains(m))
                .collect(Collectors.toList());

        Assert.assertEquals(0, favorFiles.size());

    }

}
