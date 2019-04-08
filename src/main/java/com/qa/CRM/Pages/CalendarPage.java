package com.qa.CRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.CRM.Base.CRMTestBase;


public class CalendarPage  extends CRMTestBase{
	
	@FindBy (name ="slctMonth")
	WebElement SelectMonth;
	@FindBy (name ="slctYear")
	WebElement SelectYear;
	String Month="January";
	String Year="2019";
	String Day ="22";
	final int weekdays=7;
	
	
	String Beforexpath ="//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table/tbody/tr[";
	String Afterxpath ="]/td[";

	
	
	public CalendarPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateCalendar() {
		Select selectmonth=new Select(SelectMonth);
		selectmonth.selectByVisibleText(Month);
		Select selectyear =new Select (SelectYear);
		selectyear.selectByVisibleText(Year);
		
		for (int rownum =2 ;rownum<=7;rownum++ )  
		  {
			  for ( int colnum=1;colnum<=weekdays;colnum++)
			  {
				  String dayval= driver.findElement(By.xpath(Beforexpath+rownum+Afterxpath+colnum+"]")).getText();
				  if (dayval.equals(Day))
				  {
					  driver.findElement(By.xpath(Beforexpath+rownum+Afterxpath+colnum+"]")).click();        
				  }
			  }     
		  }
		
		
	}

}
