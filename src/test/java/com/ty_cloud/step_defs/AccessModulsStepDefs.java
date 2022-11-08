package com.ty_cloud.step_defs;

import com.ty_cloud.pages.BasePage;
import com.ty_cloud.pages.LoginPage;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AccessModulsStepDefs extends BasePage{

    LoginPage login = new LoginPage();

    @Given("When the users log in with valid {string} and {string}")
    public void when_the_users_log_in_with_valid_and(String user, String pass) {
        login.with(user, pass);
    }
    @Then("Then Verify the user see the following modules")
    public void then_verify_the_user_see_the_following(List<String> expectedModules){
        List<String> dum = new ArrayList<>();
        for (String each : expectedModules) {
            if (moduleTexts().contains(each)){
                dum.add(each);
            }
        }
        Assert.assertTrue(dum.size() == expectedModules.size());

    }
}
