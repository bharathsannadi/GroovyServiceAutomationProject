package com.projectcommon.util


import javax.xml.soap.*

import java.nio.charset.Charset

class XMLParserUtil {
	

	@SuppressWarnings("restriction")
	public SOAPBody transformSOAPResponse(xmlResponse) {
		
		//new XMLParserUtil()

		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage(
				new MimeHeaders(),
				new ByteArrayInputStream(xmlResponse.getText().getBytes(Charset
				.forName("UTF-8"))));

		SOAPBody body = message.getSOAPBody();
		return body;

	}
}
	
	