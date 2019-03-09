package com.qa.CRM.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.CRM.Util.Util;


public class CRMTestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public CRMTestBase(){
		prop=new Properties() ;
			FileInputStream IN;
			try {
				IN = new FileInputStream("C:\\Users\\ghadeermoh\\eclipse-workspace\\CRMTest\\src\\main\\java\\com\\qa\\CRM\\Config\\ConfigData");
				prop.load(IN);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
	}
		
	
	public void init() {
		String browsername=prop.getProperty("browser");
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\program file\\selenium programs\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\program file\\selenium programs/geckodriver.exe");  //give location of the driver we already downloaded 
			driver =new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Util.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.Implicit_Wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	

}
