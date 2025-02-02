package MPTech.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseCodeOriginal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String purchase="IPHONE 13 PRO";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("blackgold@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Madhavan@28");
		driver.findElement(By.cssSelector("#login")).click();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'mb-3')]")));
		List<WebElement> products=driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
	    WebElement prod=products.stream().filter(prdt->prdt.findElement(By.xpath("//div[contains(@class,'card-body')]/h5")).getText().equalsIgnoreCase(purchase)).findFirst().orElse(null);	
		prod.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		//w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(("#toast-container")))));
		//Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		List<WebElement> cartproducts=driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
		Boolean check=cartproducts.stream().anyMatch(prdts->prdts.getText().equalsIgnoreCase(purchase));
		Assert.assertTrue(true);
		driver.findElement(By.cssSelector(".subtotal ul li:nth-child(3) button")).click();
		driver.findElement(By.xpath("//form[contains(@class,'ng-pristine')]/div/div[2]/div[2]/input")).sendKeys("447");
		driver.findElement(By.xpath("//form[contains(@class,'ng-pristine')]/div/div[3]/div/input")).sendKeys("Madhavan Parthasarathi");
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".list-group-item")));
		List<WebElement> country=driver.findElements(By.cssSelector(".list-group-item"));
		for(WebElement nation:country) {
			
			if(nation.getText().equalsIgnoreCase("India")) {
				
				nation.click();
			}
		}
		driver.findElement(By.cssSelector(".actions a")).click();
		System.out.println(driver.findElement(By.cssSelector("tr[class*='star-inserted'] td label")).getText());
		String confirmation=driver.findElement(By.cssSelector(".hero-primary")).getText().toUpperCase().trim();
		Assert.assertEquals(confirmation, "THANKYOU FOR THE ORDER.");
		driver.quit();
		
	}

}
