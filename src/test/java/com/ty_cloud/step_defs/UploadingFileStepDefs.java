package com.ty_cloud.step_defs;


import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.ConfigReader;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class UploadingFileStepDefs {
    FilePage filePage = new FilePage();
    String fileName= "";

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {

        filePage.AddFileBtn.click();

    }


    @When("users uploads file with the {string} option")
    public void users_uploads_file_with_the_upload_file_option(String subMenu) {

        WaitFor.Seconds(2);

      filePage.inputFile.sendKeys(ConfigReader.getProperty("filePath"));

        WaitFor.invisibilityOf(filePage.progressBar);

        fileName = ConfigReader.getProperty("filePath").substring(ConfigReader.getProperty("filePath").lastIndexOf("/")+1, ConfigReader.getProperty("filePath").lastIndexOf("."));

    }


    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        List<String> actualFileList = filePage.allFileElementsInLowerTable.stream().map(WebElement::getText).collect(Collectors.toList());
        Assert.assertTrue(actualFileList.contains(fileName));
    }
}
