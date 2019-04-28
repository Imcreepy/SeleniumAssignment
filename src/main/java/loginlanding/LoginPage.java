package loginlanding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Invoke;



public class LoginPage{

	@FindBy(xpath = "//input[@id='btnUsername']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='btnPassword']")
	private WebElement passWord;
	
	@FindBy(xpath = "//button[@id='Login']")
	private WebElement logIn;


	// Method for the new user log-in details set-up
	public void setLoginDetails(String username,String password)
	{
		userName.click();
		userName.sendKeys(username);
		
		passWord.click();
		passWord.sendKeys(password);
		
	}// End of setLoginDetails
	
	public void clickLogIn()
	{
		logIn.click();
	}
	
	@FindBy(xpath="//div[@class='modal-content']")
	private WebElement popUp;
	
	@FindBy(xpath="//button[@id='Later']")
	private WebElement later;
	
	public void laterButtonPopUp()
	{
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Invoke.webDriver)							
//				.withTimeout(30, TimeUnit.SECONDS) 			
//				.pollingEvery(5, TimeUnit.SECONDS) 			
//				.ignoring(NoSuchElementException.class);
		
		Invoke.webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		later.click();

	}
	
	@FindBy(xpath = "//a[@data-test-selector=\'linkNavMenu\']")
	private WebElement menu;
	
	@FindBy(xpath = "//a[@data-test-selector='linkProducts']")
	private WebElement linkProducts;
	
	@FindBy(xpath = "//div[@id=\'loading-div-background\']")
	private WebElement loader;
	
	public void NavigateToProducts()
	{	
		loadingWait(Invoke.webDriver, loader);
		
		menu.click();
		
		linkProducts.click();
		
		loadingWait(Invoke.webDriver, loader);
	}
	
	public void loadingWait(WebDriver driver, WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOf(element)); // wait for loader to appear
	    wait.until(ExpectedConditions.invisibilityOf(element)); // wait for loader to disappear
	}
	
	
	@FindBy(xpath = "//a[@data-test-selector=\'btnAddNew\']")
	private WebElement addNew;
	
	@FindBy(xpath = "//a[@id=\'btnSaveNDraft\']")
	private WebElement saveAsDraft;
	
	DateFormat dateFormat = new SimpleDateFormat("HHmmss");

	 //get current date time with Date()
	 Date date = new Date();

	 // Now format the date
	 String date1= dateFormat.format(date);
	 
	 Actions actions = new Actions(Invoke.webDriver);
	 
	public void AddNewProduct()
	{
		addNew.click();
		
		loadingWait(Invoke.webDriver, loader);
		
		saveAsDraft.click();
		
		WebElement selectProductType = Invoke.webDriver.findElement(By.xpath("//select[@data-test-selector=\'drpProductType\']"));
		
		Select SelectProductType = new Select(selectProductType);
		
		SelectProductType.selectByValue("BundleProduct");
		
		loadingWait(Invoke.webDriver, loader);
		
		saveAsDraft.click();
		
		Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector=\"txtProductName\"]")).sendKeys("Automation" + date1);
		
		Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector=\"txtSKU\"]")).sendKeys("Automation" + date1);
		
		Invoke.webDriver.findElement(By.xpath("//input[@data-test-selector=\"txtProductCode\"]")).sendKeys("Automation" + date1);
		
		WebElement selectOutOfStockOption = Invoke.webDriver.findElement(By.xpath("//select[@data-test-selector=\"drpOutOfStockOptions\"]"));
		
		actions.moveToElement(selectOutOfStockOption);
		
		actions.perform();
		 
		Select outOfStockOp = new Select(selectOutOfStockOption);
		
		outOfStockOp.selectByValue("DontTrackInventory");
		
		WebElement selectShippingCost = Invoke.webDriver.findElement(By.xpath("//select[@data-test-selector=\"drpShippingCostRules\"]"));
		
		actions.moveToElement(selectShippingCost);
		
		actions.perform();
		
		Select shippingCost = new Select(selectShippingCost);
		
		shippingCost.selectByValue("QuantityBasedRate");
		
		saveAsDraft.click();
	}


	
}// End of class LoginObjects
