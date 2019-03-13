package com.qa.CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.CRM.Base.CRMTestBase;

public class ContactPage extends CRMTestBase {
	
	@FindBy(xpath="//a [contains(text(),'Contacts')]")
	WebElement Contactlink;
	@FindBy (xpath ="//a[text()='Amira mohamed']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@type=\"checkbox\"]")
	WebElement ContactCheckBox;
	@FindBy(xpath= "//i[@title='Delete']")
	WebElement DeleteContact;
	@FindBy (xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContact;
	@FindBy (name="title")
	WebElement TitleField;
	@FindBy (name="first_name")
	WebElement FirstNameField;
	@FindBy(name="surname")
	WebElement LastNameField;
	@FindBy (xpath="//input[@value='Save']")
	WebElement SaveBtn;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyContactPageTitle() {
		return driver.getTitle();
	}
	
	public void VerifyCheckBox() {
		
		ContactCheckBox.click();
	}
	
	public void MouseOverContactLink()
	{
		Actions act =new Actions(driver);
		act.moveToElement(Contactlink).build().perform();
		NewContact.click();	
	}
	public void VerifyCreateNewContact(String FirstN ,String LastN,String Title) {
		FirstNameField.sendKeys(FirstN);
		LastNameField.sendKeys(LastN);
		Select sel =new Select(TitleField);
		sel.selectByVisibleText(Title);
		SaveBtn.click();
		
		
	}
	

}
