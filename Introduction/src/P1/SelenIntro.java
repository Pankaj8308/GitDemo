package P1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SelenIntro {

	public static void main(String[] args) {
		//Invoking Browser
		//Chrome-ChromeDriver ->Methods
		//step to invoke driver 
		//above can be done by selenium manager
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
      
         
	}

}
