import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Frame {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\n505739\\OneDrive - British Airways Plc\\Documents\\JavaSeleniumLearning\\msedgedriver.exe");
        WebDriver driver= new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String keyStroke = Keys.chord(Keys.CONTROL,Keys.ENTER);
        WebElement footer=driver.findElement(By.cssSelector("div[id='gf-BIG']"));
        //footer.findElement(By.cssSelector("a[href*='rest']")).sendKeys(keyStroke);
       // Set<String> windows=driver.getWindowHandles();
       // Iterator<String> it=windows.iterator();
        //driver.switchTo().window(it.next());

        List<WebElement> allLinks= footer.findElements(By.tagName("a"));
        SoftAssert a= new SoftAssert();
        System.out.println(allLinks.size());
        for(WebElement links : allLinks)
        {
            String url= links.getAttribute("href");
            System.out.println(url);
            HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            System.out.println(conn.getResponseCode());
            if(conn.getResponseCode()>400)
            {
                System.out.println(url+" broken with code "+conn.getResponseCode());
               a.assertTrue(conn.getResponseCode()<400,url+" link is broker");
            }

        }
        a.assertAll();


    }
}
