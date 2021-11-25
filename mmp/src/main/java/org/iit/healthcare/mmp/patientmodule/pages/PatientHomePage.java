package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientHomePage {
	
	public WebDriver driver;
	public PatientHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public HashMap<String, String> fetchPatientDetails()
	{


		//Validation- Read the values from Patient Portal WebTable
		
		HashMap<String,String> actualHMap = new HashMap<String,String>();
		List<WebElement> tdList = driver.findElements(By.xpath("//table[@class='table']/tbody/tr[1]/td"));
		actualHMap.put("date",tdList.get(0).getText() );
		actualHMap.put("time", tdList.get(1).getText());
		actualHMap.put("sym", tdList.get(2).getText());
		actualHMap.put("doctor",tdList.get(3).getText());
		return actualHMap;
	}

}
