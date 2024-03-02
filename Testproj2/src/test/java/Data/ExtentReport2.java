package Data;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport2 {

	public static ExtentReports getReportObj()
	{
		// classes ExtentSparkReporter and ExtentReports  will be used to help with report generation
				String path=System.getProperty("user.dir")+"\\reports\\index.html";
				// C:\Users\panka\eclipse-workspace\SeleniumFrameWorkDesign\reports
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				// configuaration of report name
				reporter.config().setReportName("WebAutomationReport");
				reporter.config().setDocumentTitle("TestResult");
				
				ExtentReports report = new ExtentReports();
				report.attachReporter(reporter);
				report.setSystemInfo("Tester", "Pankaj");
				return report;
				
	}
}
