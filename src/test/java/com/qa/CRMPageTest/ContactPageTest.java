package com.qa.CRMPageTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.CRM.Base.CRMTestBase;
import com.qa.CRM.Pages.ContactPage;
import com.qa.CRM.Pages.HomePage;
import com.qa.CRM.Pages.LoginPage;

import junit.framework.Assert;

public class ContactPageTest extends CRMTestBase {
	public LoginPage loginpage;
	public ContactPage contactpage;
	public HomePage homepage;
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup () {
		init();
		loginpage=new LoginPage();
		homepage=loginpage.VerifyLogin(prop.getProperty("username"), prop.getProperty("password"));			contactpage=homepage.VerifyContactsLink();
	}
	
	@Test (priority =1)
	public void ContactPageTitleTest() {
		String ContactPageTitle=contactpage.VerifyContactPageTitle();
		Assert.assertEquals(ContactPageTitle, "CRMPRO");
	}
	@Test (priority =2 )
	public void CheckBoxTest() {
		contactpage.VerifyCheckBox();
	}
	
	@Test (priority=3)
	public void CreateNewContatTest() {
		contactpage.MouseOverContactLink();
		contactpage.VerifyCreateNewContact("Angham", "mohamed", "Miss");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
