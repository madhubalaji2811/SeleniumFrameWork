package MPTech.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
	
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter esr=new ExtentSparkReporter(path);
	esr.config().setDocumentTitle("FrameWrokAutomationResults");
	esr.config().setReportName("Test Results");
	
	ExtentReports er=new ExtentReports();
	er.attachReporter(esr);
	er.setSystemInfo("Tester", "Madhavan");
	return er;
	
	
	
	
	
	}
	
}
