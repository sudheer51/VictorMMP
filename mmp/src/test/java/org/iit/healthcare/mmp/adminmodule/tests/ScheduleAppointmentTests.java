package org.iit.healthcare.mmp.adminmodule.tests;

import org.iit.healthcare.mmp.HelperClass;
import org.iit.healthcare.mmp.TestBaseClass;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends TestBaseClass {

	@Test
	public void validateScheduleAppointment()
	{
		 
		
		HelperClass helper = new HelperClass(driver);
		helper.launchApplicationURL(pro.getProperty("urlAdmin"));
		helper.login(pro.getProperty("adminUser"),pro.getProperty("adminPassword"));
		helper.navigateToAModule("Schedule Appointment");
	}
}
