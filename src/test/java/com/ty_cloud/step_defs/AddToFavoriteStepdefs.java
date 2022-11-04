package com.ty_cloud.step_defs;

import com.ty_cloud.pages.BasePage;
import com.ty_cloud.pages.FavoritePage;
import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.Utils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class AddToFavoriteStepdefs extends BasePage {

    FilePage filePage = new FilePage();
    FavoritePage favor = new FavoritePage();

    @When("the user clicks action-icon from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {


    }
    @When("user choose the Add to favorites option")
    public void user_choose_the_option() {
        filePage.addAllFilesToFavorites();
    }


    @When("user click the Favorites sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side() {
        filePage.leftSideBarMenu("Favorites").click();
    }
    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {


        boolean res = true;

        for (String s : filePage.nameOfAllAddedFiles) {
            if (!favor.filesOnFavorites.contains(s)){
                res = false;
            }
        }

        Assert.assertTrue(res);



    }

}



