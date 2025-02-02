package MPTech.SeleniumFrameworkDesign;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MPTech.PageObjects.CartPage;
import MPTech.PageObjects.Checkoutpage;
import MPTech.PageObjects.OrderPage;
import MPTech.PageObjects.ProductCatalogue;
import MPTech.PageObjects.SubmitOrder;
import MPTech.TestComponents.BaseTest;

public class BaseCodeOriginalmod extends BaseTest {
	public	String productname="IPHONE 13 PRO";
	@Test(dataProvider="getdataprovider",groups="Purchase")
	public void placeorder(HashMap<String,String> input) throws IOException, InterruptedException {
	
		// TODO Auto-generated method stub
		productname="IPHONE 13 PRO";
		String Region="India";
		ProductCatalogue pc=lp.landingactions(input.get("email"),input.get("password"));
		List<WebElement> products=pc.getproductlist();
		pc.addproduct(productname);
		CartPage cp=pc.gotoCartPage();
		Boolean check=cp.cartpagecheck(productname);
		Assert.assertTrue(check);
		Checkoutpage ckp=cp.checkout();
		ckp.selectcountry(Region);
		SubmitOrder so=ckp.submitorder();
		String confirmation=so.verifyconfirmationmsg();
		Assert.assertEquals(confirmation, "THANKYOU FOR THE ORDER.");
		
		
	}

	
	@Test(dependsOnMethods="placeorder")
	public void checkorderpage() {
		
		ProductCatalogue pc=lp.landingactions("blackgold@gmail.com","Madhavan@28");
		OrderPage op=pc.gotoOrderPage();
		Assert.assertTrue(op.verifyorders(productname));
		
		
		
	}
	

	
	
	
	@DataProvider
	public Object[][] getdataprovider() throws IOException {
		
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\MPTech\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		

		
		
	
		
		
		
		
	}
	
	
	
}
