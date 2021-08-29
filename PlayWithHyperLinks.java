package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithHyperLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://leafground.com/pages/Link.html");
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.navigate().back();
		
		String linkDestination = driver.findElement(By.partialLinkText("Find where am supposed to go without")).getAttribute("href");
		System.out.println(linkDestination);
		
		String str = "HTTP Status 404 – Not Found";
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String pageTitle = driver.getTitle();
		if(pageTitle.equals(str)) {
			System.out.println("Page is Broken");
		}
		else {
			System.out.println("Page is not broken");
		}
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
		driver.navigate().back();
		
		Dimension size = driver.findElement(By.xpath("//a[contains(text(),'How many links are available')]")).getSize();
		System.out.println(size);
		
	}

}
