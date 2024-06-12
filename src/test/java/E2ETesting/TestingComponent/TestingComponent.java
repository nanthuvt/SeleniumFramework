package E2ETesting.TestingComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjectClass.LoginPage.LoginPage;

public class TestingComponent {
	
	WebDriver driver;
	public LoginPage login;
	public WebDriver initializeDriver() throws FileNotFoundException, IOException
	{
		Properties prop=new Properties();
		//InputStream is= new FileInputStream("C:\\Users\\n505739\\OneDrive - British Airways Plc\\Documents\\JavaSeleniumLearning\\selenium_testing\\src\\main\\java\\TestingComponent\\Resources\\GlobalData.properties")
		prop.load(new FileInputStream("E:\\Learn\\selenium_testing\\src\\main\\java\\TestingComponent\\Resources\\GlobalData.properties"));
		
		String browser=prop.getProperty("browser");
		System.out.println(browser);
		if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\Users\\nanth\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
			//driver.manage().timeouts().implicitlyWait(10,u);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
		return driver;
	}
	
	public List<HashMap<Object,Object>> getJSONParsedData() throws IOException
	{
		String jsonData=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\main\\java\\TestingComponent\\Data\\TestData.json"), StandardCharsets.UTF_8);
		
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<Object,Object>> data=mapper.readValue(jsonData, new TypeReference<List<HashMap<Object,Object>>>(){});
		return data;
	
	}
	
	@BeforeMethod
	public LoginPage LaunchApplication() throws FileNotFoundException, IOException
	{
		driver=initializeDriver();
		login= new LoginPage(driver);
		login.gotoPage();
		return login;
	}
	
	@AfterMethod
	public void closeDriver()
	{
		driver.close();
	}
}
