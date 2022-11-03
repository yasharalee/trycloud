package com.ty_cloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"me.jvt.cucumber.report.PrettyReports:target/cucumber"},
        features = "src/test/resources/features",
        glue = "com/ty_cloud/step_defs",
        dryRun = false,
       // tags = "@all but not (@login-sol or @invalid-login)"
        tags = ""

)

public class CuksRunner {}
