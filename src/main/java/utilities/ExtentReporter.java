package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports extentReport;
	
	public static ExtentReports getExtentReports()
	{

	
	String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
	reporter.config().setReportName("tutorialsninja automation results");
	reporter.config().setDocumentTitle("test results");
	
	extentReport = new ExtentReports();
	extentReport.attachReporter(reporter);
	extentReport.setSystemInfo("Operating system","Windows 10");
	extentReport.setSystemInfo("Tested by","Shajeb");
	
	return extentReport;
	
	
	
	}

}
