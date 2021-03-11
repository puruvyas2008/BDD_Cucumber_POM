package com.runner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(
		features = {"src/test/resource/feature/"},
		glue= {"stepDefinition","com.hooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome=true,
		publish = true,
		tags = "@tagSuc1"
		)

public class myRunner {

}
