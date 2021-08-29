package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3_RedBus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		driver.findElementByLinkText("BUS TICKETS").click();
		driver.findElementByXPath("((//div[@class='D120_search_input_wrap'])[1]//input)[1]").click();
		driver.findElementByXPath("//li[@class='C120_slist-item']").click();
		driver.findElementByXPath("((//div[@class='D120_search_input_wrap'])[2]//input)[1]").click();
		driver.findElementByXPath("(//ul[@id='C120_suggestion-wrap']/li)[1]").click();
		driver.findElementByXPath("((//div[@class='D120_search_input_wrap'])[3]//input)[1]").click();
		driver.findElementByXPath("(//li[@id='rb-next-middle'])[2]/img").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[text()='29'])[2]").click();
		driver.findElementByXPath("//button[text()='Search Buses']").click();
		
		
		
		
		
	}

}
