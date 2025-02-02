package MPTech.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MPTech.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	
	
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath="//div[contains(@class,'mb-3')]")
	List<WebElement> products;
	
	
	By productBy=By.xpath("//div[contains(@class,'mb-3')]");
	
		public List<WebElement> getproductlist() {
		waitForElementToAppear(productBy);
		return products;
	}

	
		
	public WebElement getproductbyName(String productname) {
		
		
		WebElement prod=getproductlist().stream().filter(prdt->prdt.findElement(By.xpath("//div[contains(@class,'card-body')]/h5")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
	
		return prod;
	}	
		
	By addtocart=By.xpath("//div[@class='card-body']/button[2]");
	By toastmessage=By.cssSelector(("#toast-container"));
	By inivisibleofmessage=By.cssSelector(".ng-animating");
	
	public void addproduct(String productname) {
	
		WebElement prod=
		getproductbyName(productname);
		prod.findElement(addtocart).click();
		//waitForElementToAppear(toastmessage);
		invisibilityofelement(inivisibleofmessage);
		
		
	}
		
		
		
	}

	

