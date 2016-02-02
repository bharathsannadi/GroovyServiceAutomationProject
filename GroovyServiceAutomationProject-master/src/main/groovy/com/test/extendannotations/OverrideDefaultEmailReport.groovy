package com.test.extendannotations

import java.io.IOException;
import java.util.List;

import org.testng.ISuite;
import org.testng.reporters.EmailableReporter
import org.testng.reporters.EmailableReporter2
import org.testng.reporters.SuiteHTMLReporter
import org.testng.xml.XmlSuite;



class OverrideDefaultEmailReport extends EmailableReporter{
	@Override
	public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outdir) {
		println "No Implementation"
	}
}


