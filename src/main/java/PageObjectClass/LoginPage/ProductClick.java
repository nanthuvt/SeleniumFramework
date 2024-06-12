package PageObjectClass.LoginPage;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import E2ETesting.EcomerceApp.AbstractComponents;

public class ProductClick extends AbstractComponents {

	WebDriver driver;
	public ProductClick(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By ProductNameBy= By.cssSelector("b");
	By AddToCartBy=By.cssSelector(".w-10");
	
	public List<WebElement> getProducts()
	{
		return products;
	}
	
	public VerifyAddToCart AddToCart(String ProductName)
	{
		List<WebElement> products=getProducts();
		System.out.println(products.get(0).findElement(ProductNameBy).getText());
		List<WebElement> button=products.stream().filter(s->s.findElement(ProductNameBy).getText().equalsIgnoreCase(ProductName)).map(s->s.findElement(AddToCartBy)).collect(Collectors.toList());
		button.get(0).click();
		VerifyAddToCart verifyAddToCartSucess=new VerifyAddToCart(driver);
		return verifyAddToCartSucess;
		
	}
	
}

