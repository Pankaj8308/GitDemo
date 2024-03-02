package P1;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Browseroption {

	public static void main(String[] args) throws IOException {
		// ChromeOptions class object creation
		ChromeOptions co = new ChromeOptions();
		// Adding extension, This will enable extension on browser
		// co.addExtensions("chrome://extensions/?id=ndgimibanhlabgdgjcpbbndiehljcpfh");
		// Method to accept insecure certificates
		co.setAcceptInsecureCerts(true);
		// Object co created for class ChromeOptions has to be passed below as Argument
		WebDriver driver = new ChromeDriver(co);
		// Deleting all cookies
		driver.manage().deleteAllCookies();
		// deleting specific cookie
		driver.manage().deleteCookieNamed("Name");
		driver.get("https://expired.badssl.com/");
		// Take Screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\panka\\OneDrive\\Desktop\\Screenshots\\Screenshot.png"));
		System.out.println(driver.getTitle());
		Assert.assertNotEquals(driver.getTitle(), "Privacy error");
		// changing download path
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		co.setExperimentalOption("prefs", prefs);

	}

}
