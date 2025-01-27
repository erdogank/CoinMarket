package com.coinmarket.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml",
                //"me.jvt.cucumber.report.PrettyReports:target/cucumber",


        },
        features = "src/test/resources/features",
        glue = "com/coinmarket/step_definitions",
        monochrome = true,                        // Makes console output readable
        dryRun = false,
        tags = "@wip3",
        publish = true     //when this is true, it will publish a report that will be valid for 24 hours



)
public class CukesRunner {
}
