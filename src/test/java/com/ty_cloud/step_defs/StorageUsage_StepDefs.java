package com.ty_cloud.step_defs;

import com.ty_cloud.pages.BasePage;
import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.Utils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StorageUsage_StepDefs extends BasePage {

    String originalValue;
    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
        originalValue = usageInfoElement.getText();
    }
    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
    }
    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
        String current = usageInfoElement.getText();

        int perBefore = Utils.getPriority(Utils.usageByte(originalValue));
        int perAfter = Utils.getPriority(Utils.usageByte(current));

        int perivNumber = Utils.giveMeNumbersOnly(originalValue);
        int curNumbers = Utils.giveMeNumbersOnly(current);

        Assert.assertTrue(
             perBefore == perAfter? curNumbers > perivNumber : perBefore < perAfter
        );
    }
}
