package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {".//Features/Login.feature"},
		glue="stepDefinitions",
		plugin= {"html:reports/myreport.html","json:reports/myreport.json"},
		//cross check..features related methods is available or not
		dryRun=false, //bydefault dryrun is false..
		monochrome=true,// to avoid junk charechter in console
		tags="@sanity"
		
		)




public class TestRunner {
//empty class, can't write anything here
}
