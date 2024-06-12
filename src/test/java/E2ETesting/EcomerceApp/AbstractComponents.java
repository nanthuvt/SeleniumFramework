package E2ETesting.EcomerceApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
	}
	public void waitVisibilityOfElement(By element)
	{
		WebDriverWait w= new WebDriverWait(driver,15);
		w.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void waitVisibilityOfElement(WebElement element)
	{
		WebDriverWait w= new WebDriverWait(driver,15);
		w.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitInvisibilityOfElement(By element)
	{
		WebDriverWait w= new WebDriverWait(driver,15);
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(element)));
	}

}
