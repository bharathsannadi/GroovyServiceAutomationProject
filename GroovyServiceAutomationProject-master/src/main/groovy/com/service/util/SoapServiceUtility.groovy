package com.service.util

import wslite.soap.SOAPClient
import wslite.soap.SOAPResponse

class SoapServiceUtility {

	/**
	 * 
	 */
	private SOAPClient soapServiceClient
	private SOAPResponse response

	/**
	 * Constructor SoapServiceUtility
	 * @param soapServiceClient
	 */
	public SoapServiceUtility(String soapServiceClient){
		try{
			this.soapServiceClient = new SOAPClient(soapServiceClient)
		}catch(Exception e){
			e.printStackTrace()
		}
	}

	/**
	 * SOAPResponse callSoapService(String soapAction, String stringXmlSoapBody)
	 * @param soapAction
	 * @param stringXmlSoapBody
	 * @return SOAPResponse
	 */
	public SOAPResponse callSoapService(String soapAction, String stringXmlSoapBody){
		try{
			response = soapServiceClient.send(SOAPAction:soapAction, stringXmlSoapBody)
			return response
		}catch(Exception e){
			e.printStackTrace()
		}
	}
}
