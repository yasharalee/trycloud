package com.ty_cloud.step_defs;

import com.ty_cloud.pages.FavoritePage;
import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.Common;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveFilesStepDefs extends Common {

    FilePage filePage = new FilePage();
    FavoritePage favor = new FavoritePage();
    int temInt = 0;

    @When("the users click action-icon from random file or  folder and chooses {string}")
    public void the_users_click_action_icon_from_random_file_or_folder_and_chooses(String menu) {
        if (actions.size() >= 1) {
            if (menu.equalsIgnoreCase("Remove from favorites")) {
                WaitFor.clickable(actions.get(0));
                for (int j = 1; j < 3; j++) {

                    boolean done = false;

                    for (int i = 0; i < 1; i++) {
                        if (actions.get(i).getText().equals("Actions")) {
                            continue;
                        }
                        try {
                            actions.get(i).click();
                        } catch (StaleElementReferenceException e) {
                            Driver.getDriver().findElements(By.xpath("(//tbody[@id='fileList'])[1]//a[@class='action action-menu permanent']")).get(0).click();
                        }
                        WebElement firstMenu = Driver.getDriver().findElement(By.xpath("" +
                                "(//*[@id=\"fileList\"]//ul//li//a)[3]"));
                        if (firstMenu.getText().equals(menu)) {
                            fileNameRemove = allElementsInLowerTable.get(i).getText();
                            firstMenu.click();
                            done = true;
                            break;
                        }
                        firstMenu.click();

                    }
                    if (done) {
                        break;
                    }
                }
            } else if (menu.equalsIgnoreCase("Add to favorites")) {
                WaitFor.clickable(actions.get(actions.size()-1));
                for (int j = actions.size()-1; j > actions.size()-3; j--) {

                    boolean done = false;

                    for (int i = actions.size()-1;i > actions.size()-3;i--) {
                        if (actions.get(i).getText().equals("Actions")) {
                            continue;
                        }
                        try {
                            actions.get(i).click();
                        } catch (StaleElementReferenceException e) {
                            Driver.getDriver().findElements(By.xpath("(//tbody[@id='fileList'])[1]//a[@class='action action-menu permanent']")).get(0).click();
                        }
                        WebElement firstMenu = Driver.getDriver().findElement(By.xpath("" +
                                "(//*[@id=\"fileList\"]//ul//li//a)[3]"));
                        if (firstMenu.getText().equals(menu)) {
                            fileNameAdd = allElementsInLowerTable.get(i).getText();
                            firstMenu.click();
                            done = true;
                            break;
                        }
                        firstMenu.click();

                    }
                    if (done) {
                        break;
                    }
                }
            } else if (actions.size() > 0) {
                actions.get(0).click();
                subMenuByName(menu).click();
            }


        } else {
            System.out.println("There is not any file/folder on the page");
        }
    }


    @When("user click the sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String menu) {
        filePage.leftSideBarMenu(menu).click();

    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        List<String> favorFiles = favor.filesOnFavorites.stream().map(WebElement::getText)
                .filter(m -> m.equals(filePage.fileName))
                .collect(Collectors.toList());

        Assert.assertEquals(0, favorFiles.size());

    }

}
