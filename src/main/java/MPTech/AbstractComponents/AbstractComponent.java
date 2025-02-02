package MPTech.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MPTech.PageObjects.CartPage;
import MPTech.PageObjects.OrderPage;

public class AbstractComponent  {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css="button[routerlink*='myorders']")
	WebElement orderspage;
	
	
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cart;
	
	
	public CartPage gotoCartPage() throws InterruptedException {
		Thread.sleep(2000);
		cart.click();
		CartPage cp=new CartPage(driver);
		return cp;
	}
	
	public OrderPage gotoOrderPage() {
		
		orderspage.click();
		OrderPage op=new OrderPage(driver);
		return op;
		
	}
	
	
	
	public void waitForElementToAppear(By FindBy) {
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
	w.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	
	}

	
	public void waitForWebElementToAppear(WebElement FindBy) {
	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
	w.until(ExpectedConditions.visibilityOf(FindBy));
	
	}
	
	
	public void invisibilityofelement(By FindBy) {
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));
	}
	

	
	public void visibilityofAllElementsLocated(By FindBy) {
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FindBy));
	}
	
}
