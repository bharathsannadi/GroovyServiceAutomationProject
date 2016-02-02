package com.test.extendannotations

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {

	private String outputDirectory = System.getProperty("user.dir");
	private ExtentReports extent;


	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		outputDirectory = createExtentLogFile().absolutePath
		extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportTestNG.html", true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult suiteResult : result.values()) {
				ITestContext context = suiteResult.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		extent.flush();
		extent.close();
		
		//delete the TestNG directory
		removeWholeTestNGDirectory();
	}

	/**
	 * 
	 * @param tests
	 * @param status
	 */
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(new Date());
				test.setEndedTime(new Date());

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				String message = "Test " + status.toString().toLowerCase() + "ed";

				if (result.getThrowable() != null)
					message = result.getThrowable().getMessage();

				test.log(status, message);

				extent.endTest(test);
			}
		}
	}

	public File createExtentLogFile(){
		File file = new File(this.outputDirectory + "\\ExtentReports");
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
		return file;
	}

	public void removeWholeTestNGDirectory(){
		final File[] files = new File(outputDirectory + "\\test-output").listFiles()
		try{
			for(File f : files){
				f.getName()
				f.delete()
			}
		}catch(Exception e){
			println "Some of the files are used and cannot be deleted"
		}
	}
}

