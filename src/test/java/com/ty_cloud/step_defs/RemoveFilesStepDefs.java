package com.ty_cloud.step_defs;

import com.ty_cloud.pages.FavoritePage;
import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RemoveFilesStepDefs {

    FilePage filePage = new FilePage();
    FavoritePage favor = new FavoritePage();
    int temInt = 0;

    @When("the users click action-icon from random file or  folder on the page")
    public void the_users_click_action_icon_from_random_file_or_folder_on_the_page() {

        if (filePage.actions.size() > 0) {

            int index = filePage.actions.size() == 1 ? 0 : filePage.randomNumUpTo(filePage.actions.size() - 1);
            temInt = index;

            WebElement option = filePage.actions.get(index);
            filePage.fileName = filePage.allElementsInLowerTable.get(index).getText().trim();
            option.click();

            WaitFor.clickable(Driver.getDriver().findElement(By.xpath("" +
                    "//div[contains(@class, 'fileActionsMenu popovermenu bubble')]//*[.='Rename']/..")));

        } else {
            System.out.println("No any item on the page");
        }
    }



    @When("user choose the Remove from favorites option")
    public void user_choose_the_option() {
        if(filePage.allElementsInLowerTable.size() > 0) {
            boolean done = true;
            do {

              WebElement firstMenu = Driver.getDriver().findElement(By.xpath("" +
                      "(//div[contains(@class, 'fileActionsMenu popovermenu bubble')]//span)[6]"));
              if (firstMenu.getText().equals("Remove from favorites")) {
                  System.out.println("was remove");
                  firstMenu.click();
                  done = false;
              }else {
                  System.out.println("was NOT remove");
                  try{
                      firstMenu.click();
                  }catch (StaleElementReferenceException e){
                      Driver.getDriver().findElement(By.xpath("" +
                              "(//div[contains(@class, 'fileActionsMenu popovermenu bubble')]//span)[6]")).click();
                  }

                  int ranNum = filePage.randomNumUpTo(filePage.allElementsInLowerTable.size());

                  ranNum = ranNum == 0 ? 0 : ranNum -1;
                  System.out.println(ranNum);
                  temInt = ranNum;

                  try {
                      filePage.actions.get(ranNum).click();
                  }catch (StaleElementReferenceException e){
                      Driver.getDriver().findElements(By.xpath("" +
                              "//a[contains(@class, 'action action-menu permanent')]"))
                              .get(ranNum).click();
                  }

                  filePage.fileName = filePage.allElementsInLowerTable.get(ranNum).getText();
                  done = true;

              }

            }while (done);
            System.out.println("out of loop");
        }
    }

    @When("user click the sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String menu) {
        filePage.leftSideBarMenu(menu).click();

    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        System.out.println("assertion part");
        List<String> favorFiles = favor.filesOnFavorites.stream().map(WebElement::getText)
                .filter(m-> m.equals(filePage.fileName))
                .collect(Collectors.toList());

        Assert.assertEquals(0, favorFiles.size());

    }

}
