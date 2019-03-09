package com.qa.CRM.Util;

import com.qa.CRM.Base.CRMTestBase;

public class Util extends CRMTestBase {
	
	public static int Page_Load_TimeOut=20;
	public static int Implicit_Wait=20;
	
	
	public static void switchframe() {
		driver.switchTo().frame("mainpanel");
	}
	

}
