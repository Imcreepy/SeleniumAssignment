package driver;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.interactions.Actions;

public class Manager {

	private static Actions driverAC;
	
	
	private static Robot driverRobot;
	
	// to get the instance of the action class.
	public static Actions getActionInstance()
	{
		if(driverAC == null)
		{
			driverAC = new Actions(Invoke.webDriver);
		}
		return driverAC;
	}// End of Instance of action method 
	

	// Get an instance of the Robot 
	public static Robot getRobotInstance()
	{
		if(driverRobot == null)
		{ 
			try 
			{
				driverRobot = new Robot();
			}
			catch(AWTException e)
			{
				System.out.println("The Robot members are not supported because of the error:");
				e.printStackTrace();
			}
		}
		return driverRobot;
	}
	
}
