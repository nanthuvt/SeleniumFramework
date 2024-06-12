package PageObjectClass.LoginPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutProduct {

	WebDriver driver;
	public CheckOutProduct(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement CheckOutButton;
	
	public void clickCheckOutButton()
	{
		CheckOutButton.click();
	}
	
	@FindBy(css="input[value='4542 9931 9292 2293']")
	WebElement CreditCardNumber;
	
	@FindBy(xpath="//select[1]")
	WebElement ExpiryMonth;
	
	@FindBy(xpath="//select[2]")
	WebElement ExpiryDate;
	
	@FindBy(xpath="//div[text()='Name on Card ']/following-sibling::input")
	WebElement NameOnCard;
	
	@FindBy(xpath="//div[text()='CVV Code ']/following-sibling::input")
	WebElement CvvCode;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".infoWrap")
	List<WebElement> cartItems;
	
	By listOfCountry=By.cssSelector(".list-group-item");
	
	By cartItemsNamesBy=By.tagName("h3");
	
	By deleteButtons= By.cssSelector(".btn-danger");
	
	public void provideDetailsAndCheckOut()
	{
		clickCheckOutButton();	
		CreditCardNumber.clear();
		CreditCardNumber.sendKeys("4542 9931 9292 0000");
		//WebElement dp=ExpiryMonth;
		Select drpdown=new Select(ExpiryMonth);
		drpdown.selectByVisibleText("05");
		//WebElement dp1=driver.findElement(By.xpath("//select[2]"));
		Select drpdown1=new Select(ExpiryDate);
		drpdown1.selectByVisibleText("28");
		NameOnCard.sendKeys("Sunapply");
		CvvCode.sendKeys("234");
		
		country.sendKeys("Ind");
		
		List<WebElement> CountryButtons= driver.findElements(listOfCountry);
		WebElement countryButton= CountryButtons.stream().filter(s->s.findElement(By.cssSelector("span")).getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		countryButton.click();
		WebElement placeOrder=driver.findElement(By.cssSelector(".action__submit "));
		Actions action=new Actions(driver);
		action.moveToElement(placeOrder).click().build().perform();
	}
	
	public void deleteProduct(String productName)
	{
		WebElement DeleteButton=cartItems.stream().filter(s->s.findElement(cartItemsNamesBy).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		DeleteButton.findElement(deleteButtons).click();
	}
}
