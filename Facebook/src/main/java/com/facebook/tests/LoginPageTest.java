package com.facebook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.facebook.genericPage.MasterPage;
import com.facebook.pages.LoginPage;

public class LoginPageTest {

	@Test
	public void loginTest() throws Exception {

		LoginPage lp = new LoginPage();
		lp.clickEmailOrPhone();
		lp.enterUsername();
		lp.clickPassword();
		lp.enterPassword();
		lp.clickLoginButton();
	}

	@AfterMethod
	public static void tearDown() {
		MasterPage.driver.close();
	}

}
