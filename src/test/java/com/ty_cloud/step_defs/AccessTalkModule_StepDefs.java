package com.ty_cloud.step_defs;

import com.ty_cloud.utilities.Utils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AccessTalkModule_StepDefs {

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expected) {
        Assert.assertEquals(expected,Utils.getTitle());
    }

}
