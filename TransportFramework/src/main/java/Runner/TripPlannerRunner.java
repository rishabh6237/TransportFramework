package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features= {"src/main/java/Transport/TripPlanner.feature"},
glue= {"StepDefinition"},
format= {"pretty","html:test-output"},
monochrome=true,//gives output in readable format,
dryRun=false//just checks each step has a function for it
)
public class TripPlannerRunner {


}
