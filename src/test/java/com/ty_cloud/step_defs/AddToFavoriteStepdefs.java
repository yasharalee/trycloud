package com.ty_cloud.step_defs;

import com.ty_cloud.pages.BasePage;
import com.ty_cloud.pages.FavoritePage;
import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.Utils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class AddToFavoriteStepdefs extends BasePage {

    FilePage page = new FilePage();
    FavoritePage favor = new FavoritePage();
    List<String> addedFileNames;
    @When("the user clicks action-icon from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {


    }
    @When("user choose the Add to favorites option")
    public void user_choose_the_option() {
        page.clickOnActions();
    }


    @When("user click the Favorites sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side() {
        addedFileNames = page.addedFiles;
        page.favoriteSideMenu.click();
    }
    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        List<String> namesOnFavorite = favor.filesOnFavorites.stream().map(WebElement::getText).collect(Collectors.toList());

        boolean res = true;

        for (String s : addedFileNames) {
            if (!namesOnFavorite.contains(s)){
                res = false;
            }
        }

        Assert.assertTrue(res);

        Utils.Logout();

    }

}



