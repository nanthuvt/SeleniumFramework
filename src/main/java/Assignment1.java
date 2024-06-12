import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Assignment1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver" , "C:\\Users\\n505739\\OneDrive - British Airways Plc\\Documents\\JavaSeleniumLearning\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

    }
}
