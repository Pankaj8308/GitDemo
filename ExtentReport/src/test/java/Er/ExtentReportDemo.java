package Er;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReportDemo {
	ExtentReports report;
	@BeforeTest
	public void config()
	{
		// classes ExtentSparkReporter and ExtentReports  will be used to help with report generation
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		// configuaration of report name
		reporter.config().setReportName("WebAutomationReport");
		reporter.config().setDocumentTitle("TestResult");
		
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Pankaj");
	}
	@Test
	public void StandAloneEr()
	{
		ExtentTest test = report.createTest("Demo_testName");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println("Title is "+driver.getTitle());
		driver.close();
		// Failing test case for seeing extent report outputs
		// test.fail("Result not matched");
		report.flush();
		
	}
}
