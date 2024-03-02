package P1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropdowns {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		// Static drop down-select dropdown
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		// creating object for select class
		Select dropdown = new Select(staticDropdown);
		// Selecting dropdown with Index
		dropdown.selectByIndex(3);
		// To get selected drop down value
		System.out.println(dropdown.getFirstSelectedOption().getText());
		// To select option based on visible text
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		// To select by value attribute
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		// Dropdown where we have to add passenger number
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		// Clicking + button 4 times to make number from 1 to 5 using while loop
		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		// Clicking + button 4 times to make number from 0 to 4 using for loop
		for (int j = 0; j < 4; j++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		// Check selected passengers
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		// Assertion used to check whether correct number of passengers are selected
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult, 4 Child");
		// Dynamic drop down
		// Click on From Dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		// Select from as BLR
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		// Select To as MAA
		Thread.sleep(1000);
		// Xpath example when two nodes are found using XPATH, in that case to click on
		// second node we use Syntax(XPATH)[2]
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		// Parent Child Relationship between XPATH where we used Parent XPATH and Child
		// XPATH to avoid Index as done above
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();
		// Auto suggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		// Iterate in to option
		for (WebElement Option : options) {
			if (Option.getText().equals("India")) {
				Option.click();
				break;
			}
		}

		// .isSelected to check whether check box is clicked or not
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		// Assert False used to check whether check box is unselected
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		// Click Check Box
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		// .isSelected to check whether check box is clicked or not
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		// Assert True is used to validate whether check box is selected
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		// count the number of check boxes
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());

		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(), 6);

		// Calendar Handling
		// Clicking on calendar icon
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		// selecting current date, Current date may have unique locator
		driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();
		// Validating whether element is enabled or disabled
		// System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		// Alternate method for validating enabled disabled, this is used as some times
		// isEnable/Disabled methods do not give appropriate results
		System.out.println(driver.findElement(By.id("spclearDate")).getAttribute("Style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("spclearDate")).getAttribute("Style"));
		// System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		if (driver.findElement(By.id("spclearDate")).getAttribute("Style").contains("block")) {
			System.out.println("Enabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("Disabled");
			// Failing the script if element is not enabled hence we placed false value in
			// Assert.assertTrue()
			Assert.assertTrue(false);
		}
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
