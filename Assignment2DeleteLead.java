package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2DeleteLead {

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
		driver.findElementByXPath("(//span[@class='x-tab-strip-inner'])[2]/span").click();
		driver.findElementByName("phoneCountryCode").clear();
		driver.findElementByName("phoneCountryCode").sendKeys("91");
		driver.findElementByName("phoneNumber").sendKeys("9581154411");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		String firsresultingtLead = driver.findElementByXPath("((//table[@class='x-grid3-row-table'])[1]/tbody/tr//a)[1]").getText();
		System.out.println("The First Resulting lead is " + firsresultingtLead);
		driver.findElementByXPath("((//table[@class='x-grid3-row-table'])[1]/tbody/tr//a)[1]").click();
		driver.findElementByLinkText("Delete").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("id").sendKeys(firsresultingtLead);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		String message = driver.findElementByXPath("//div[text()='No records to display']").getText();
		System.out.println(message);
		if(message.equals("No records to display")){
			System.out.println("Test case passed! Lead successfully deleted");
		}
		else {
			System.out.println("Test case Failed! Lead is not deleted");
		}
		
	}

}
