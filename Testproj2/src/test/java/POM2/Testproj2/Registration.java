package POM2.Testproj2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestComp.Base;
import TestComp.Retry;

public class Registration extends Base{
	
	@Test(dataProvider="getData",retryAnalyzer = Retry.class)
	public void RegisterUser(HashMap<String, String> input)
	{
		SignUp su =lp.clikCart();
		AccountInfo aci = su.signUpDetail(input.get("name"), input.get("email"));
		AcctCreated ac = aci.acctInfo();
		String message = ac.createVal();
		assertEquals(message, "ACCOUNT CREATED!");
		DeleteAcc da=ac.cont();
		String delMess=da.delete();
		assertEquals(delMess, "ACCOUNT DELETED!");
	
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\Input");
		return new Object[][]{{data.get(0)},{data.get(1)}};
	}

	}

