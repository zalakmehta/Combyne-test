package com.farmlead.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
	private static ExtentSparkReporter reporter;
	public static ExtentReports getReportObject() {

		 
		
		String path = System.getProperty("user.dir") + "/reports/index_"+TestUtil.getDate()+".html";
		//String path = "/Users/zmehta/eclipse-workspace/farmleadautomation/reports/index_"+TestUtil.getDate()+".html";
		System.out.println("Extent Report"+path);
		//String path = "./reports/index_"+TestUtil.getDate()+".html";
		
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Zalak");
		return extent;

	}

}
