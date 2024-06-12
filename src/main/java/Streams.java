import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\n505739\\OneDrive - British Airways Plc\\Documents\\JavaSeleniumLearning\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> ls= driver.findElements(By.xpath("//tr/td[2]"));
        List<String> newLs=ls.stream().filter(s->Integer.parseInt(s.getText())>50).map(s->s.findElement(By.xpath("parent::tr/td[1]")).getText()).collect(Collectors.toList());
        newLs.stream().forEach(s-> System.out.println(s));

    }
}
