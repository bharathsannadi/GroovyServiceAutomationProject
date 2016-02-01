
serviceData {

	soapHolidayService {
		serviceClient = "http://www.holidaywebservice.com/Holidays/US/Dates/USHolidayDates.asmx"
		serviceAction = "http://www.27seconds.com/Holidays/US/Dates/GetAbrahamLincolnsBirthday"
		soapXML = """<?xml version="1.0" encoding="utf-8"?>
						<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
						  <soap:Body>
						    <GetAbrahamLincolnsBirthday xmlns="http://www.27seconds.com/Holidays/US/Dates/">
						      <year>2015</year>
						    </GetAbrahamLincolnsBirthday>
						  </soap:Body>
						</soap:Envelope>"""
	}

	restThomasService {
		defaultURI = "http://www.thomas-bayer.com/sqlrest/"
		serviceURL = "CUSTOMER/35/"
	}

	restHolidayService {
		defaultHURI = "http://www.holidaywebservice.com/Holidays/US/Dates/USHolidayDates.asmx/"
		serviceHURL = "GetAbrahamLincolnsBirthday?year=2015"
	}
}