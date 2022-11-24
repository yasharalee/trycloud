package com.ty_cloud.step_defs;


import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.ConfigReader;
import com.ty_cloud.utilities.Utils;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;

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

        String tPath = ConfigReader.getProperty(path);

      filePage.inputFile.sendKeys(tPath);

        WaitFor.invisibilityOf(filePage.progressBar);

        filePage.fileName = tPath.substring(tPath.lastIndexOf("/")+1, tPath.lastIndexOf("."));

    }


    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {

        List<String> actualFileList = Utils.giveMeElementTexes(filePage.allElementsInLowerTable);
        Assert.assertTrue(actualFileList.contains(filePage.fileName));
    }
}
