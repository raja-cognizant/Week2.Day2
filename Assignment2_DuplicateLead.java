package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_DuplicateLead {

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
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByName("emailAddress").sendKeys("testlead@gmail.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		String firsresultingtLead = driver
				.findElementByXPath("((//table[@class='x-grid3-row-table'])[1]/tbody/tr//a)[1]").getText();
		System.out.println("The First Resulting lead is " + firsresultingtLead);
		driver.findElementByXPath("((//table[@class='x-grid3-row-table'])[1]/tbody/tr//a)[1]").click();
		String leadFirstName = driver.findElementById("viewLead_firstName_sp").getText();
		String leadSurname = driver.findElementById("viewLead_lastName_sp").getText();
		String leadFullName = leadFirstName.concat(leadSurname);
		driver.findElementByLinkText("Duplicate Lead").click();
		String pageTitle = driver.getTitle();
		String pageTitleSubstring = pageTitle.substring(0, 14);
		if (pageTitleSubstring.equals("Duplicate Lead")) {
			System.out.println("Title Verified! We are on Duplicate Lead Page");
		} else {
			System.out.println("Title Verification Failed");
		}
		driver.findElementByName("submitButton").click();
		String dupLeadFirstName = driver.findElementById("viewLead_firstName_sp").getText();
		String dupLeadSurname = driver.findElementById("viewLead_lastName_sp").getText();
		String dupLeadFullName = dupLeadFirstName.concat(dupLeadSurname);
		if (dupLeadFullName.equals(leadFullName)) {
			System.out.println("Duplicate Lead name is same as the Orignial one!");
		} else {
			System.out.println("Duplicate lead name is not equal to the original Lead name");
		}
		driver.close();
	}

}
