package com.test.selenium.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.test.selenium.util.ExcelReader;
import com.test.selenium.util.KeywordAction;
import com.test.selenium.util.TestCaseUtil;

public class HospiceTestCases {
	@Test
	public void NewAdmitSelfSurveyWithCAP() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("NewAdmitSelfSurveyWithCAP", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("NewAdmitSelfSurveyWithCAP", xls);		
		}
	
	@Test
	public void NewAdmitSelfSurveyWithOutCAP() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("NewAdmitSelfSurveyWithOutCAP", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("NewAdmitSelfSurveyWithOutCAP", xls);		
		}
	
	@Test
	public void ReCertSelfSurveyWithCAP() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("ReCertSelfSurveyWithCAP", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("ReCertSelfSurveyWithCAP", xls);		
		}
	
	@Test
	public void ReCertSelfSurveyWithOutCAP() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("ReCertSelfSurveyWithOutCAP", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("ReCertSelfSurveyWithOutCAP", xls);		
		}
	
	@Test
	public void NewAdmitSurveyWithCAP() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("NewAdmitSurveyWithCAP", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("NewAdmitSurveyWithCAP", xls);		
		}
	
	@Test
	public void NewAdmitSurveyWithOutCAP() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("NewAdmitSurveyWithOutCAP", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("NewAdmitSurveyWithOutCAP", xls);		
		}
	
	@Test
	public void ReCertSurveyWithCAP() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("ReCertSurveyWithCAP", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("ReCertSurveyWithCAP", xls);		
		}
	
	@Test
	public void ReCertSurveyWithOutCAP() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("ReCertSurveyWithOutCAP", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("ReCertSurveyWithOutCAP", xls);		
		}
	
	@Test
	public void ForceCloseSurvey() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("ForceCloseSurvey", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("ForceCloseSurvey", xls);		
		}
	
	@Test
	public void ReOpenSurvey() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("ReOpenSurvey", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("ReOpenSurvey", xls);		
		}
	
	@Test
	public void ExceptionSurvey() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("ExceptionSurvey", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("ExceptionSurvey", xls);		
		}
		
	@Test
	public void DeactivateSurvey() throws Exception{
		ExcelReader xls = new ExcelReader(System.getProperty("user.dir")+"\\src\\com\\test\\selenium\\xls\\Hospice_TC.xlsx");
		if(!TestCaseUtil.isExecutable("DeactivateSurvey", xls))
			throw new SkipException("Skipping the test case as run mode is 'N'");
		KeywordAction.getInstance().executekeywordsSheetWise("DeactivateSurvey", xls);		
		}
			
		
	

}
