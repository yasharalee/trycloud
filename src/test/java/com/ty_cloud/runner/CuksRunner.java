package com.ty_cloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", //gives info about scenario
                "html:target/report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/ty_cloud/step_defs",
        dryRun = false,
        tags = "@add_file"
        //tags = ""

)

public class CuksRunner {
}
