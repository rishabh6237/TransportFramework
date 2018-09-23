package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinition.Utility;

public class HomePage 
{

	WebDriver driver;
	WebDriverWait wait;
	
	By fromStation = By.id("search-input-From");

	By toStation = By.id("search-input-To");

	By searchButton = By.id("search-button");
	
	By tripPlannerHeader = By.id("tab-pane-tp");
	
	By depart=By.className("tp-result-item-depart");
	
	By resultTripButton=By.xpath("//*[@icon-title='trip details collapsed']");
	
	By depName=By.xpath("//*[@class='trip-step-from']//*[@class='stop-name ng-binding']");
	
	By arrName=By.xpath("//*[@class='trip-step-to']//*[@class='stop-name ng-binding']");

	
	public HomePage(WebDriver driver)
	
	{
      this.driver = driver;
    }

    public void setFromStation(String strFromStation)
    {

    	wait = Utility.getWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(fromStation));

    	driver.findElement(fromStation).clear();
    	driver.findElement(fromStation).sendKeys(strFromStation);

    }

    

    public void setToStation(String strToStation)
    {

    	driver.findElement(toStation).clear();

    	driver.findElement(toStation).sendKeys(strToStation);

    }

    public void clickSearchButton()
    {

    driver.findElement(searchButton).click();

    }
	 
    /**
   	 * Purpose : Verify home page of the transport website
   	 */
    public WebElement verifyHomePage() throws InterruptedException

    {
    	wait = Utility.getWait(driver,20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(tripPlannerHeader));

    	return driver.findElement(tripPlannerHeader);
    	
    }
   
    /**
   	 * Purpose : searches for the route between two stations
   	 */
    public void searchRoute(String fromStation,String toStation) throws InterruptedException

    {    	
    	
    this.setFromStation(fromStation);
    	
  	this.setToStation(toStation);
    	
  	Thread.sleep(2000);
	this.clickSearchButton();
	Thread.sleep(2000);
   }
    
    
    /**
	 * Purpose : Verify that the trips shown are between the said stops
	 */
    public Boolean verifyListOfTrips(String departure,String arrival) throws InterruptedException

    {
    	Boolean flag = false;
    	wait = Utility.getWait(driver,20);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(resultTripButton));

    	Thread.sleep(2000);
    	List<WebElement> list = driver.findElements(resultTripButton);
    	
    	System.out.println("Trips "+list.size());
    	
    	
    	for(WebElement ele:list)
    	{
    		
    		ele.click();
    		
    		if(driver.findElement(depName).getText().contains(departure) && 
    				driver.findElement(arrName).getText().contains(arrival))
    		{
    			flag = true;
    		}
    		else
    		{
    			break;
    		}  		
      	}
      	return flag;
    }

    
    
    
    
}
