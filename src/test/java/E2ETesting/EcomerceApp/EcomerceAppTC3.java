package E2ETesting.EcomerceApp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import E2ETesting.TestingComponent.TestingComponent;
import PageObjectClass.LoginPage.CheckOutProduct;
import PageObjectClass.LoginPage.LoginPage;
import PageObjectClass.LoginPage.ProductClick;
import PageObjectClass.LoginPage.VerifyAddToCart;

public class EcomerceAppTC3 extends TestingComponent{
	
	@Test
	public void EcomerceAppPositive(){
	
		ProductClick addToCart=login.loginPage("nanthuvt@gmail.com", "Rahulshetty1!");
		VerifyAddToCart verifyAddToCartSucess=addToCart.AddToCart("ZARA COAT 3");
		CheckOutProduct checkOut=verifyAddToCartSucess.VerifyProductInAddToCart("ZARA COAT 3");
		checkOut.deleteProduct("ZARA COAT 3");
	
		
	}

}
