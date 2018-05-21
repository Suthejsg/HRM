package com.hrm.PFM;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
	
	
	public static void getexcel()
	{
		try
		{
			HashMap<String,String> maps=new HashMap<String,String>();
			Workbook wb=WorkbookFactory.create(new File("D:\\Suthej\\PFM\\src\\test\\java\\com\\hrm\\resource\\AdminData.xls"));
			Sheet s=wb.getSheetAt(0);
			String key = "",value="";
			
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
						
					}
					else
					{
						Row row=s.getRow(j);
						value=row.getCell(i).getStringCellValue();
						maps.put(key, value);
					}
				}
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		thash();
		getexcel();

	}

}
