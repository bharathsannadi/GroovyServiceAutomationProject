package com.service.servicetests

import groovy.util.logging.Log4j;

import com.common.util.ConfigUtil
import com.common.util.XMLParserUtil
import com.service.util.RabbitMQImplementaion
import com.service.util.RestServiceImplementation
import com.service.util.SoapServiceUtility;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.soap.*
import org.w3c.dom.NodeList;
import org.assertj.core.api.SoftAssertions
import org.testng.annotations.Test;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.Reporter;
import wslite.soap.SOAPResponse
import groovy.util.ConfigObject;
import com.common.util.CommonUtil
import java.nio.charset.Charset


@Log4j
class ServiceTests {

	ConfigObject configuration
	Reporter logToTestNG
	SoftAssertions softAssert


	@BeforeGroups(groups = ["SOAPService", "RESTService", "QueueTests"],alwaysRun = true)
	public void setup(){
		configuration = new ConfigUtil("EnvConfig").getConfigObject()
		logToTestNG = new Reporter()
		softAssert = new SoftAssertions()
	}


	@Test(groups = ["QueueTests"], description = "Working with rabbit MQ")
	public void workwithQueue(){

		new RabbitMQImplementaion().publishMessageToQueue()
		new RabbitMQImplementaion().readMessageFromQueue()
	}

	@Test(groups = ["SOAPService"], description = "Soap Service Call for Testing")
	public void callSoapService(){

		//Get data from Configuration File
		String serviceClient = configuration.serviceData.soapHolidayService.serviceClient
		String serviceAction = configuration.serviceData.soapHolidayService.serviceAction
		String soapXML = configuration.serviceData.soapHolidayService.soapXML

		//Call the service
		SOAPResponse response = new SoapServiceUtility(serviceClient).callSoapService(serviceAction,soapXML)

		//transform SOAP response
		SOAPBody body = new XMLParserUtil().transformSOAPResponse(response)

		//Fetch the value from XML Element
		Node responseText = body.firstChild.firstChild.firstChild
		String Result = responseText.getNodeName()

		//Compare the response values
		CommonUtil.compare("Verify SOAP Response",Result,Result,softAssert)
		softAssert.assertAll()
	}

	@Test(groups = ["RESTService"], description = "Rest Service Call for Testing")
	public void callRestService(){
		//Get data from Configuration File
		String defaultURI = configuration.serviceData.restThomasService.defaultURI
		String serviceURL = configuration.serviceData.restThomasService.serviceURL

		//Call the service
		RestServiceImplementation restUtil = new RestServiceImplementation(defaultURI)
		def restResponse = restUtil.getRESTResponse(serviceURL)
		def response = restResponse.responseData

		//Verify the service
		CommonUtil.compare("Verify REST Response",response,response,softAssert)
		softAssert.assertAll()
	}


	@Test(groups = ["RESTService"], description = "Second Rest Service Call for Testing")
	public void callRestHolidayService(){
		//Get data from Configuration File
		String defaultURI = configuration.serviceData.restHolidayService.defaultURI
		String serviceURL = configuration.serviceData.restHolidayService.serviceURL

		//Call the service
		RestServiceImplementation restUtil = new RestServiceImplementation(defaultURI)
		def response = restUtil.getRESTResponse(serviceURL)
		logToTestNG.log(response.responseData)

		//Verify the service
	}

	@Test(enabled = false, groups = ["RESTService"], description = "Rest Service Call for Testing")
	public void callRestService2(){
		//Get data from Configuration File
		String defaultURI = configuration.serviceData.restThomasService.defaultURI
		String serviceURL = configuration.serviceData.restThomasService.serviceURL

		//Call the service
		RestServiceImplementation restUtil = new RestServiceImplementation(defaultURI)
		def response = restUtil.getRESTResponse(serviceURL)
		logToTestNG.log(response.responseData.toString())

		//Verify the service
	}
}
