package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByPartialLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("firstName").sendKeys("raja");
		Thread.sleep(2000);
		String firsresultingtLead = driver
				.findElementByXPath("((//table[@class='x-grid3-row-table'])[1]/tbody/tr//a)[1]").getText();
		System.out.println("The First Resulting lead is " + firsresultingtLead);
		driver.findElementByXPath("((//table[@class='x-grid3-row-table'])[1]/tbody/tr//a)[1]").click();
		String pageTitle = driver.getTitle();
		String pageTitleSubstring = pageTitle.substring(0, 9);
		if (pageTitleSubstring.equals("View Lead")) {
			System.out.println("Title Verified! We are on View Lead Page");
		} else {
			System.out.println("Title Verification Failed");
		}
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("Cognizant");
		driver.findElementByName("submitButton").click();
		String companyname = driver.findElementById("viewLead_companyName_sp").getText();
		int strlength = companyname.length();
		String companysubstring = companyname.substring(0, strlength - 8);
		if (companysubstring.equals("Cognizant")) {
			System.out.println("The company name is updated successfully");
		} else {
			System.out.println("The company name isnot updated successfully");
		}
		driver.close();

	}

}
