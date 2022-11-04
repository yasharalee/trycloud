package com.ty_cloud.step_defs;

import com.ty_cloud.pages.FavoritePage;
import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RemoveFilesStepDefs {

    FilePage filePage = new FilePage();
    FavoritePage favor = new FavoritePage();

    @When("the users click action-icon from any file on the page to remove")
    public void the_users_click_action_icon_from_any_file_on_the_page_to_remove() {

    }

    @When("user choose the Remove from favorites option")
    public void user_choose_the_option() {
        filePage.addAllFilesToFavorites();
       // WaitFor.Seconds(5);
        filePage.removeAllFilesToFavorites();
       // WaitFor.Seconds(5);
    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String menu) {
        filePage.leftSideBarMenu("Favorites").click();

    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        boolean res = true;
        for (int i = 0; i < filePage.copy.size(); i++) {
            if (favor.filesOnFavorites.contains(filePage.copy.get(i))){
                res = false;
            }
        }

        WaitFor.Seconds(5);

      Assert.assertTrue(res);

    }

}
