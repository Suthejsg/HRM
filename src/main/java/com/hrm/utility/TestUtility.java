package com.hrm.utility;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtility {
	
	
	public static String takeScreenShot(WebDriver driver) throws IOException
	{
	
		Date date=new Date();
		SimpleDateFormat simpledateformat=new SimpleDateFormat("dd.MM.yyyy");
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File srcFile=screenshot.getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		String destinationDir=currentDir+"/Screenshots/"+ simpledateformat.format(date)+System.currentTimeMillis() + ".jpeg";
		File targetFile=new File(destinationDir);
		FileUtils.copyFile(srcFile, targetFile);
		return destinationDir;
		
	}

	
	public static void main(String[] args)
	{
		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat simpledateformat=new SimpleDateFormat("dd.MM.yyyy");
		try {
			
			String datetoparse="23.01.1985";
			Date d=simpledateformat.parse(datetoparse);
			Calendar c=Calendar.getInstance();
			System.out.println(c.getTimeZone());
			System.out.println("The calender time is "+c.getTime());
			
			String formattedDate=simpledateformat.format(d);
			System.out.println(formattedDate);
			System.out.println(System.currentTimeMillis());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
