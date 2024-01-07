package com.HybridAutomationApplication.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HybridAutomationApplication.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() {
		
		driver.get(BaseURL);
		logger.info("URL is opened");
		LoginPage LP = new LoginPage(driver);
		LP.setUserName(Username);
		logger.info("Username is Entered");
		LP.setPassword(password);
		logger.info("Password is Entered");
		LP.clicksubmit();
		
		if(driver.getTitle().equals(" Guru99 Bank Home Page ")) {
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertFalse(false);
		}
	}
}
