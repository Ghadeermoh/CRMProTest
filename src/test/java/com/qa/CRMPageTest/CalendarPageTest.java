package com.qa.CRMPageTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.CRM.Base.CRMTestBase;
import com.qa.CRM.Pages.CalendarPage;
import com.qa.CRM.Pages.HomePage;
import com.qa.CRM.Pages.LoginPage;



public class CalendarPageTest extends CRMTestBase{
	public LoginPage loginpage;
	public HomePage homepage;
	public CalendarPage calendarpage;
	public CalendarPageTest() {
		super();
	}
	
	@BeforeMethod 
	public void setup () {
		init();
		loginpage=new LoginPage();
		homepage=loginpage.VerifyLogin(prop.getProperty("username"), prop.getProperty("password"));			
		calendarpage=homepage.VerifyCalendarLink();
		
	}
	@Test 
	public void CalendarTest() {
		calendarpage.ValidateCalendar();
		
	}
	@AfterMethod 
	public void Teardown() {
		driver.quit();
	}

}
