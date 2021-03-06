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
		
		public UpdateProfilePage(WebDriver dr)
		{
			this.driver = dr;
		}

		
		//*****************************************************************************
		//******                  UPDATE PROFILE PAGE Actions             *************
		//*****************************************************************************
		public void clickEditButton()
		{
			System.out.println("+++ In Profile tab clickEditButton +++");
			driver.findElement(By.xpath("//input[@id='Ebtn']")).click();
		}
		
		public String clickProfileSaveButton()
		{
			System.out.println("+++ In Profile tab clickProfileSaveButton +++");
			driver.findElement(By.xpath("//input[@id='Sbtn']")).click();
			Alert alert= driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert msg is: " +alertMsg);
			alert.accept();
			return alertMsg;		
		}
		
		public HashMap<String, String> getProfileDetails()
		{
			System.out.println("+++ In Profile tab getProfileDetails() +++");
			HashMap <String, String> profileDetails = new HashMap<String, String>();

			profileDetails.put("First Name", driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("value"));
			profileDetails.put("Last Name", driver.findElement(By.xpath("//input[@id='lname']")).getAttribute("value"));
			profileDetails.put("License", driver.findElement(By.xpath("//input[@id='licn']")).getAttribute("value"));
			profileDetails.put("SSN", driver.findElement(By.xpath("//input[@id='ssn']")).getAttribute("value"));
			profileDetails.put("Address", driver.findElement(By.xpath("//input[@id='addr']")).getAttribute("value"));
			profileDetails.put("Age", driver.findElement(By.xpath("//input[@id='age']")).getAttribute("value"));
			profileDetails.put("Weight", driver.findElement(By.xpath("//input[@id='weight']")).getAttribute("value"));
			profileDetails.put("City", driver.findElement(By.xpath("//input[@id='city']")).getAttribute("value"));
			profileDetails.put("State", driver.findElement(By.xpath("//input[@id='state']")).getAttribute("value"));
			profileDetails.put("Zip", driver.findElement(By.xpath("//input[@id='zip']")).getAttribute("value"));
					
			return profileDetails;
			
		}
		
		
		
		//*****************************************************************************
		//******                  UPDATE PROFILE ZIP Actions              *************
		//*****************************************************************************
		
		public int editProfileZip() throws InterruptedException
		{
			int randZip = Utility.getRandomZip();
			
			System.out.println("+++ In Profile tab editProfileZip() +++");
			driver.findElement(By.xpath("//input[@id='zip']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='zip']")).sendKeys(""+randZip+"");  
			System.out.println("Changing the zip to: "  +randZip);
			return randZip;
		}
		
		public void editProfileDeleteZip() throws InterruptedException
		{
			
			System.out.println("+++ In Profile tab editProfileDeleteZip() +++");
			driver.findElement(By.xpath("//input[@id='zip']")).clear();
			Thread.sleep(2000);	
		}
		
		
		public void editProfileInvalidZip(String str) throws InterruptedException
		{
			System.out.println("++++ In Profile tab editProfileInvalidZip() ++++");
			
			if(str.contains("short"))
			{
				int invalidZip = Utility.getRandomInvalidZip(str);
				System.out.println("Invalid  short zip to be entered: " + invalidZip);
				driver.findElement(By.xpath("//input[@id='zip']")).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("" + invalidZip + "");
			}
			if(str.contains("long"))
			{
				int invalidZip = Utility.getRandomInvalidZip(str);
				System.out.println("Invalid long zip to be entered: " + invalidZip);
				driver.findElement(By.xpath("//input[@id='zip']")).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("" + invalidZip + "");
			}
			if(str.contains("alpha"))
			{
				String invalidZip = Utility.getRandomString(8);
				System.out.println("Invalid alpha zip to be entered: " + invalidZip);
				driver.findElement(By.xpath("//input[@id='zip']")).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("" + invalidZip + "");
			}
			
		}
		
		public String editProfileInvalidZipSaveBtn()
		{
			System.out.println("+++ In Profile tab  editProfileInvalidZipSaveBtn()+++");
			driver.findElement(By.xpath("//input[@id='Sbtn']")).click();
			String msg = driver.findElement(By.xpath("//p[@id='ziperr']")).getText();
			return msg;
		}
		
		
		//*****************************************************************************
		//******                  UPDATE PROFILE AGE Actions              *************
		//*****************************************************************************
		
		public int editProfileValidAge() throws InterruptedException{
		
			System.out.println("+++ In editProfileValidAge +++");
			int randAge = Utility.getRandomNumber(101);
			
			driver.findElement(By.xpath("//input[@id='age']")).clear();
			Thread.sleep(2000);
			System.out.println("Changing Age to: " +randAge);
			driver.findElement(By.xpath("//input[@id='age']")).sendKeys(""+randAge+"");
			return randAge;		
		}
		
		public void editProfileInvalidAge(int age) throws InterruptedException
		{
			System.out.println("+++ In editProfileInValidAge +++");
			driver.findElement(By.xpath("//input[@id='age']")).clear();
			Thread.sleep(2000);
			System.out.println("Changing Age to: " +age);
			driver.findElement(By.xpath("//input[@id='age']")).sendKeys(""+age+"");		
		}
		
		public String editProfileInvalidAgeSaveBtn()
		{
			System.out.println("+++ In Profile tab  editProfileInvalidAgeSaveBtn()+++");
			driver.findElement(By.xpath("//input[@id='Sbtn']")).click();
			String msg = driver.findElement(By.xpath("//p[@id='ageerr1']")).getText();
			return msg;		
		}
		
		public String editProfileBlankAgeSaveBtn()
		{
			System.out.println("+++ In Profile tab  editProfileBlankAgeSaveBtn()+++");
			driver.findElement(By.xpath("//input[@id='Sbtn']")).click();
			String msg = driver.findElement(By.xpath("//p[@id='ageerr']")).getText();
			return msg;
			
		}
		
		public void editProfileDeleteAge() throws InterruptedException
		{
			System.out.println("+++ In Profile tab editProfileDeleteAge() +++");
			driver.findElement(By.xpath("//input[@id='age']")).clear();
			Thread.sleep(2000);	
		}
	}
		
