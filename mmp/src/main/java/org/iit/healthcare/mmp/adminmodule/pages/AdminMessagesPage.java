package org.iit.healthcare.mmp.adminmodule.pages;

import java.util.HashMap;
import java.util.Properties;

import org.iit.healthcare.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminMessagesPage {

	public WebDriver driver;
	public AdminMessagesPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public HashMap<String, String> fetchLatestMessageDetails()
	{
		HashMap<String,String> msgData= new HashMap<String,String>();
	 
		msgData.put("reason", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[2]")).getText()  );
		msgData.put("subject",driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]")).getText() );
		msgData.put("date", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[3]")).getText()  );
		msgData.put("name", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[1]")).getText() );	
		return msgData;
	}
	public boolean validateMessages(String expMessage)
	{
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		return actualMessage.equals(expMessage);

	}
}
