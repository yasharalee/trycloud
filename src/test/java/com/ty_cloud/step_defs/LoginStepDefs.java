package com.ty_cloud.step_defs;

import com.ty_cloud.pages.LoginPage;
import com.ty_cloud.utilities.ConfigReader;
import com.ty_cloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage login = new LoginPage();
    @Given("user on login page")
    public void user_on_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @Given("user enters {string}{string} credentials")
    public void user_enters_credentials(String user, String pass) {
        login.with(user, pass);
    }
    @Then("user should be able access dashboord")
    public void user_should_be_able_access_dashboord() {
        Assert.assertEquals("Dashboard - Trycloud QA", Driver.getDriver().getTitle());
    }

}
