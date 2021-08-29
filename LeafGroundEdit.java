package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/Edit.html");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rajaraman.s@gmail.com");
		
		WebElement edit2 = driver.findElement(By.xpath("//label[contains(text(),'Append a text')]/following-sibling::input"));
		String fieldValue = edit2.getAttribute("value");
		String newstr = fieldValue.concat("text");
		edit2.clear();
		edit2.sendKeys(newstr);
		edit2.sendKeys(Keys.TAB);
		
		
		String edit3 = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println("Default value entered is " + "'" + edit3 + "'");
		
		driver.findElement(By.xpath("//label[contains(text(),'Clear the')]/following-sibling::input")).clear();
		
		String state = "true";
		WebElement edit4 = driver.findElement(By.xpath("//label[contains(text(),'Confirm that edit')]/following-sibling::input"));
		String editField = edit4.getAttribute("disabled");
		if(editField.equals(state)) {
			System.out.println("Field is not Editable");
		}
		else {
			System.out.println("Field is Editable");
		}
		
		
	}

}
