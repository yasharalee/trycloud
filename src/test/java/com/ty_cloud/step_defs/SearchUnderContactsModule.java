package com.ty_cloud.step_defs;

import com.ty_cloud.pages.BasePage;
import com.ty_cloud.utilities.Utils;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class SearchUnderContactsModule extends BasePage {

    @When("users search any existing {string} name")
    public void users_search_any_existing_name(String keyWord) {
        searchInputOfContacts.sendKeys(keyWord);
        WaitFor.Seconds(3);
    }
    @Then("verify the app displays the expected {string} in result option")
    public void verify_the_app_displays_the_expected_in_result_option(String keyWord) {
         List <String> users = Utils.giveMeElementTexes(searchResults());
        Assert.assertTrue(users.contains(keyWord));
    }

}
