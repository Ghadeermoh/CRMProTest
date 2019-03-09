package com.qa.CRMPageTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.CRM.Base.CRMTestBase;
import com.qa.CRM.Pages.CalendarPage;
import com.qa.CRM.Pages.ContactPage;
import com.qa.CRM.Pages.HomePage;
import com.qa.CRM.Pages.LoginPage;

import junit.framework.Assert;

public class HomePageTest  extends CRMTestBase{
	public LoginPage loginpage;
	public HomePage homepage;
	public CalendarPage calendarpage;
	public ContactPage contactpage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		init();
		loginpage=new LoginPage();
		homepage=loginpage.VerifyLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test (priority =1)
	public void CalendarlinkTest() {
		calendarpage=homepage.VerifyCalendarLink();
	}
	@Test (priority =2)
	public void HomePageTitleTest() {
		String HomePageTitle = homepage.VerifyHomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO");
	}
	@Test (priority =3)
	public void UserNameDisplayedTest() {
		boolean x = homepage.VerifyUserNameDisplayed();
		Assert.assertTrue(x);
	}
	@Test (priority= 4)
	public void  ContactsLinkTest() {
	contactpage	=homepage.VerifyContactsLink();
	}
	
	
	
	@AfterMethod 
	public void teardown() {
		driver.quit();
	}

}
