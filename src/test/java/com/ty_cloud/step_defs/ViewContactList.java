package com.ty_cloud.step_defs;

import com.ty_cloud.pages.BasePage;
import com.ty_cloud.pages.FilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ViewContactList extends BasePage {

    @When("the user clicks the right side {string} module")
    public void the_user_clicks_the_right_side_module(String menu) {
        rightSideModules(menu).click();
    }
    @Then("verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {
        Assert.assertTrue(contactList.size() >=2);
    }

}
