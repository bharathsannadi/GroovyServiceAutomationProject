package com.test.extend.extentreporter

import java.util.List;

import org.testng.ISuite;
import org.testng.reporters.SuiteHTMLReporter;
import org.testng.xml.XmlSuite;


class OverrideSuiteHTMLReporter extends SuiteHTMLReporter {
	@Override
	public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outdir) {
		println "No Implementation"
	}
}
