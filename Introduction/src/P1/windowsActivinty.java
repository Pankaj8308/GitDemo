package P1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowsActivinty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Maximize window
		driver.manage().window().maximize();
		driver.get("http://google.com"); 
		//way to access URL when we navigate through selenium invoked browser
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		//Navigate back(Click browser back button)
		driver.navigate().back();
		//Navigate forward(Click browser forward button)
		driver.navigate().forward();
		driver.quit();
		
		
		
		

	}

}
