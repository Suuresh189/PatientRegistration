package com.HealthCare.Patient.Registration.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.AssertJUnit;
import org.openqa.selenium.support.ui.Select;

public class KeywordAction {
	Properties prop;
	WebDriver driver = null;
	private static volatile KeywordAction instance = null;
	
	private KeywordAction(){
		try{
			prop = new Properties();
			FileInputStream fIN = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\config\\OR.properties");
			prop.load(fIN);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static KeywordAction getInstance() {
		if (instance == null) {
			synchronized (KeywordAction.class) {
				if (instance == null) {
					instance = new KeywordAction();
				}
			}
		}
		return instance;
	}
	
	public void executekeywordsSheetWise(String testname, ExcelReader xls) throws FileNotFoundException{
		  try {  
			  String SheetName=testname;
				int rows = xls.getRowCount(SheetName);		
				for(int i=2;i<=rows;i++)
				{
					String tcid = xls.getCellData(SheetName, "TestCaseID", i);
					if(tcid.equals(testname))
					{
						String keyword = xls.getCellData(SheetName, "Keyword", i);
						String object = xls.getCellData(SheetName, "Object", i);
						String data = xls.getCellData(SheetName, "Data", i);
						String type = xls.getCellData(SheetName, "ElementType", i);
						
						//Keywords
						String result = null;
						if(keyword.equals("OpenBrowser"))
							result = OpenBrowser(data);
						
						else if(keyword.equals("BrowserClose"))
							result = BrowserClose();
						
						else if(keyword.equals("Navigate"))
							result = Navigate(data);
						
						else if(keyword.equals("Wait"))
							result = Wait();
						
						else if(keyword.equals("Click"))
							result = Click(object,type);
						
						else if(keyword.equals("ClickGetAlert"))
							result = ClickGetAlert(object,type);
						
						else if(keyword.equals("Input"))
							result = Input(object,data,type);
						
						else if(keyword.equalsIgnoreCase("Select"))
							result = Select(object, data);
						
						else if(keyword.equalsIgnoreCase("SelectByIndex"))
							result = SelectByIndex(object,data);
						
						else if(keyword.equals("SelectCalenderDate"))
							result = SelectCalenderDate(object,data,type);
						
						else if(keyword.equals("ReCertDates"))
							result = ReCertDates(object,data,type);
						
						else if(keyword.equals("Wait"))
							result = Wait();

						if(!result.equals("Pass"))
							AssertJUnit.fail(result);
						
						System.out.println(tcid+"-----"+keyword+"-----"+object+"-----"+data+"------"+result);	
			  
					}
				}
			  }catch(Exception e){
				  e.printStackTrace();
			  }
		  }
	
	//Type of browser
			public String OpenBrowser(String BrowserType){
				if(BrowserType.equals("Mozilla")){
					driver = new FirefoxDriver();
				}else if(BrowserType.equals("Chrome")){
					driver = new ChromeDriver();
				}else if(BrowserType.equals("IE")){
					driver = new InternetExplorerDriver();		
				}
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				return "Pass";
			}
			
			public String BrowserClose(){
				
				driver.close();
			
				return "Pass";
			}
			
			//Navigate to given URl
			public String Navigate(String URLKey){
				driver.get(prop.getProperty(URLKey));
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
				return "Pass";
			}
			

			public String Wait(){
			try{
				Thread.sleep(5000);
				}catch(InterruptedException e){
				e.printStackTrace();
				}
				return "Pass";
			}
		
			
			//Entering the input test data in the Text boxes
			public String Input(String xpathkey, String data, String type){
			try
			{
				if(type.equalsIgnoreCase("XPath")){
					driver.findElement(By.xpath(prop.getProperty(xpathkey))).clear();
					driver.findElement(By.xpath(prop.getProperty(xpathkey))).sendKeys(data);
				}else if(type.equalsIgnoreCase("Id")){
					driver.findElement(By.id(prop.getProperty(xpathkey))).clear();
					driver.findElement(By.id(prop.getProperty(xpathkey))).sendKeys(data);			
				}else if(type.equalsIgnoreCase("Name")){
					driver.findElement(By.name(prop.getProperty(xpathkey))).clear();
					driver.findElement(By.name(prop.getProperty(xpathkey))).sendKeys(data);		
				}
			}catch(Exception e){
				return "Fail - not able to write in input field"+xpathkey;
			}			
			return "Pass";
			}
			
			//Click (Buttons / Check boxes / Links / Images)
			public String Click(String xpathkey, String type){
			try{	
				
				if(type.equalsIgnoreCase("XPath")){
					driver.findElement(By.xpath(prop.getProperty(xpathkey))).click();
				}else if(type.equalsIgnoreCase("Id")) {
					driver.findElement(By.id(prop.getProperty(xpathkey))).click();
				} else if (type.equalsIgnoreCase("Name")) {
					driver.findElement(By.name(prop.getProperty(xpathkey))).click();
				}else if (type.equalsIgnoreCase("CSS")) {
					driver.findElement(By.cssSelector(prop.getProperty(xpathkey))).click();
				}
				
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
			}catch(Exception e){
			
				return "Fail - Not able to click on Object " +xpathkey;
			}
			
			return "Pass";	
			}
			
			
			// while get the alert pop up message (Modal dialog present: Are you sure you want to save?)
						public String ClickGetAlert(String xpathkey, String type){
						try{						
								
							if(type.equalsIgnoreCase("XPath")){
								driver.findElement(By.xpath(prop.getProperty(xpathkey))).click();
							}else if(type.equalsIgnoreCase("Id")) {
								driver.findElement(By.id(prop.getProperty(xpathkey))).click();
							} else if (type.equalsIgnoreCase("Name")) {
								driver.findElement(By.name(prop.getProperty(xpathkey))).click();
							}
							
							handleAlert();
							
							driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
							}catch(Exception e)
							{
								e.printStackTrace();
								return "Fail - Not able to click on Object " +xpathkey;
							}
							return "Pass";	
						}
							

					// Function for handling Alert and Confirm Boxes
					public boolean handleAlert() {
							boolean a = false;
					try {
						        Alert alert = driver.switchTo().alert();
							        String AlertText = alert.getText();
							        System.out.println(AlertText);
							        alert.accept();
							        a = true;
							    } catch (Exception e) {
							    	a= false;
							    }finally {
							    	a = true;
							    }
							    return a;
							}
			
			//Select the value from Drop_Down list
			public String Select(String xpathkey, String data){	
				
				try{				
					WebElement from1 = null;				
					if (driver.findElement(By.xpath(prop.getProperty(xpathkey))) != null) {
						System.out.println("By XPATH");
						from1 = driver.findElement(By.xpath(prop.getProperty(xpathkey)));
					} else if (driver.findElement(By.id(prop.getProperty(xpathkey))) != null) {
						System.out.println("By ID");
						from1 = driver.findElement(By.id(prop.getProperty(xpathkey)));
					} else if (driver.findElement(By.name(prop.getProperty(xpathkey))) != null) {
						System.out.println("By NAME");
						from1 = driver.findElement(By.name(prop.getProperty(xpathkey)));
					}else if (driver.findElement(By.cssSelector(prop.getProperty(xpathkey))) != null) {
						System.out.println("By cssSelector");
						from1 = driver.findElement(By.name(prop.getProperty(xpathkey)));
					}
					
					List<WebElement> options = from1.findElements(By.tagName("option"));
					for (WebElement option : options) {
						if (data.equalsIgnoreCase(option.getText())) {
							option.click();
						}
					}
			
					}catch(Exception e){
						e.printStackTrace();
						return "Fail - Not able to select the Object" +xpathkey;
					}
				return "Pass";
				}
			
			public String SelectByIndex(String xpathkey, String data){	
				try{
					
					Select selectBox = new Select(driver.findElement(By.xpath(prop.getProperty(xpathkey)))); 
						
						float f = Float.parseFloat(data);
						
						int index = Math.round(f);
						
						selectBox.selectByIndex(index);
						
						}catch(Exception e)
						{
							e.printStackTrace();
							
						}
					return "Pass";
					
					}
			
			public String SelectCalenderDate(String xpathkey, String data, String type){
				try
				{
					float f = Float.parseFloat(data);		
					int i = Math.round(f);
					xpathkey = "//a[contains(text(),'"+i+"')]";
					if(type.equalsIgnoreCase("XPath")){
						driver.findElement(By.xpath(xpathkey)).click();
					}else if(type.equalsIgnoreCase("Id")){
						driver.findElement(By.xpath(xpathkey)).click();	
					}else if(type.equalsIgnoreCase("Name")){
						driver.findElement(By.xpath(xpathkey)).click();	
					}
				}catch(Exception e){
					e.printStackTrace();					
					return "Fail - not able to write in input field"+xpathkey;
				}
				return "Pass";
				}
			
			public String ReCertDates(String xpathkey, String data, String type){
				try
				{
					System.out.println("data........"+data);
					int i = data.length();
					System.out.println("i........"+i);
					//  12/28/2014
					
					//String month = data.substring(1,3);
					String month = data.substring(1, data.indexOf("/"));
					System.out.println("month........"+month);
					
					String date = data.substring(data.indexOf("/")+1, data.lastIndexOf("/"));
					System.out.println("date........"+date);
					
					String year = data.substring(data.lastIndexOf("/")+1, data.length()-1);
					System.out.println("year........"+year);
					
					int m = Integer.parseInt(month);
					int y = Integer.parseInt(year);
					
					String Calender_Month_dropdown = ".//*[@id='ux-datepicker-div']/div[3]/div/select[1]";
					String Calender_Year_dropdown = ".//*[@id='ux-datepicker-div']/div[3]/div/select[2]";
										
					//for month drop down
					WebElement Calender_Month = null;				
					Calender_Month = driver.findElement(By.xpath(Calender_Month_dropdown));
					System.out.println("Calender_Month......"+Calender_Month);
					List<String> list = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
					
					for(int a=0;a<12;a++){
						if(a==(m-1)){
						String monthtext = list.get(a);
						List<WebElement> options = Calender_Month.findElements(By.tagName("option"));
						for (WebElement option : options) {
							if (monthtext.equalsIgnoreCase(option.getText())) {
								System.out.println("monthtext.equalsIgnoreCase(option.getText())...."+monthtext.equalsIgnoreCase(option.getText()));
								option.click();
								break;
							}
						}
						}
						
					}
					
					//for year drop down
					WebElement Calender_Year = null;				
					Calender_Year = driver.findElement(By.xpath(Calender_Year_dropdown));
					System.out.println("Calender_Year......"+Calender_Year);
					//List<String> list1 = Arrays.asList("2010", "2011","2012","2013","2014","2015","2016","2017","2018","2019","2020");
					
					
						List<WebElement> options = Calender_Year.findElements(By.tagName("option"));
						for (WebElement option : options) {
							if (year.equalsIgnoreCase(option.getText())) {
								System.out.println("year.equalsIgnoreCase(option.getText())...."+year.equalsIgnoreCase(option.getText()));
								option.click();
								break;
							}
						
					}
						
						xpathkey = "//a[contains(text(),'"+date+"')]";
						if(type.equalsIgnoreCase("XPath")){
							driver.findElement(By.xpath(xpathkey)).click();
						}else if(type.equalsIgnoreCase("Id")){
							driver.findElement(By.xpath(xpathkey)).click();	
						}else if(type.equalsIgnoreCase("Name")){
							driver.findElement(By.xpath(xpathkey)).click();	
						}
					
					
				}catch(Exception e){
					e.printStackTrace();					
					return "Fail - not able to write in input field"+xpathkey;
				}
				return "Pass";
				}
			
			
			
			
			
}
