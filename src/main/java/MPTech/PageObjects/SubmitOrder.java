package MPTech.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MPTech.AbstractComponents.AbstractComponent;

public class SubmitOrder extends AbstractComponent{
	WebDriver driver;
	
	public SubmitOrder(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}

	@FindBy(css=".hero-primary")
	WebElement confirmationmsg;
	
	
	public String verifyconfirmationmsg() {
		
		String confirmation=confirmationmsg.getText().toUpperCase().trim();
		return confirmation;
	}
	
}
