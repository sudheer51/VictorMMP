package org.iit.healthcare.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iit.healthcare.mmp.HelperClass;
import org.iit.healthcare.mmp.TestBaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.UpdateProfilePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
 * Tester: VICTOR
 * Date Created: 12/10/2021
 * Added test cases (positive and negative) to validate Update to Patient Zip code and Age
 * Verified By: Sudheer
 * Verified Date: 12/17/2021
 */

public class UpdateProfileTests extends TestBaseClass {

	HashMap<String, String> profileDetails = new HashMap<String, String>();
	HashMap<String, String> editedProfileDetails = new HashMap<String, String>();
	SoftAssert sa = new SoftAssert();
	
	@Test (priority = 1)
	public void editProfileValidZip() throws InterruptedException
	{
		
		System.out.println("\n============================================================");
		System.out.println("  ++++ TC: UPDATE PROFILE ZIP WITH VALID ZIP CODE ++++");
		System.out.println("============================================================\n");
		
		HelperClass helper = new HelperClass(driver);
		helper.launchApplicationURL(pro.getProperty("URL"));
		String name = helper.patientLogin(pro.getProperty("patientUser"), pro.getProperty("patientPassword"));
		sa.assertEquals(name, pro.getProperty("patientUser"), "Wrong username in Login page!!");
		System.out.println("Logged in successfully with Valid credentials!!!");
		
		String title = helper.navigateToPage("Profile");
		sa.assertEquals(title, "profile", "Navigation to Profile page failed!!");
		System.out.println("Navigated to Profile tab successfully!!!");
		
		UpdateProfilePage upp = new UpdateProfilePage(driver);
		profileDetails = upp.getProfileDetails();
		System.out.println("Profile Details Before Edits: " +profileDetails.entrySet().toString());
		
		upp.clickEditButton();
		int zip = upp.editProfileZip();
		profileDetails.put("Zip", ""+zip+"");
		System.out.println("Expected Profile Details with new zip: " +profileDetails.entrySet().toString());
		String msg = upp.clickProfileSaveButton();
		sa.assertEquals(msg, "Your Profile has been updated.", "The Alert message doesn't match!!");
		editedProfileDetails = upp.getProfileDetails();
		System.out.println("Actual Profile Details After Edit: " +editedProfileDetails.entrySet().toString());
		sa.assertEquals(editedProfileDetails, profileDetails, "The hashmaps don't match!!");
		System.out.println("Profile Zip Code updated successfully!!!!");
		sa.assertAll();
		
	}
	

	@Test (priority = 2)
	public void editProfileInvalidZip() throws InterruptedException
	{
		System.out.println("\n======================================================================");
		System.out.println("  ++++ TC: UPDATE PROFILE ZIP WITH INVALID ZIP: SHORT ZIP CODE ++++");
		System.out.println("======================================================================\n");
		
		HelperClass helper = new HelperClass(driver);
		UpdateProfilePage upp = new UpdateProfilePage(driver);
		profileDetails = upp.getProfileDetails();
		System.out.println("Profile Details Before Edits: " +profileDetails.entrySet().toString());
		
		upp.clickEditButton();
		upp.editProfileInvalidZip("short");
		String errMsg = upp.editProfileInvalidZipSaveBtn();
		sa.assertEquals(errMsg, "please enter zipcode", "Error Message not correct!!");
		System.out.println("Expected Invalid Zip Error Msg:: "+errMsg+" :: is displayed!!!");
	
		helper.pageRefresh();		
		editedProfileDetails = upp.getProfileDetails();
		System.out.println("Actual Profile Details After Edit: " +editedProfileDetails.entrySet().toString());
		sa.assertEquals(editedProfileDetails, profileDetails, "The hashmaps don't match!!");
		System.out.println("Update Profile - Invalid Zip Test passed!!!!");
		sa.assertAll();
	}
	
	
	@Test (priority = 3)
	public void editProfileLongZip() throws InterruptedException
	{
		System.out.println("\n=====================================================================");
		System.out.println("  ++++ TC: UPDATE PROFILE ZIP WITH INVALID ZIP: LONG ZIP CODE ++++");
		System.out.println("=====================================================================\n");
		
		HelperClass helper = new HelperClass(driver);
		UpdateProfilePage upp = new UpdateProfilePage(driver);
		profileDetails = upp.getProfileDetails();
		System.out.println("Profile Details Before Edits: " +profileDetails.entrySet().toString());
		
		upp.clickEditButton();
		upp.editProfileInvalidZip("long");
		String errMsg = upp.editProfileInvalidZipSaveBtn();
		sa.assertEquals(errMsg, "please enter zipcode", "Error Message not correct!!");
		System.out.println("Expected Invalid Zip Error Msg:: "+errMsg+" :: is displayed!!!");
		
		helper.pageRefresh();
		editedProfileDetails = upp.getProfileDetails();
		System.out.println("Actual Profile Details After Edit: " +editedProfileDetails.entrySet().toString());
		sa.assertEquals(editedProfileDetails, profileDetails, "The hashmaps don't match!!");
		System.out.println("Update Profile - Invalid Zip Test passed!!!!");		
		sa.assertAll();
	}
	
	@Test (priority = 4)
	public void editProfileValidAge() throws InterruptedException
	{
		System.out.println("\n========================================================");
		System.out.println("    ++++ TC: UPDATE PROFILE AGE WITH VALID AGE ++++");
		System.out.println("========================================================\n");
		
		UpdateProfilePage upp = new UpdateProfilePage(driver);
		profileDetails = upp.getProfileDetails();
		System.out.println("Profile Details Before Edits: " +profileDetails.entrySet().toString());
		upp.clickEditButton();
		int age = upp.editProfileValidAge();
		profileDetails.put("Age", ""+age+"");
		System.out.println("Expected Profile Details with Age field updated: " +profileDetails.entrySet().toString());
		String msg = upp.clickProfileSaveButton();
		sa.assertEquals(msg, "Your Profile has been updated.", "The Alert message doesn't match!!");
		editedProfileDetails = upp.getProfileDetails();
		System.out.println("Actual Profile Details After Edit: " +editedProfileDetails.entrySet().toString());
		sa.assertEquals(editedProfileDetails, profileDetails, "The hashmaps don't match!!");
		System.out.println("Profile Age edited successfully!!!!");
		sa.assertAll();
		
	}
	
	@Test (priority = 5)
	public void editProfileLargeAge() throws InterruptedException
	{
		System.out.println("\n============================================================");
		System.out.println("   ++++ TC: UPDATE PROFILEAGE WITH INVALID AGE - 101 ++++");
		System.out.println("============================================================\n");
		
		HelperClass helper = new HelperClass(driver);
		
		UpdateProfilePage upp = new UpdateProfilePage(driver);
		profileDetails = upp.getProfileDetails();
		System.out.println("Profile Details Before Edits: " +profileDetails.entrySet().toString());
		upp.clickEditButton();
		upp.editProfileInvalidAge(101);
		String errMsg = upp.editProfileInvalidAgeSaveBtn();
		sa.assertEquals(errMsg, "please enter valid age", "The Error message doesn't match!!");
		System.out.println("Expected Invalid Age Error Msg:: "+errMsg+" :: is displayed!!!");
		
		helper.pageRefresh();		
		editedProfileDetails = upp.getProfileDetails();
		System.out.println("Actual Profile Details After Edit: " +editedProfileDetails.entrySet().toString());
		sa.assertEquals(editedProfileDetails, profileDetails, "The hashmaps don't match!!");
		System.out.println("Edit Profile - Invalid Age Test passed!!!!");	
		sa.assertAll();
	}
	
	
}
