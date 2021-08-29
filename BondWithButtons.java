package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BondWithButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/Button.html");
		
		driver.findElement(By.id("home")).click();
		driver.navigate().back();
		
		Point location = driver.findElement(By.id("position")).getLocation();
		int xCordinate = location.x;
		int yCordinate = location.y;
		System.out.println("X cordinate of the Button is " + xCordinate);
		System.out.println("Y cordinate of the Button is " + yCordinate);
		
		
		String buttonClour = driver.findElement(By.id("color")).getAttribute("style");
		System.out.println(buttonClour);
		
		Dimension buttonSize = driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize();
		int buttonhHight = buttonSize.getHeight();
		int buttonWidth = buttonSize.getWidth();
		System.out.println("Height and the Width of the Button are " + buttonhHight  + ", " + buttonWidth + " respectively");
		
	}

}
