package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_CreateContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByPartialLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByLinkText("Create Contact").click();
		driver.findElementById("firstNameField").sendKeys("Raja");
		driver.findElementById("lastNameField").sendKeys("Raman");
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("TEST");
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("Tester1");
		driver.findElementById("createContactForm_departmentName").sendKeys("Test Department");
		driver.findElementById("createContactForm_description").sendKeys("TEST description");
		driver.findElementById("createContactForm_primaryEmail").sendKeys("test@test.com");
		WebElement countryDrpDwn = driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select country = new Select(countryDrpDwn);
		country.selectByVisibleText("New York");
		driver.findElementByName("submitButton").click();
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateContactForm_description").clear();
		driver.findElementById("updateContactForm_importantNote").sendKeys("Important Note added");
		driver.findElementByXPath("//input[@name='submitButton']").click();
		Thread.sleep(1000);
		String title = driver.getTitle();
		System.out.println(title);
		
	}

}
