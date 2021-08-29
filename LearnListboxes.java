package Week2.Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnListboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/Dropdown.html");
		WebElement drpDwn1 = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select selDrpDwn1 = new Select(drpDwn1);
		selDrpDwn1.selectByIndex(1);
		
		WebElement droDwn2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select selDrpDwn2 = new Select(droDwn2);
		selDrpDwn2.selectByVisibleText("Appium");
		
		WebElement drpDwn3 = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		Select selDrpDwn3 = new Select(drpDwn3);
		selDrpDwn3.selectByValue("3");
		
		Select selDrpDwn4 = new Select(driver.findElement(By.xpath("//select[@class='dropdown']")));
		List<WebElement> drpDwn4Options = selDrpDwn4.getOptions();
		int size = drpDwn4Options.size();
		int numberOfOptions = size - 1;
		System.out.println("The Number of options are " + numberOfOptions);
		
		driver.findElement(By.xpath("(//div[@class='example'])[5]/select")).sendKeys("Loadrunner");
		
		Select drpDwn5 = new Select(driver.findElement(By.xpath("(//div[@class='example'])[6]/select")));
		List<WebElement> options = drpDwn5.getOptions();
		int size2 = options.size();
		for (int i = 1; i < size2; i++) {
			drpDwn5.selectByIndex(i);
		}
	}

}
