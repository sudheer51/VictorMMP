package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.Properties;

import org.iit.healthcare.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientMessagesPage {

	public WebDriver driver;
	public PatientMessagesPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public HashMap<String, String> fillMessageDetails(Properties pro)
	{
		HashMap<String,String> msgData= new HashMap<String,String>();
		String reason ="PAT_AUT_REASON_"+Utility.getRandomString(4);
		msgData.put("reason", reason);
		String subject ="PAT_AUT_SUBJECT_"+Utility.getRandomString(4);
		msgData.put("subject", subject);
		msgData.put("date", Utility.getFutureDate(0, "dd-MM-YYYY"));
		msgData.put("name",pro.getProperty("patientName") );	
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys(reason);
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		return msgData;
	}
	public boolean validateMessages(String expMessage)
	{
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		alert.accept();
		return actualMessage.equals(expMessage);

	}
}
