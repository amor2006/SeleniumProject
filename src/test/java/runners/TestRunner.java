package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json" }, tags = {
		"@searchforA4" }, features = "classpath:functionaltests", glue = {
				"stepDefinitions" }, dryRun = false, monochrome = true)
//Runner class
public class TestRunner {

}
