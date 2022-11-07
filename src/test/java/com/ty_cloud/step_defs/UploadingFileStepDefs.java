package com.ty_cloud.step_defs;


import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.ConfigReader;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class UploadingFileStepDefs {
    FilePage filePage = new FilePage();


    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        WaitFor.clickable(filePage.addBtn);
        filePage.addBtn.click();

    }


    @When("user clicks Upload file and uploads")
    public void user_uploads_a_file_inside_the_chosen_folder(String path) {

        WaitFor.Seconds(2);

      filePage.inputFile.sendKeys(ConfigReader.getProperty(path));

        WaitFor.invisibilityOf(filePage.progressBar);

        filePage.fileName = ConfigReader.getProperty(path).substring(ConfigReader.getProperty(path).lastIndexOf("/")+1, ConfigReader.getProperty(path).lastIndexOf("."));

    }


    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        List<String> actualFileList = filePage.allElementsInLowerTable().stream().map(WebElement::getText).collect(Collectors.toList());
        Assert.assertTrue(actualFileList.contains(filePage.fileName));
    }
}
