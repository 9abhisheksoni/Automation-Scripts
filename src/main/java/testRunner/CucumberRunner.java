package testRunner;


import base.CucumberBase;
import cucumber.api.CucumberOptions;

@CucumberOptions(strict = true, monochrome = true, features = "src/test/resources/feature_backup", 
glue = "stepdefinition", format = {	"pretty"}, tags = { "@Smoke" }, 
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent-reports/extent-report.html" }, dryRun = false)

public class CucumberRunner extends CucumberBase {


}
