package org.iit.healthcare.mmp.patientmodule.tests;

import org.iit.healthcare.mmp.HelperClass;
import org.iit.healthcare.mmp.TestBaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.PatientMessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientSendMessagesTests extends TestBaseClass{
	 

		@Test
		public void validateScheduleAppointment()
		{
			 
			
			HelperClass helper = new HelperClass(driver);
			helper.launchApplicationURL(pro.getProperty("URL"));
			helper.login(pro.getProperty("patientUser"),pro.getProperty("patientPassword"));
			helper.navigateToAModule("Messages");
			PatientMessagesPage msgPage = new PatientMessagesPage(driver);
			msgPage.fillMessageDetails(pro);
			boolean result = msgPage.validateMessages(pro.getProperty("sendMessagesSuccessfulText"));
			Assert.assertTrue(result);
			 
		}

}
