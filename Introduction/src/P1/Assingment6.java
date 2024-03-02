package P1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assingment6 {

	// 1. Select check box option 2: 
	// 2. grab the selected check box text
	// 3. Select an option in Dropdown- option should come from step 2(text of check box)
	// 4. Enter the Step Grabbed lable text in edit box
	// 5. Click on alert and then if text grabbed from step 2 is present in pop up message
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("checkBoxOption2")).click();
		WebElement chkBx = driver.findElement(By.id("checkBoxOption2"));
		chkBx.click();
		String optionSelected = chkBx.getAttribute("value");
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select sd = new Select(dropdown);
		sd.selectByValue(optionSelected);
		driver.findElement(By.id("name")).sendKeys(optionSelected);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		Assert.assertEquals(alertText.contains(optionSelected), true);
		driver.switchTo().alert().accept();
		System.out.println("Test Passed");

	}

}
