package Week2.Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithCheckboxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/checkbox.html");

		List<WebElement> elements = driver
				.findElements(By.xpath("//label[contains(text(),'Select the languages')]/following-sibling::div"));
		for (int i = 1; i <= elements.size(); i++) {
			String strpath = "(//label[contains(text(),'Select the languages')]/following-sibling::div)[";
			String newstrpath = strpath + i + "]";
			String checkboxText = driver.findElement(By.xpath(newstrpath)).getText();
			if (checkboxText.equals("Java") || checkboxText.equals("C") || checkboxText.equals("VB")) {
				String checkboxPath = "(//label[contains(text(),'Select the languages')]/following-sibling::div/input)[";
				String newCheckboxPath = checkboxPath + i + "]";
				driver.findElement(By.xpath(newCheckboxPath)).click();
			}
		}

		boolean selected = driver
				.findElement(By.xpath("//label[contains(text(),'Confirm Selenium is')]/following-sibling::div/input"))
				.isSelected();
		if (selected) {
			System.out.println("Checkbox is selected in 'Confirm Selenium is checked' section");
		}

		List<WebElement> list = driver
				.findElementsByXPath("//label[contains(text(),'DeSelect only')]/following-sibling::div/input");
		for (WebElement element : list) {
			if (element.isSelected()) {
				element.click();
			}
		}
		
		List<WebElement> list2 = driver.findElementsByXPath("//label[contains(text(),'Select all below')]/following-sibling::div/input");
		for (WebElement element : list2) {
			element.click();
		}
	}

}
