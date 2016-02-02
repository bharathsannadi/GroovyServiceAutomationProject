package com.test.extendannotations

import java.util.List;

import org.testng.ISuite;
import org.testng.reporters.EmailableReporter2;
import org.testng.xml.XmlSuite;

class OverrideDefaultEmailReport2 extends EmailableReporter2 {
	@Override
	public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outdir) {
		println "No Implementation"
	}
}