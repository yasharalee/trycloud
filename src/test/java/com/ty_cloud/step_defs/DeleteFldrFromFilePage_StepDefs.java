package com.ty_cloud.step_defs;

import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class DeleteFldrFromFilePage_StepDefs {

    FilePage filePage = new FilePage();

    @When("the users click action-icon from random file or folder on the page")
    public void the_users_click_action_icon_from_random_file_or_folder_on_the_page() {

        if (filePage.actions.size() > 0) {

            int index = filePage.actions.size() == 1 ? 0 : filePage.randomNumUpTo(filePage.actions.size() - 1);

            WebElement option = filePage.actions.get(index);
            filePage.fileName = filePage.allElementsInLowerTable.get(index).getText().trim();
            option.click();

        } else {
            System.out.println("No any item in the page");
        }
    }

    @When("user choose the submenu from given below")
    public void user_choose_the_submenu_from_given_below(List<String> list) {

        if (filePage.isItFolder(filePage.fileName)) {
            filePage.actionSubMenus(list.get(0).trim()).click();
        } else {
            filePage.actionSubMenus(list.get(1).trim()).click();
        }

    }

    @Then("Verify the deleted file is not displayed on the page")
    public void verify_the_deleted_file_is_not_displayed_on_the_page() {

        Driver.getDriver().navigate().refresh();

        List<WebElement> els = Driver.getDriver().findElements(By.xpath("(//tbody[@id='fileList'])[1]//span[@class='innernametext']"));

        if (!filePage.fileName.equals("Talk")) {
            WaitFor.visibilityOf(els.get(0));
            List<String> eletexes = els.stream().map(m -> m.getText().trim()).collect(Collectors.toList());
            Assert.assertFalse(eletexes.contains(filePage.fileName.trim()));
        } else {
            System.out.println("Folder \"Talk\" is not removable, test is not asserted ");
        }
    }

}
