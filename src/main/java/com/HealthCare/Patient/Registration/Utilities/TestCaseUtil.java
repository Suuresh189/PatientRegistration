package com.HealthCare.Patient.Registration.Utilities;

public class TestCaseUtil {
	public static boolean isExecutable(String testName, ExcelReader xls){
		
		int rows = xls.getRowCount("TestCaseSuite");
		
		for(int rNum = 2; rNum <= rows; rNum++)
		{		
			//System.out.println("rNum...aaa..."+rNum);
			String tcid = xls.getCellData("TestCaseSuite", "TestCaseID", rNum);
			//System.out.println("tcid...aaa..."+tcid);
			String Runmode = xls.getCellData("TestCaseSuite", "RunMode", rNum);
			//System.out.println("Runmode...111..."+Runmode);

			if (testName.trim().equalsIgnoreCase(tcid)) {
				if (Runmode.trim().equalsIgnoreCase("Y")) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
		
	}

}
