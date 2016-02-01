package com.fitbase.pageobjects

import geb.Page;

class HomePage extends Page{

	//Verify title before login
	static at = { title == "404 - Error page" }


	//Elements for the Login Screen
	static content = {
		fitbaseicon   {$("a[class='navbar-brand logo pzero']")}
	}


	/**
	 * Helps a user to Login to the fit base application 
	 * @param userName
	 * @param password
	 * @return
	 */
	public gotoHomePage(){

		//Wait for the object to be present
		waitFor { fitbaseicon.present }

		fitbaseicon.click()
	}


}
