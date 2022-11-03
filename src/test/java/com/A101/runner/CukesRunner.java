package com.A101.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "junit:target/junit/junit-report.xml",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                //"pretty"
        },
        features = "src/test/resources/features",
        glue = "com/A101/step_definitions",
        dryRun = false,
        publish = false,
        tags = "@wip"
)

public class CukesRunner {
}
