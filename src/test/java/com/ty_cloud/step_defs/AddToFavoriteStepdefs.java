package com.ty_cloud.step_defs;

import com.ty_cloud.pages.BasePage;
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
import java.util.stream.Collectors;


public class AddToFavoriteStepdefs extends BasePage {

    FilePage filePage = new FilePage();
    FavoritePage favor = new FavoritePage();
    int temInt = 0 ;
    @When("the users click action-icon from random file  or folder on the page")
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
            System.out.println("No any item in the page");
        }
    }



    @When("user choose the Add to favorites option")
    public void user_choose_the_option() {
        if(filePage.allElementsInLowerTable.size() > 0) {
            boolean done = true;
            do {

                WebElement firstMenu = Driver.getDriver().findElement(By.xpath("" +
                        "(//div[contains(@class, 'fileActionsMenu popovermenu bubble')]//span)[6]"));
                if (firstMenu.getText().equals("Add to favorites")) {
                    System.out.println("was add");
                    firstMenu.click();
                    done = false;
                }else {
                    System.out.println("was NOT add");
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


    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {

        List<String> favorFiles = favor.filesOnFavorites.stream().map(WebElement::getText)
                .filter(m-> m.trim().equals(filePage.fileName.trim()))
                .collect(Collectors.toList());

        Assert.assertTrue(favorFiles.contains(filePage.fileName.trim()));

    }

}



