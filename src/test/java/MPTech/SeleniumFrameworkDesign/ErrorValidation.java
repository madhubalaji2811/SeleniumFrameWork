package MPTech.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import MPTech.PageObjects.CartPage;
import MPTech.PageObjects.ProductCatalogue;
import MPTech.TestComponents.BaseTest;
import MPTech.TestComponents.Retry;


public class ErrorValidation extends BaseTest {

	@Test(groups={"Regression"},retryAnalyzer=Retry.class)
	public void loginerrorvalidation() {
	
		
		ProductCatalogue pc=lp.landingactions("abc@gmail.com","Aadhavan@28");
		String message=lp.geterrormessage();
		Assert.assertEquals("Incorrect email or password.",message);
		}
	
	
	@Test
	public void producterrorvalidation() throws InterruptedException {
		String productname="IPHONE 13 PRO";
		String Region="India";
		ProductCatalogue pc=lp.landingactions("whitegold@gmail.com","Stonecold@0");
		List<WebElement> products=pc.getproductlist();
		pc.addproduct(productname);
		CartPage cp=pc.gotoCartPage();
		Boolean check=cp.cartpagecheck("IPHONE 12 MAX");
		Assert.assertFalse(check);
		
		
	}

	
	
}
