package com.ty_cloud.step_defs;

import com.ty_cloud.pages.BasePage;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.Utils;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UpdateSettings_Stepdefs extends BasePage {

    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        settingsInsideMenu.click();
    }

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {
        List<WebElement> list = Utils.giveMeCheckboxes(allInputsUnderSettingsMenu);
        System.out.println(list);

        for (WebElement each : list) {
            boolean statusBefore = each.isSelected();
            String id = each.getAttribute("id");
            Driver.getDriver().findElement(By.xpath("//label[@for='" + id + "']")).click();
            boolean statusAfter = each.isSelected();

            Assert.assertNotEquals(statusBefore, statusAfter);

        }

    }

}
