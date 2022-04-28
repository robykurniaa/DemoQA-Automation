package com.demoqa.glue.all;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { 
		"pretty", "html:target/cucumber-report-demoqa.html" }, 
		features = {
		"src/main/resources/features"})
public class AllStepRunnerTest {

}
