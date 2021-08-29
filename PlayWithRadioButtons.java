package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PlayWithRadioButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/radio.html");

		driver.findElement(By.xpath("(//div[@id='first']//input)[1]")).click();

		// driver.findElement(By.xpath("(//input[@name='news'])[1]")).click();

		boolean selected = driver.findElement(By.xpath("(//input[@name='news'])[2]")).isSelected();
		if (selected) {
			String text = driver.findElement(By.xpath("(//input[@name='news'])[2]/..")).getText();
			System.out.println("Option that is selected by default is :" + text);
		} else {
			String text2 = driver.findElement(By.xpath("(//input[@name='news'])[1]/..")).getText();
			System.out.println("Option that is selected by default is " + text2);
		}

		
		
		boolean selected2 = driver.findElement(By.xpath("(((//div[@class='row'])[3]/div/input)[2])")).isSelected();
		if (selected2) {
			System.out.println("My age group is already selected");
		}
		else {
			driver.findElement(By.xpath("(((//div[@class='row'])[3]/div/input)[2])")).click();
		}
	}

}
