package com.ty_cloud.step_defs;

import com.ty_cloud.pages.FavoritePage;
import com.ty_cloud.pages.FilePage;
import com.ty_cloud.utilities.Driver;
import com.ty_cloud.utilities.WaitFor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class AddingFileStepDefs {
    FilePage filePage = new FilePage();
    String fileName= "";

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        filePage.addButton.click();
    }
    @When("users uploads file with the {string} option")
    public void users_uploads_file_with_the_upload_file_option(String subMenu) {
        String path = "C:/Users/yasha/OneDrive/Desktop/Java/trycloud/cool-pictures-for-nawpic-25.jpg";
        int ind = path.lastIndexOf("/");
        fileName = path.substring(ind+1);

// This lines below Aysun
       WebElement inputEl =  Driver.getDriver().findElement(By.xpath("//input[@id='file_upload_start']"));


        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());

        js.executeScript("arguments[0].style.overflow='visible !important'; arguments[0].style.appearance='block !important'; arguments[0].style.display='block !important'",inputEl);

        System.out.println(inputEl.getCssValue("overFlow"));

       inputEl.sendKeys(path);


    }


    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        List<String> actualFileList = filePage.allFileElements.stream().map(WebElement::getText).collect(Collectors.toList());
        WaitFor.Seconds(6);
        Assert.assertTrue(actualFileList.contains(fileName));

    }

}
