import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignmet2Multiple {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\n505739\\OneDrive - British Airways Plc\\Documents\\JavaSeleniumLearning\\msedgedriver.exe");
        WebDriver driver= new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//div[@class='example']/a")).click();
        Set<String> window=driver.getWindowHandles();
        Iterator<String> it =window.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
    }
}
