package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.HomePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TripPlanStepDefinition 
{

	
	WebDriver driver;
	Utility objUtility;
	HomePage objHome;
	String from_Station,to_Station;
	
	
	public String getFrom_Station() {
		return from_Station;
	}

	public void setFrom_Station(String from_Station) {
		this.from_Station = from_Station;
	}
	
	public String getTo_Station() {
		return to_Station;
	}



	public void setTo_Station(String to_Station) {
		this.to_Station = to_Station;
	}



	@Before
    public void initializeTest()
	
	{
		objUtility = new Utility(driver);
		
		driver = objUtility.getChromeDriver();
	
		objUtility.setPropertyFiles();
    }
	
	

@Given("^Phileas is planning a trip$")
public void phileas_is_planning_a_trip() throws Throwable 
{
    // Write code here that turns the phrase above into concrete actions
	String mainURL = objUtility.getPropTestcase().getProperty("mainURL");
	driver.get(mainURL);
	
}

@When("^he executes a trip plan from \"([^\"]*)\" to \"([^\"]*)\"$")
public void he_executes_a_trip_plan_from_to(String fromStation, String toStation) throws Throwable 
{
    // Write code here that turns the phrase above into concrete actions
    
	objHome=new HomePage(driver);
	
	String TripPlannerHeadText = objUtility.getPropTestcase().getProperty("TripPlannerHeadText");
	Assert.assertEquals("The trip planner header text is not correct", TripPlannerHeadText,objHome.verifyHomePage().getText() );
	
	setFrom_Station(fromStation);
	setTo_Station(toStation);
	
	objHome.searchRoute(fromStation,toStation);
	
}

@Then("^a list of trips should be provided$")
public void a_list_of_trips_should_be_provided() throws Throwable 

{
  // Write code here that turns the phrase above into concrete actions
 
  Assert.assertTrue("The list is not correct", objHome.verifyListOfTrips(getFrom_Station(),getTo_Station()) );	
}
	
@After
public void AfterTest(Scenario scenario)
{
	
	if (scenario.isFailed()) {
        try {
            // Code to capture and embed images in test reports (if scenario fails)
        	objUtility.takeScreenShot(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        }

	objUtility.deleteAllCookies();
	driver.quit();
}


}
