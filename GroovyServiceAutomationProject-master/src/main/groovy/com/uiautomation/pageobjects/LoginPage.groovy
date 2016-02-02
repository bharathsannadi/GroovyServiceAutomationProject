package com.uiautomation.pageobjects

import geb.Module
import geb.Page

class LoginPage extends Page{

	//Verify title before login
	static at = { title == "Fitbase Login" }


	//Elements for the Login Screen
	static content = {
		userEmailAddress   {$("input[id='username']")}
		userPassword       {$("input[id='password']")}
		loginButton        {$("button[id='loginemail']")}
	}


	/**
	 * Helps a user to Login to the fit base application 
	 * @param userName
	 * @param password
	 * @return
	 */
	public loginToTheFitBase(String userName, String password){

		//Wait for the object to be present
		waitFor { userEmailAddress.present }

		//Login to the application
		if (userEmailAddress.present){

			//Login to the application by passing username and the password
			userEmailAddress.value userName
			userPassword.value password
			loginButton.click()
		}
	}


}
