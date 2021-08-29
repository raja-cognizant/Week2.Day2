package Week2.Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithImages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/Image.html");
		driver.findElement(By.xpath("(//div[@class='row']//img)[1]")).click();
		driver.navigate().back();
		Dimension imgSize = driver.findElement(By.xpath("(//div[@class='row']//img)[2]")).getSize();
		int ImgHeight = imgSize.height;
		int imgWidth = imgSize.width;

		if (ImgHeight < 20 && imgWidth < 20) {
			System.out.println("Image is Broken");
		} else {
			System.out.println("Image is NOT Broken");
		}
		
		WebElement imgToBeClicked = driver.findElement(By.xpath("(//div[@class='row']//img)[3]"));
		Actions builder = new Actions(driver);
		Actions seriesOfActions  = builder
				.moveToElement(imgToBeClicked)
				.click();
		
		seriesOfActions.perform();
		driver.navigate().back();
		
	}
	

}
