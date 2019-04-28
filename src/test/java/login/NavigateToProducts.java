package login;

import org.testng.annotations.Test;

import loginlanding.Products;

public class NavigateToProducts {

	Products products;
	
	@Test(priority=1)
	public void Navigate()
	{
		products.NavigateToProducts();
	}
}
