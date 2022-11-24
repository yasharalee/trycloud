package com.ty_cloud.step_defs;

import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.ConfigReader;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class UploadFileToFolder_StepDefs {
    FilePage filePage = new FilePage();

    @When("user choose a folder  from the page")
    public void user_choose_a_folder_from_the_page() {
        Random random = new Random();

        WaitFor.Seconds(1);
        List<WebElement> folders = filePage.allElementsInLowerTable.stream().filter(m -> filePage.isItFolder(m.getText())).collect(Collectors.toList());

        if (folders.size() == 0) {
            filePage.generateFolder();
            user_choose_a_folder_from_the_page();
        }else {
            int ind = folders.size() == 1 ? 0 : random.nextInt(folders.size() - 1);
            WaitFor.clickable(folders.get(ind));
            folders.get(ind).click();
        }

    }

    @When("user uploads a file inside the chosen folder")
    public void user_uploads_a_file_inside_the_chosen_folder(String path) {

        WaitFor.Seconds(2);

        String tPath = ConfigReader.getProperty(path);

        filePage.inputFile.sendKeys(tPath);

        WaitFor.invisibilityOf(filePage.progressBar);

        filePage.fileName = tPath.substring(tPath.lastIndexOf("/") + 1, tPath.lastIndexOf("."));

    }

    @Then("Verify the File is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        List<String> fileNames1 =
                filePage.allFilesInsideFolder.stream().map(WebElement::getText)
                        .map(m -> {
                            String name = m;
                            if (m.lastIndexOf(".") != -1) {
                                name = m.substring(0, m.lastIndexOf("."));
                            }
                            return name.trim();
                        })
                        .collect(Collectors.toList());
        WaitFor.visibilityOf(filePage.allFilesInsideFolder.get(0));
        Assert.assertTrue(fileNames1.contains(filePage.fileName.trim()));
    }

}
