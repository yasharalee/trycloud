package com.ty_cloud.step_defs;

import com.ty_cloud.utilities.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.ty_cloud.utilities.ConfigReader;
import com.ty_cloud.utilities.Driver;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp()  {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }



 @After
    public  void tearDown(Scenario scenario){
     if (!scenario.getName().equals("Verify user login fail with invalid credentials")){
         Utils.Logout();
     }
        Driver.closeDriver();
    }

}
