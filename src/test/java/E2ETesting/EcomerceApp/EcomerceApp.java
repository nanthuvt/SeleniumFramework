package E2ETesting.EcomerceApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import E2ETesting.TestingComponent.TestingComponent;
import PageObjectClass.LoginPage.CheckOutProduct;
import PageObjectClass.LoginPage.LoginPage;
import PageObjectClass.LoginPage.ProductClick;
import PageObjectClass.LoginPage.VerifyAddToCart;

public class EcomerceApp extends TestingComponent{
	
	@Test(dataProvider="getData")
	public void EcomerceAppPositive(HashMap<Object,Object> data){
	
		//System.out.println(System.getProperty("user.dir"));
		ProductClick addToCart=login.loginPage(data.get("uname").toString(), data.get("pwd").toString());
		VerifyAddToCart verifyAddToCartSucess=addToCart.AddToCart(data.get("product").toString());
		CheckOutProduct checkOut=verifyAddToCartSucess.VerifyProductInAddToCart(data.get("product").toString());
		checkOut.provideDetailsAndCheckOut();
		//Assert.assertEquals(login.checkUser(), "Incorrect email or password.");
	
		
	}
	
	
	//using dataprovider
	/*@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"nanthuvt@gmail.com","Rahulshetty1!","ZARA COAT 3"},{"nanthuvt@gmail.com","Rahulshetty1!","ADIDAS ORIGINAL"}};
	}*/
	
	
	/*@DataProvider
	public Object[][] getData()
	{
		HashMap<Object,Object> map1=new HashMap<Object,Object>();
		map1.put("uname","nanthuvt@gmail.com");
		map1.put("pwd","Rahulshetty1!");
		map1.put("product","ZARA COAT 3");
		
		HashMap<Object,Object> map2=new HashMap<Object,Object>();
		map2.put("uname","nanthuvt@gmail.com");
		map2.put("pwd","Rahulshetty1!");
		map2.put("product","ADIDAS ORIGINAL");
		
		return new Object[][] {{map1},{map2}};
		
	}*/
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<Object,Object>> data=getJSONParsedData();
		return new Object[][] {{data.get(0)},{data.get(1)}};
	
	
	}

}
