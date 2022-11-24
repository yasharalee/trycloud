package com.ty_cloud.step_defs;

import com.ty_cloud.pages.BasePage;
import com.ty_cloud.pages.FavoritePage;
import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.Common;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;


public class AddToFavoriteStepdefs extends BasePage {
    FavoritePage favor = new FavoritePage();

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {

        List<String> favorFiles = favor.filesOnFavorites.stream().map(WebElement::getText)
                .filter(m-> m.trim().equals(Common.fileNameAdd.trim()))
                .collect(Collectors.toList());

        Assert.assertTrue(favorFiles.contains(Common.fileNameAdd.trim()));

    }

}



