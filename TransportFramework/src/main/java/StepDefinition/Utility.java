package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility
{

	WebDriver driver;
	public static Properties propTestcase;
	
	
	public Utility(WebDriver driver)
    
    {
    
    	this.driver = driver;

    }
	
	/**
	 * Purpose : Returns a instance of Explicit Web Driver Wait
	 */
	public static WebDriverWait getWait(WebDriver driver,int seconds)
	{
	return new WebDriverWait(driver,seconds);	
	}
	
	/**
	 * Purpose : Loads the data that will be used in automation
	 * @author rish
	 */
	public void setPropertyFiles()
	{
		
		
		propTestcase = new Properties();
		try {
			
		propTestcase.load(new FileInputStream(System.getProperty("user.dir")+File.separator+"resources"+File.separator+"data.properties"));
		System.out.println(System.getProperty("user.dir")+File.separator+"resources"+File.separator+"data.properties");
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Purpose : returns the data property file
	 * @author rish
	 */
	public Properties getPropTestcase(){
		  return propTestcase;
	}
	
	/**
	 * Purpose : returns chrome driver
	 * @author rish
	 */
	public WebDriver getChromeDriver()
	{
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
		File.separator+"drivers"+File.separator+"chromedriver.exe");
		//adding some options to chrome driver	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");	
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability(ChromeOptions.CAPABILITY,options);
		driver = new ChromeDriver(caps);
		
		return driver;
	}
	
	
	/**
	 * Purpose : used to take screenshot of the screen in case there is any failure
	 * @author rish
	 */
	public void takeScreenShot(WebDriver driver) throws Exception
	{
		
		System.out.println("Taking Screenshot");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		DateFormat dateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh_mm_ss a");
		Date date = new Date();
		
		
		String dateString=dateFormat.format(date);
		System.out.println("dateString "+dateString);
		
	    String fileLocation= System.getProperty("user.dir")+File.separator+"ErrorScreenShot"+File.separator;

	    System.out.println("fileLocation" +fileLocation);
		FileUtils.copyFile(scrFile, new File(fileLocation+"Error on "+dateString+".png"));
		
		System.out.println("Taken Screenshot");
		}
	
	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
}
