package MavenPracticeProject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import MavenPracticeProject.PageObject.CartPage;
import MavenPracticeProject.PageObject.CheckOutPage;
import MavenPracticeProject.PageObject.OrderPage;
import MavenPracticeProject.PageObject.ProductCatPage;
import TestComponent.BaseTest;
import TestComponent.ReTry;

public class UserSubmitOrder extends BaseTest {
	//String productName = "ADIDAS";
	@Test(dataProvider=("getData"),groups={"purchase"},retryAnalyzer= ReTry.class)
//public void submitOrder(String Email, String Password, String Product) throws IOException
	public void submitOrder(HashMap<String,String> input) throws IOException
{
		//String productName = "ADIDAS";
		// Object creation for Launch and Basic web driver is done in BaseTest class
		ProductCatPage prd = LP.loginApp(input.get("email"), input.get("password"));
		// Get list of product
		prd.getProductList();
		prd.addProd(input.get("product"));
		prd.addCartclick();
		
		// Cart page
		CartPage crt = new CartPage(driver);
		crt.cartList();
		crt.ismatch(input.get("product"));
		
		// checkout
		CheckOutPage ckp =new CheckOutPage(driver);
		ckp.checkoutAction();
		ckp.SubmissionAndMessage();

	}
	
	@Test(dependsOnMethods={"submitOrder"},dataProvider=("getData"),groups={"purchase"},retryAnalyzer= ReTry.class)
	public void VerifyOrder(HashMap<String,String> input)
	{
		ProductCatPage prd = LP.loginApp(input.get("email"), input.get("password"));
		OrderPage op=prd.orderClick();
		Assert.assertTrue(op.ProdName(input.get("product")).contains(input.get("product")));
	}
	
	
	
	// @DataProvider
	// public Object[][] getData()
	// {return new Object[][] {{"PKT@gmail.com","Qwerty@123","ZARA"},{"Pankajkumartiwari8308@gmail.com","Qwerty@123","ADIDAS"}};}
	
	// Data with hashmap
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\DataSource\\DataRepository");
		return new Object[][]{{data.get(0)},{data.get(1)}};
		// Manually creating HasMap
		//HashMap<String,String> map = new HashMap<String,String>();
		//map.put("email", "Pankajkumartiwari8308@gmail.com");
		//map.put("password", "Qwerty@123");
		//map.put("product", "ADIDAS");
		
		//HashMap<String,String> map1 = new HashMap<String,String>();
		//map1.put("email", "PKT@gmail.com");
		//map1.put("password", "Qwerty@123");
		//map1.put("product", "ZARA");
		
		
	}
	
	
	
}
