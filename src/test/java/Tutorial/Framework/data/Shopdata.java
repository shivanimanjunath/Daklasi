package Tutorial.Framework.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Shopdata {
	
	@Test
	public List<HashMap<String, String>> datashop() throws IOException
	{
		//read json to String
		String jasonContent=FileUtils.readFileToString(new File("C:\\Users\\theer\\eclipse-workspace-Shivani\\Framework\\src\\test\\java\\Tutorial\\Framework\\data\\testdata.json"),StandardCharsets.UTF_8);
		
		//String to HashMap - Jackson Databind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jasonContent, new TypeReference<List<HashMap<String,String>>>(){	
		});
		
		return data;
		
		
	}

}
