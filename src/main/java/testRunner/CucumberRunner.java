package testRunner;


import base.CucumberBase;
import cucumber.api.CucumberOptions;

@CucumberOptions(strict = true, monochrome = true, features = "src/test/resources/features/ProdDeploymentChecklist.feature", glue = "stepdefinition", format = {
		"pretty", "json:target/cucumber.json" }, tags = { "@PLPSORT" }, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent-reports/extent-report.html" }, dryRun = false)

public class CucumberRunner extends CucumberBase {


}
