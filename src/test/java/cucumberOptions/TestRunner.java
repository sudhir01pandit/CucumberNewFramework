package cucumberOptions;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/java/features",
		glue= {"stepDefinations"},
		plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "json:target/cucumber-reports/CucumberTestReport.json",
       },
				dryRun = false
		
		)

public class TestRunner 
{
  
}



