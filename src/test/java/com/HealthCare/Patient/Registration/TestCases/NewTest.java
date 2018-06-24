package com.test.selenium.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
  public void f() {
	  
  }
  @BeforeTest
  public void beforeTest() {
	  WebDriver driver = new FirefoxDriver();
	  driver.get("http://google.com");
  }

 

}
