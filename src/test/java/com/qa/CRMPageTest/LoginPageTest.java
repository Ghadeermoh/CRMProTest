package com.qa.CRMPageTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.CRM.Base.CRMTestBase;
import com.qa.CRM.Pages.HomePage;
import com.qa.CRM.Pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest  extends CRMTestBase{
	public LoginPage loginpage;
	public HomePage homepage;
	
	
	public LoginPageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		init();
		loginpage=new LoginPage();
		
		
	}
	
	@Test (priority =1)
	public void LoginPageTitleTest() {
		String LoginPageTitle=loginpage.VerifyLoginPageTitle();
		System.out.println(LoginPageTitle);
		Assert.assertEquals(LoginPageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test (priority =2)
	public void LoginPageLogoTest() {
		boolean x=loginpage.VerifyLoginPageLogo();
		Assert.assertTrue(x);
	}
	@Test (priority =3)
	public void LoginTest()  {
	homepage=loginpage.VerifyLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}

}
