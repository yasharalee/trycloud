package com.ty_cloud.step_defs;

import com.ty_cloud.excel_actors.ReadExcel;
import com.ty_cloud.pages.LoginPage;
import com.ty_cloud.utilities.ConfigReader;
import com.ty_cloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage login = new LoginPage();
    ReadExcel read ;

    @Given("user on login page")
    public void user_on_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Given("user enters {int} from credentials excel {string}")
    public void user_enters_from_credentials_excel(Integer combNum, String sheetName) {
         read = new ReadExcel(sheetName);
        String user = read.getSingleRow(combNum).get("username");
        String pass = read.getSingleRow(combNum).get("password");
        login.with(user, pass);

    }

    @Then("user should be able access dashboord")
    public void user_should_be_able_access_dashboord() {
        Assert.assertEquals("Dashboard - Trycloud QA", Driver.getDriver().getTitle());
    }

    @Then("verify {int} message should be displayed")
    public void verifyMessageShouldBeDisplayed(int rowNum) {
        String msg = read.getSingleRow(rowNum).get("message");
        Assert.assertEquals(msg, login.errorMsg.getText());
    }
}
