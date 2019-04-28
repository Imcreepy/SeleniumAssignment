package loginlanding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Invoke;

public class Products {

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
}
