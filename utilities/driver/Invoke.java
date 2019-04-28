package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Invoke {
	
	static String browser;
	static String url;
	public static WebDriver webDriver;
	
	public static void openBrowser(String browser, String url)
	{
		Invoke.browser = browser;
		Invoke.url = url;
		
		try
		{									
			switch(browser.toLowerCase())     		// To check the browser value passed and open the same browser
 			{
 				case "ie":
 				{
 					WebDriverManager.iedriver().setup();
 					webDriver = new InternetExplorerDriver();
 					break;
 				}
				case "chrome":
				{
					WebDriverManager.chromedriver().setup();
					webDriver = new ChromeDriver();
					break;
				}
				case "mozila":
				{
					WebDriverManager.firefoxdriver().setup();
					webDriver = new FirefoxDriver();
					break;
				}
				default:
					System.out.println("The Browser Configuration is not Available");
				}// End of Browser switch
		}
		catch(Exception e)
		{
			throw new IllegalArgumentException("The arguments are different and it could not get open" +e); 
		}// Show the browser exception
			
		
		try
		{
			switch(url.toLowerCase())
			{
				case "live":
					webDriver.get("http://admin9x.znodellc.com/");
					break;
				default:
					System.out.println("Can not able to get URL");
			}// End of URL switch
		}
		catch(Exception e)
		{
			throw new IllegalStateException("Can able to get the URL invoked: " +e);
		}// End of catch
		
	}// End of openBrowser with driver and URL

	public static WebDriver getDriver() 
	{
		return webDriver;
	}

}// End of Browser 
	 