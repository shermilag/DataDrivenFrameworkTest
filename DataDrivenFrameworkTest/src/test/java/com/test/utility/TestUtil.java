package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
 
	  static Xls_Reader reader;
		
		
		public static ArrayList<Object[]> getDataFromExcel(){

				ArrayList<Object[]> myData = new ArrayList<Object[]>();
				
				try {
					reader = new Xls_Reader("C:\\Users\\raghu\\eclipse-workspace\\DataDrivenFrameworkTest\\src\\test\\java\\com\\testdata\\DDFSheet.xlsx");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				for (int rowNum = 2; rowNum <= reader.getRowCount("RegTestData"); rowNum++) {
					
						String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
						String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
						String emailaddress = reader.getCellData("RegTestData", "emailaddress", rowNum);
						String password = reader.getCellData("RegTestData", "password", rowNum);
						
						Object ob[] = {firstName, lastName, emailaddress, password};
						myData.add(ob);
						
						
				}
				return myData;
			
		}
  }

