package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/java/features"},
				 plugin ="json:target/jsonReports/cucmber-report.json",
				 glue={"stepDefinations"}
				 //tags="@DeletePlace"
				 			 )

public class TestRunner {

}
