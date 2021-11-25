package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.HelperClass;
import org.iit.healthcare.mmp.TestBaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.PatientHomePage;
import org.iit.healthcare.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends TestBaseClass{
 

	@Test
	public void validateScheduleAppointment()
	{
		 
		
		HelperClass helper = new HelperClass(driver);
		helper.launchApplicationURL(pro.getProperty("URL"));
		helper.login(pro.getProperty("patientUser"),pro.getProperty("patientPassword"));
		helper.navigateToAModule("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> expectedHMap =sPage.bookAnAppointment(pro.getProperty("doctorName"));
		PatientHomePage homePage = new PatientHomePage(driver);
		HashMap<String,String> actualHMap = homePage.fetchPatientDetails();
		Assert.assertEquals(actualHMap, expectedHMap);
	}
}






















/*
//WebDriverWait wait = new WebDriverWait(driver,30);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4[contains(.,'Dr.Smith')])[2]")));
//
//
////JavascriptExecutor jse = (JavascriptExecutor) driver;
////WebElement e1 = driver.findElement(By.xpath("(//h4[contains(.,'Dr.Smith')])[2]"));
//jse.executeScript("arguments[0].scrollIntoView(true)", e1);
//
//driver.findElement(By.xpath("(//h4[contains(.,'Dr.Smith')])[2]")).click();
*/