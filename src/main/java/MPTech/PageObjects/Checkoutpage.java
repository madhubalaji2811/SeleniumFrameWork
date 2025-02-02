package MPTech.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MPTech.AbstractComponents.AbstractComponent;

public class Checkoutpage extends AbstractComponent {

	WebDriver driver;
	public Checkoutpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

		
	@FindBy(xpath="//form[contains(@class,'ng-pristine')]/div/div[2]/div[2]/input")
	WebElement cvv;
	
	
	@FindBy(xpath="//form[contains(@class,'ng-pristine')]/div/div[3]/div/input")
	WebElement CardName;

	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement countryinput;
	
	
	//List<WebElement> country=driver.findElements(By.cssSelector(".list-group-item"));
	@FindBy(css=".list-group-item")
	List<WebElement> country;
	
	By countrywait=By.cssSelector(".list-group-item");
	
	
	
	@FindBy(css=".actions a")
	WebElement checkoutbtn;
	
	public void selectcountry(String Region) {
		cvv.sendKeys("447");
		CardName.sendKeys("Madhavan Parthasarathi");
		Actions a=new Actions(driver);
		a.sendKeys(countryinput, "India").build().perform();
		visibilityofAllElementsLocated(countrywait);
		for(WebElement nation:country) {
			
			if(nation.getText().equalsIgnoreCase(Region)) {
				
				nation.click();
			}
		}		
		
	}

	public SubmitOrder submitorder() {
		
		checkoutbtn.click();
		SubmitOrder so=new SubmitOrder(driver);
		return so;
		
		
	}











}
