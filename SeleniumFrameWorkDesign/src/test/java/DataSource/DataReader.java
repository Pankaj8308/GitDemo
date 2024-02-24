package DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		// Read Json to string
		String jsoncont =FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\DataSource\\DataRepository"),StandardCharsets.UTF_8);
		// convert string to HashMap, we will have to get Jackson databind dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data  =mapper.readValue(jsoncont, new TypeReference<List<HashMap<String, String>>>(){});
		return data;
		
		
	}
	
}
