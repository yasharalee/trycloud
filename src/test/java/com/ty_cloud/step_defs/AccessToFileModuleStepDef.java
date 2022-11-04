package com.ty_cloud.step_defs;

import com.ty_cloud.pages.BasePage;
import com.ty_cloud.pages.FilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class AccessToFileModuleStepDef extends BasePage {

    FilePage page = new FilePage();
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String moduleName) {
       WebElement menu = getModuleByVisibleText(moduleName);
       menu.click();
    }
    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() throws InterruptedException {
        page.checkboxSelectAll.click();
        Thread.sleep(2000);;
    }
    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        Boolean checkedAll = true;
        for (WebElement each : page.allCheckboxes) {
            if (!each.isSelected()){
                checkedAll = false;
            }
        }
        Assert.assertTrue(checkedAll);
    }

}
