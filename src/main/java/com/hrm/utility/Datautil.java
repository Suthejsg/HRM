package com.hrm.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Datautil {
	
	
	
	public static void thash()
	{
		HashMap<String,String> maps=new HashMap<String,String>();
		maps.put("T1", "v1");
		maps.put("T1", "v2");
		maps.put("T1", "v3");
		String s=maps.get("T1");
		System.out.println(maps);
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		Object[][] dataArray=new Object[1][1];
		try
		{
			HashMap<String,List<String>> maps=new HashMap<String,List<String>>();
			List<String> valueList=null;
			Workbook wb=WorkbookFactory.create(new File("C:\\Users\\user\\git\\HRM1\\src\\test\\java\\com\\hrm\\resource\\AdminData.xls"));
			Sheet s=wb.getSheetAt(0);
			String key = "";
			
			
			int rowCount=s.getLastRowNum();
			int colCount=s.getRow(0).getLastCellNum();
			
			for(int i=0;i<colCount;i++)
			{
				for(int j=0;j<=rowCount;j++)
				{
					if(j==0)
					{
						Row row=s.getRow(j);
						key=row.getCell(i).getStringCellValue();
						valueList=new ArrayList<String>();
						
					}
					else
					{
						
						Row row=s.getRow(j);
						valueList.add(row.getCell(i).getStringCellValue());
						
					}
				}
				maps.put(key, valueList);
			}
			
			dataArray[0][0]=maps;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return dataArray;
		
		
	}

	public static void main(String[] args) {
		
		thash();
		getData();

	}

}
