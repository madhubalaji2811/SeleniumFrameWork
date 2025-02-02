package MPTech.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MPTech.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//List<WebElement> cartproducts=driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
	@FindBy(css="div[class='cartSection'] h3")
	List<WebElement> cartproducts;
	
	//driver.findElement(By.cssSelector(".subtotal ul li:nth-child(3) button")).click();
	@FindBy(css=".subtotal ul li:nth-child(3) button")
	WebElement checkout;
	
	
	public Boolean cartpagecheck(String productname) {
		
		Boolean check=cartproducts.stream().anyMatch(prdts->prdts.getText().equalsIgnoreCase(productname));	

		return check;
	}

	
	public Checkoutpage checkout() {
		checkout.click();
		Checkoutpage ckp=new Checkoutpage(driver);
		return  ckp;
		
	}
	
	
}
