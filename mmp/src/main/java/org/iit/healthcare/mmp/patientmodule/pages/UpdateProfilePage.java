package org.iit.healthcare.mmp.patientmodule.pages;


import java.util.HashMap;
import org.iit.healthcare.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/*
 * Tester: Team VICTOR
 * Date Created: 12/10/2021
 * Added action methods to update patient Profile Zip code and Age.
 * Verified By: Sudheer
 * Verified Date: 12/17/2021
 */


public class UpdateProfilePage {
	
		
		WebDriver driver;
		
		public UpdateProfilePage(WebDriver driver)
		{
			this.driver = driver;
		}

		
		//*****************************************************************************
		//******                  UPDATE PROFILE PAGE Actions             *************
		//*****************************************************************************
		
		//Click on Edit Button
		public void clickEditButton()
		{
			System.out.println("+++ In Profile tab clickEditButton +++");
			driver.findElement(By.id("Ebtn")).click();
		}
		
		//Click on the Profile Save Button
		public String clickProfileSaveButton()
		{
			System.out.println("+++ In Profile tab clickProfileSaveButton +++");
			driver.findElement(By.id("Sbtn")).click();
			Alert alert= driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert msg is: " +alertMsg);
			alert.accept();
			return alertMsg;		
		}
		
		/*
		 * Fetch the values in all the Profile tab fields
		 * Returns a hashMap of all the Profile fields and values
		 */
		public HashMap<String, String> getProfileDetails()
		{
			System.out.println("+++ In Profile tab getProfileDetails() +++");
			HashMap <String, String> profileDetails = new HashMap<String, String>();
			
			profileDetails.put("First Name", driver.findElement(By.name("firstname")).getAttribute("value"));
			profileDetails.put("Last Name", driver.findElement(By.id("lname")).getAttribute("value"));
			profileDetails.put("License", driver.findElement(By.id("licn")).getAttribute("value"));
			profileDetails.put("SSN", driver.findElement(By.id("ssn")).getAttribute("value"));
			profileDetails.put("Address", driver.findElement(By.id("addr")).getAttribute("value"));
			profileDetails.put("Age", driver.findElement(By.id("age")).getAttribute("value"));
			profileDetails.put("Weight", driver.findElement(By.id("weight")).getAttribute("value"));
			profileDetails.put("City", driver.findElement(By.id("city")).getAttribute("value"));
			profileDetails.put("State", driver.findElement(By.id("state")).getAttribute("value"));
			profileDetails.put("Zip", driver.findElement(By.id("zip")).getAttribute("value"));

			return profileDetails;
			
		}
		
		
		
		//*****************************************************************************
		//******                  UPDATE PROFILE ZIP Actions              *************
		//*****************************************************************************
		
		/*
		 * Enter a valid zip code in the Profile tab
		 * @return: a valid random zip
		 */
		public int editProfileZip() throws InterruptedException
		{
			int randZip = Utility.getRandomZip();
			
			System.out.println("+++ In Profile tab editProfileZip() +++");
			driver.findElement(By.id("zip")).clear();
			Thread.sleep(2000);
			driver.findElement(By.id("zip")).sendKeys(""+randZip+"");
			System.out.println("Changing the zip to: "  +randZip);
			return randZip;
		}
		
		//Clear the value in the Zip field
		public void editProfileDeleteZip()
		{
			
			System.out.println("+++ In Profile tab editProfileDeleteZip() +++");
			driver.findElement(By.id("zip")).clear();
		}
		
		
		/*
		 * Enter an invalid zip code in the Profile zip field
		 * @param: str- short/long/alpha
		 * Generate a random short/long/alphabetical zip code
		 */
		public void editProfileInvalidZip(String str) throws InterruptedException
		{
			System.out.println("++++ In Profile tab editProfileInvalidZip() ++++");
			
			if(str.contains("short"))
			{
				int invalidZip = Utility.getRandomInvalidZip(str);
				System.out.println("Invalid  short zip to be entered: " + invalidZip);
				driver.findElement(By.id("zip")).clear();
				Thread.sleep(2000);
				driver.findElement(By.id("zip")).sendKeys(""+invalidZip+"");
			}
			if(str.contains("long"))
			{
				int invalidZip = Utility.getRandomInvalidZip(str);
				System.out.println("Invalid long zip to be entered: " + invalidZip);
				driver.findElement(By.id("zip")).clear();
				Thread.sleep(2000);
				driver.findElement(By.id("zip")).sendKeys(""+invalidZip+"");
			}
			if(str.contains("alpha"))
			{
				String invalidZip = Utility.getRandomString(8);
				System.out.println("Invalid alpha zip to be entered: " + invalidZip);
				driver.findElement(By.id("zip")).clear();
				Thread.sleep(2000);
				driver.findElement(By.id("zip")).sendKeys(""+invalidZip+"");
			}
			
		}
		
		/*
		 * Click Save Button after entering invalid zip and read the error message
		 * @return: text of the error message
		 */
		public String editProfileInvalidZipSaveBtn()
		{
			System.out.println("+++ In Profile tab  editProfileInvalidZipSaveBtn()+++");
			driver.findElement(By.id("Sbtn")).click();
			String msg = driver.findElement(By.id("ziperr")).getText();
			return msg;
		}
		
		
		//*****************************************************************************
		//******                  UPDATE PROFILE AGE Actions              *************
		//*****************************************************************************
		
		/*
		 * Edit the Profile tab Age field with a valid number
		 * @return: random age between 0 and 100.
		 */
		public int editProfileValidAge() throws InterruptedException{
		
			System.out.println("+++ In editProfileValidAge +++");
			int randAge = Utility.getRandomNumber(101);
			
			driver.findElement(By.id("age")).clear();
			Thread.sleep(2000);
			System.out.println("Changing Age to: " +randAge);
			driver.findElement(By.id("age")).sendKeys(""+randAge+"");
			return randAge;		
		}
		
		/*
		 * Enter an invalid age in the Profile tab Age field
		 * @param: age - 101
		 */
		public void editProfileInvalidAge(int age) throws InterruptedException
		{
			System.out.println("+++ In editProfileInValidAge +++");
			driver.findElement(By.id("age")).clear();
			Thread.sleep(2000);
			System.out.println("Changing Age to: " +age);
			driver.findElement(By.id("age")).sendKeys(""+age+"");
		}
		
		/*
		 * Click Save Button after entering invalid Age in the Profile tab Age field
		 * @return: text of the error message
		 */
		public String editProfileInvalidAgeSaveBtn()
		{
			System.out.println("+++ In Profile tab  editProfileInvalidAgeSaveBtn()+++");
			driver.findElement(By.id("Sbtn")).click();
			String msg = driver.findElement(By.id("ageerr1")).getText();
			return msg;		
		}
		
		/*
		 * Clear the Profile tab Age field
		 */
		public void editProfileDeleteAge() throws InterruptedException
		{
			System.out.println("+++ In Profile tab editProfileDeleteAge() +++");
			driver.findElement(By.id("age")).clear();
			Thread.sleep(2000);	
		}
	}
		
