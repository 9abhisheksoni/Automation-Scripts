package testRunner;

import base.CucumberBase;
import cucumber.api.CucumberOptions;



@CucumberOptions(strict = true, monochrome = true, features = "src/test/resources/feature_backup/ProductDetailPage.feature", 
glue = "stepdefinition", format = {	"pretty"}, tags = {"@RunSanity"}, 
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-extent-reports/extent-report.html","json:target/cucumber.json"}, dryRun = false)



public class CucumberRunner extends CucumberBase {

}
