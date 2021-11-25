package org.iit.healthcare.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.HelperClass;
import org.iit.healthcare.mmp.TestBaseClass;
import org.iit.healthcare.mmp.adminmodule.pages.AdminMessagesPage;
import org.iit.healthcare.mmp.patientmodule.pages.PatientMessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminSendMessagesTests extends TestBaseClass{
	 

		@Test
		public void validateScheduleAppointment()
		{
			 
			
			HelperClass helper = new HelperClass(driver);
			helper.launchApplicationURL(pro.getProperty("URL"));
			helper.login(pro.getProperty("patientUser"),pro.getProperty("patientPassword"));
			helper.navigateToAModule("Messages");
			PatientMessagesPage msgPage = new PatientMessagesPage(driver);
			HashMap<String,String> expectedHMap = msgPage.fillMessageDetails(pro);
			boolean result = msgPage.validateMessages(pro.getProperty("sendMessagesSuccessfulText"));
			SoftAssert sa = new SoftAssert();
			sa.assertTrue(result);
			
			
			helper.launchApplicationURL(pro.getProperty("urlAdmin"));
			helper.login(pro.getProperty("adminUser"),pro.getProperty("adminPassword"));
			helper.navigateToAModule("Messages");
			AdminMessagesPage adminMsgPage = new AdminMessagesPage(driver);
			HashMap<String,String> actualHMap = adminMsgPage.fetchLatestMessageDetails();
			sa.assertEquals(actualHMap,expectedHMap);
			sa.assertAll();
			
			
			 
		}

}
