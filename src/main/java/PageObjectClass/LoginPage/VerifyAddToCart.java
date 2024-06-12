package PageObjectClass.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import E2ETesting.EcomerceApp.AbstractComponents;

public class VerifyAddToCart extends AbstractComponents{
	
	By addToCartVisibleBy= By.cssSelector("#toast-container");
	By addToCartInvisibleBy = By.cssSelector(".ng-animating");

	WebDriver driver;
	public VerifyAddToCart(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#toast-container")
	WebElement AddedToCartText;
	
	public void VerifyAddToCartSucessText()
	{
		waitVisibilityOfElement(addToCartVisibleBy);
		waitInvisibilityOfElement(addToCartInvisibleBy);
		String returnText=AddedToCartText.getText();
		//return returnText;
		Assert.assertEquals(returnText, "Product Added To Cart");
		
		
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css=".cartSection h3")
	WebElement productName;
	public CheckOutProduct VerifyProductInAddToCart(String product)
	{
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		VerifyAddToCartSucessText();
		cart.click();
		
		String Item=productName.getText();
		Assert.assertEquals(Item, product);
		CheckOutProduct checkOut=new CheckOutProduct(driver);
		return checkOut;
	}
}
