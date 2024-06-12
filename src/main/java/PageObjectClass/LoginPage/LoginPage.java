package PageObjectClass.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import E2ETesting.EcomerceApp.AbstractComponents;

public class LoginPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userEmail")
	WebElement uname;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(css=".ng-trigger-flyInOut")
	WebElement ErrorMessage;
	
	public void gotoPage()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProductClick loginPage(String username, String password)
	{
		uname.sendKeys(username);
		pwd.sendKeys(password);
		loginButton.click();
		ProductClick addToCart=new ProductClick(driver);
		return addToCart;
	}
	
	
	public String checkUser()
	{
		waitVisibilityOfElement(ErrorMessage);
		return ErrorMessage.getText();
	}

}
