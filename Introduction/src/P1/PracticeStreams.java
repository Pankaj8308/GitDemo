package P1;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class PracticeStreams {
	@Test
	public void InValidEmail() 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.className("Pke_EE")).sendKeys("iPhone"+Keys.ENTER);
		List<WebElement> prd = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		WebElement prod=prd.stream().filter(s->s.getText().contains("128")).findFirst().orElse(null);
		prod.click();
		Set<String> win = driver.getWindowHandles();
		java.util.Iterator<String> it = win.iterator();
		String win1 = it.next();
		String win2 = it.next();
		driver.switchTo().window(win2);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/button")));
		driver.findElement(By.xpath("//li/button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/button")));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("_17N0em")));
		driver.findElement(By.className("_17N0em")).sendKeys("hjscbhjs@jbs.jsdb");
		driver.findElement(By.className("_3AWRsL")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("_2sKwjB")));
		String errmess=driver.findElement(By.className("_2sKwjB")).getText();
		System.out.println(errmess);
		Assert.assertTrue(errmess.contains("Invalid"));
		driver.quit();
	}

}