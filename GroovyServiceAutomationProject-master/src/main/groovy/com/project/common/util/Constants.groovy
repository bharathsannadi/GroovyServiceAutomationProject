package com.project.common.util;

class Constants {

	static final MACOS_DOWNLOAD_DIR = "/tmp/ACT/ACT_OUTPUT/"
	static final OS_DOWNLOAD_DIR = "E:\\ACT\\ACT_OUTPUT\\"
	static final WINDOWS_CHROME_DOWNLOAD_DIR = System.getenv()['HOMEPATH'] + "\\Downloads\\"
	static final BROWSER_DOWNLOAD_DIR = (System.properties['os.name'] == 'Mac OS X') ? MACOS_DOWNLOAD_DIR : OS_DOWNLOAD_DIR
	static final FILE_DOWNLOAD_DIR =  BROWSER_DOWNLOAD_DIR
	static final TEST_EXPECTED_RESULTS_VSD_BASE_LOC = "src\\test\\resources\\vsd\\"
	static final MACOS_TEST_EXPECTED_RESULTS_VSD_BASE_LOC = "src/test/resources/vsd/"
	static final EXPECTED_VISIO_RESULTS_PATH = (System.properties['os.name'] == 'Mac OS X') ? MACOS_TEST_EXPECTED_RESULTS_VSD_BASE_LOC : TEST_EXPECTED_RESULTS_VSD_BASE_LOC
	
	/*********************SalesForceData************************/
	static final salesForceUserPw = 	"welcome4"
	static final salesForceSoapUrl =  	"https://test.salesforce.com/services/Soap/c/26.0/0DFZ00000008OVT"
	
	// Database constants
	static final DB_CONNECTION_STRING = "dBConnectionString"
	static final DB_USER_ID = "dBUserId"
	static final DB_PSWD = "dBPw"
	// Login constants
	static final USERNAME = "userName"
	static final PASSWORD = "passWord"
	//automation constants
	static final Long DEFAULTTIMEOUT = 100000
	static final waitForService = 1000
	static final waitForUI = 3000
	static final sync = 50
	//workspace constants
	static final PAGE_AMOUNT = 15
	
	
}
