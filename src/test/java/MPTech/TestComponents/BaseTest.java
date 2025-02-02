package MPTech.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import MPTech.PageObjects.LandingPage;

public class BaseTest {

	public static WebDriver driver;
	public LandingPage lp;
	public static WebDriver InitializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\MPTech\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browsername=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("Browser");

		
		if(browsername.contains("Chrome")) {
		
			if(browsername.contains("Headless")) {
			ChromeOptions co=new ChromeOptions();
			co.addArguments("Headless");
			driver=new ChromeDriver(co);
			driver.manage().window().setSize(new Dimension(1440,900));//run in full screen
			}
			
			driver=new ChromeDriver();
		}
		
		
		
		else if(browsername.equals("FireFox")) {
			
			driver=new FirefoxDriver();
			
			
		}
		
		
	else if(browsername.equals("Edge")) {
			
			driver=new EdgeDriver();
		
			
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
		}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchapplication() throws IOException {
		
		driver=InitializeDriver();
		lp= new LandingPage(driver);
		lp.goTo();
		return lp;
		
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		driver.close();
	}
	
public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
		
		//reading json to string
	String jsonContent=FileUtils.readFileToString(new File(filepath),
			StandardCharsets.UTF_8);
		
		//String to HashMap via Jacksondata bind 
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {	});

		return data;

	}
	
	
public String getScreenshot(String TestCaseName,WebDriver driver) throws IOException {
	
	TakesScreenshot ts=((TakesScreenshot)driver);
	File src=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\Partha\\eclipse-workspace\\SeleniumFrameworkDesign\\Screenshots"+" "+TestCaseName+".png"));
	return "C:\\Users\\Partha\\eclipse-workspace\\SeleniumFrameworkDesign\\Screenshots"+" "+TestCaseName+".png";
}

	
}
