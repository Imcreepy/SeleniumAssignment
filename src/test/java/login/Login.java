package login;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.Browser;
import driver.Invoke;
import loginlanding.LoginPage;

public class Login{
	
	LoginPage loginPage;

	
	// Method to open the browser with URL
	@Test(priority=0)  				// Test case to open the browser and pass the url
	@Parameters({"browser","url"})
	public void openBrowser(String browser, String url)
	{	
		Invoke.openBrowser(browser, url);
		System.out.println("browser opened");
		Browser.maximizeBrowser();
	}// End of Open browser test
			

	// To check the user log-in with new and existing user
	@Test(priority=2)			// Test case to all the details to the log-in page
	@Parameters({"username","password"})
	public void setLoginDetails(String username,String password)
	{
		loginPage = PageFactory.initElements(Invoke.webDriver,LoginPage.class);
		loginPage.setLoginDetails(username, password);		
	}// End of details page
	
	@Test(priority=3)
	public void clickLogIn()
	{
		loginPage.clickLogIn();
	}
	
	@Test(priority=4)
	public void clickLaterButton()
	{
		loginPage.laterButtonPopUp();
	}
	
	@Test(priority=5)
	public void Navigate()
	{
		loginPage.NavigateToProducts();
	}
	
	@Test(priority=6)
	public void AddNewProduct()
	{
		loginPage.AddNewProduct();
	}
	
}// End of set browser