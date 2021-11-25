package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.List;

import org.iit.healthcare.Utility;
import org.iit.healthcare.mmp.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {

	public WebDriver driver;
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	 
	public HashMap<String, String> bookAnAppointment(String doctorName)
	{
		
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		
		driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();

		expectedHMap.put("doctor", doctorName);
		driver.findElement(By.xpath("//h4[normalize-space()='Dr."+doctorName+"']/ancestor::ul/following-sibling::button")).click();
 
		driver.switchTo().frame("myframe");

		//Generate the Future Date

		String futureDate = Utility.getFutureDate(20);
		System.out.println("Future Date :: " + futureDate);
		//driver.findElement(By.id("datepicker")).sendKeys(futureDate);
		driver.findElement(By.id("datepicker")).click();
		String appointmentMonth = futureDate.split("/")[0];
		String appointmentdate = futureDate.split("/")[1];
		String appointmentYear = futureDate.split("/")[2];

		HelperClass helper = new HelperClass(driver);
		helper.visibilityofElementLocated(By.xpath("//span[@class='ui-datepicker-month']"),30);

		String displayedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String displayedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		while(!(appointmentYear.equals(displayedYear)))
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			displayedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		}
		while(!(appointmentMonth.equals(displayedMonth)))
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			displayedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		}
		driver.findElement(By.linkText(appointmentdate)).click();


		expectedHMap.put("date", driver.findElement(By.id("datepicker")).getAttribute("value"));


		//Select the time
		Select timeSelect = new Select(driver.findElement(By.id("time")));
		timeSelect.selectByValue("10Am");
		expectedHMap.put("time", "10Am");

		driver.findElement(By.id("ChangeHeatName")).click();


		//Random Text
		driver.findElement(By.id("sym")).sendKeys("Fever123");
		expectedHMap.put("sym", "Fever123");

		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		
		return expectedHMap;
	}
	 
	 
}
