package com.qa.CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.CRM.Base.CRMTestBase;
import com.qa.CRM.Util.Util;

public class HomePage  extends CRMTestBase {
	
	@FindBy (xpath ="//a[contains(text(),'Calendar')]")
	WebElement Calendarlink;
	@FindBy (xpath ="//a[contains(text(),'Companies')]")
	WebElement Companieslink;
	@FindBy (xpath ="//a[contains(text(),'Contacts')]")
	WebElement Contactslink;
	@FindBy (xpath ="//a[contains(text(),'Deals')]")
	WebElement Dealslink;
	
	@FindBy (xpath ="//a[contains(text(),'User: ghadeer mohamed')]")
	WebElement UserLogo;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public CalendarPage VerifyCalendarLink() {
		Util.switchframe();
		Calendarlink.click();
		return new CalendarPage();
	}
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean VerifyUserNameDisplayed() {
		return UserLogo.isDisplayed();
		
	}
	public ContactPage  VerifyContactsLink() {
		Util.switchframe();
		Contactslink.click();
		return new ContactPage();
	}
	  

}
