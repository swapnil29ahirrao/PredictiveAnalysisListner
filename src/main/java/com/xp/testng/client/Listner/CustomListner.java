package com.xp.testng.client.Listner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListner implements ITestListener{

	File file = new File("D:\\"+File.separator+"sample_"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.log'").format(new Date()));
	FileOutputStream fos;
	FileInputStream fis;
	Scanner scn;
	String report;

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {

		try {
			fos=new FileOutputStream(file,true);
			if(file.length()==0)
				report=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +":\t"+ result.getName() +"\t" +result.getMethod().getMethodName()+"\tPassed";
			else
				report="\n" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +":\t"+ result.getName() +"\t" +result.getMethod().getMethodName()+"\tPassed";
			fos.write(report.getBytes());
		} catch (FileNotFoundException e ) {
			System.out.println("File not found...");
		} catch (IOException e) {
			System.out.println("Unable to write file");
		}
	}

	public void onTestFailure(ITestResult result) {

		StringWriter sw=new StringWriter();
		result.getThrowable().printStackTrace(new PrintWriter(sw));
		String stackTrace=sw.toString();

		try {
			fos=new FileOutputStream(file,true);
			if(file.length()==0)
				report=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +":\t"+ result.getName() +"\t" +result.getMethod().getMethodName()+"\tFailed"+"\t"+stackTrace;
			else
				report="\n" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()) +":\t"+ result.getName() +"\t" +result.getMethod().getMethodName()+"\tFailed"+"\t"+stackTrace;
			fos.write(report.getBytes());
		} catch (FileNotFoundException e ) {
			System.out.println("File not found...");
		} catch (IOException e) {
			System.out.println("Unable to write file");
		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

}
