package com.auto;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber-report/cucumber.json"
                , "rerun:target/failure/rerun.txt"}
        ,features = "features",
        glue = {"com.auto.steps"}
        )
public class RunCucumberIT {

}