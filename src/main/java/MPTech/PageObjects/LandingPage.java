package MPTech.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MPTech.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="#userEmail")
	WebElement username;
	

	@FindBy(id="userPassword")
	WebElement pwd;
	
	
	@FindBy(css="#login")
	WebElement loginbtn;
	
	
	@FindBy(css=".ng-trigger-flyInOut")
	WebElement errormsg;
	
	
	public ProductCatalogue landingactions(String email,String password) {
		
		username.sendKeys(email);
		pwd.sendKeys(password);
		loginbtn.click();
		ProductCatalogue pc=new ProductCatalogue(driver);
		return pc;
		
	}
	
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}

	
	public String geterrormessage() {
		waitForWebElementToAppear(errormsg);
		String msg=errormsg.getText();
		return msg;
	}
}
