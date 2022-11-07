package com.ty_cloud.step_defs;

import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.Utils;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class DeleteFldrFromFilePage_StepDefs {

    FilePage filePage = new FilePage();
    @When("the users click action-icon from random file or folder on the page to remove")
    public void the_users_click_action_icon_from_random_file_or_folder_on_the_page_to_remove() {

        if (filePage.actions.size() != 0){
            int element = filePage.actions.size()==1?0:filePage.randomNumUpTo(filePage.actions.size()-1);
            WebElement option =  filePage.actions.get(element);
            filePage.fileName = filePage.allElementsInLowerTable().get(element).getText();
            option.click();

        }else {
            filePage.generateFolder();
            the_users_click_action_icon_from_random_file_or_folder_on_the_page_to_remove();
        }
    }
    @When("user choose the submenu from given below")
    public void user_choose_the_submenu_from_given_below(List<String> list) {

        try{
            filePage.actionSubMenus(list.get(0)).click();
        }catch (NoSuchElementException e){
            filePage.actionSubMenus(list.get(1)).click();
        }catch (RuntimeException e){
            System.out.println("catch line 41 deleteFldr");
        }

//       if (filePage.isItFolder((filePage.fileName))){
//           filePage.actionSubMenus(list.get(0)).click();
//       }else {
//           filePage.actionSubMenus(list.get(1)).click();
//       }

    }
    @Then("Verify the deleted file is not displayed on the page")
    public void verify_the_deleted_file_is_not_displayed_on_the_page() {

        Driver.getDriver().navigate().refresh();
        List fileNames = Utils.giveMeElementTexes(filePage.allElementsInLowerTable());
        System.out.println(fileNames);
        System.out.println(filePage.fileName);
        Assert.assertFalse(fileNames.contains(filePage.fileName.trim()));
    }

}
