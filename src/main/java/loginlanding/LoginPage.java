package loginlanding;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage{

	@FindBy(xpath = "//input[@data-test-selector = 'txtEmail']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@data-test-selector = 'txtPassword']")
	private WebElement passWord;
	


	// Method for the new user log-in details set-up
	public void setLoginDetails(String username,String password)
	{
		userName.click();
		userName.sendKeys(username);
		
		passWord.click();
		passWord.sendKeys(password);
		
	}// End of setLoginDetails

	
}// End of class LoginObjects
