package com.facebook.pages;

import com.facebook.genericPage.MasterPage;

public class LoginPage extends MasterPage {

	public LoginPage() throws Exception {
		super();
	}

	public void clickEmailOrPhone() {
		click("EmailorPhone");
	}

	public void enterUsername() {
		enterData("EmailorPhone", "testData1");
	}

	public void clickPassword() {
		click("Password");
	} 

	public void enterPassword() {
		enterData("Password", "testData2");
	}

	public void clickLoginButton() {
		click("LoginButton");
	}

}
