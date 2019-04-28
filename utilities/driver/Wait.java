package driver;

import java.time.Clock;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	static WebDriverWait exWait;

	
	// To get the wait time and perform driver to stop till that time
	public static void implicitWait(int waitTimeMili) // Getting waitTimeMili wait time
	{
		Invoke.webDriver.manage().timeouts().implicitlyWait(waitTimeMili, TimeUnit.MILLISECONDS);
	}// End of wait implicitly 
	
	// No argument Explicit wait method to get the Explicit wait object (Default timeout is 60)
	public static WebDriverWait initializeExplicitWait()
	{
		int timeout = 60;
		if(exWait == null)
		{
			exWait = new WebDriverWait(Invoke.webDriver,timeout);
		}
		return exWait;
	}// End of No argument Explicit wait method
	
	
	// Timeout argument  Explicit wait method to get the Explicit wait object (timeout is user provided)
	public static WebDriverWait initializeExplicitWait(int timeout)
	{
		if(exWait == null)
		{
			exWait = new WebDriverWait(Invoke.webDriver, timeout);
		}
		return exWait;
	}// End of No Timeout argument Explicit wait method
	
	// Timeout  & Watch frequency arguments for Explicit wait method to get the Explicit wait object (timeout is user provided)
	public static WebDriverWait initializeExplicitWait(int timeout, int watchFrequency)
		{
			if(exWait == null)
			{
				exWait = new WebDriverWait(Invoke.webDriver, timeout, watchFrequency);
			}
			return exWait;
		}// End of Timeout  & Watch frequency  Explicit wait method


	// All arguments for Explicit wait method to get the Explicit wait object (timeout is user provided)
	public static WebDriverWait initializeExplicitWait(Clock clock, Sleeper sleepObject, int timeout, int watchFrequency)
		{
			if(exWait == null)
			{
				exWait = new WebDriverWait(Invoke.webDriver, clock, sleepObject, timeout, watchFrequency);
			}
			return exWait;
		}// End of All arguments  Explicit wait method		
	
	
		
}// End of DriverCapabilities
