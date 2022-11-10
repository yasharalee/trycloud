package com.ty_cloud.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "pretty", //gives info about scenario
                "html:target/report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "junit:target/junit/junit-report.xml",
                "rerun:target/rerun.txt"
        },
        features = "src/test/resources/features",
        glue = "com/ty_cloud/step_defs",
        dryRun = false,
        tags = "@verify_search_res",
        publish = true

)

public class CuksRunner {}
