package com.qa.CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.CRM.Base.CRMTestBase;

public class LoginPage extends CRMTestBase {
	
	@FindBy (name="username")
	WebElement UserName;
	@FindBy (name="password")
	WebElement Password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginBtn;
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement LoginPageLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String VerifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean VerifyLoginPageLogo() {
		return LoginPageLogo.isDisplayed();
	}
	
	public HomePage VerifyLogin( String un , String pass)   {
		
		UserName.sendKeys(un);
		Password.sendKeys(pass);
		LoginBtn.click();
		
		return new HomePage();
		
	}
	

	
	

}
