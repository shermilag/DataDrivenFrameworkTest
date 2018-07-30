package com.datadrivern.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
	
		
		//get data from excel
		
	       Xls_Reader reader = new Xls_Reader("C:\\Users\\raghu\\eclipse-workspace\\DataDrivenFrameworkTest"
	       		+ "\\src\\test\\java\\com\\testdata\\DDFSheet.xlsx");
	       
	    //to add a new sheet
	       reader.addSheet("HomePage");
	       
	    //to verify and add sheet, if exists then no sheet will be added
	       if(!reader.isSheetExist("Homepage")) {
	    	   reader.addSheet("HomePage");
	       }
	       
	    //to get column count
	       int colCount = reader.getColumnCount("RegTestData");
	       System.out.println("total cols present in RegTestData sheet:====" + colCount);
	       
	    //to get row count
	       System.out.println(reader.getCellRowNum("RegTestData", "firstname", "Tommy"));
	       
	}

}
