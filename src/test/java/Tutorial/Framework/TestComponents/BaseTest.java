package Tutorial.Framework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Tutorial.Framework.LoginpageTest;

public class BaseTest {
	

	public WebDriver driver;
	public LoginpageTest login;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties ps=new Properties();
		FileInputStream fs= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Tutorial\\Framework\\resources\\TestData.properties");
		
		ps.load(fs);
		//If browser is not sent through mvn commands.
		//String broswerName=ps.getProperty("Browser");
		String broswerName=System.getProperty("Browser")!=null?System.getProperty("Browser"):ps.getProperty("Browser");
		 
		if(broswerName.contains("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			if(broswerName.contains("headless"))
			{
			option.addArguments("Headless");
			}
	    driver= new ChromeDriver(option);		
		}
		
		driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public LoginpageTest Launchapp() throws IOException
	{
		driver=initializeDriver();
		login=new LoginpageTest(driver);
		login.LandOn();
		return login;
	}
	
	public List<HashMap<String, String>> datashop(String filepath) throws IOException
	{
		//read json to String
		String jasonContent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
	//	String jasonContent=FileUtils.readFileToString(new File("C:\\Users\\theer\\eclipse-workspace-Shivani\\Framework\\src\\test\\java\\Tutorial\\Framework\\data\\testdata.json"),StandardCharsets.UTF_8);
		//String to HashMap - Jackson Databind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jasonContent, new TypeReference<List<HashMap<String,String>>>(){	
		});
		
		return data;
		
		
	}
	
	public String getscreenshot(String testcasename, WebDriver driver2) throws IOException
	{
		TakesScreenshot ts= ((TakesScreenshot)driver2);
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Shivani\\"+testcasename+".png");
		FileHandler.copy(src, dest);
		return "C:\\Shivani\\"+testcasename+".png";
		
	}

	
}
