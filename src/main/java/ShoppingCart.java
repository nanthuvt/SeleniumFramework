import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Arrays;
import java.util.List;

public class ShoppingCart {
    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver","C:\\Users\\n505739\\OneDrive - British Airways Plc\\Documents\\JavaSeleniumLearning\\msedgedriver.exe");

        WebDriver driver= new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] items = {"Brocolli","Carrot","Beans","Walnuts"};
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));
        int count=0;
        System.out.println(products.size());
        for(int i=0;i<products.size();i++)
        {
            //System.out.println(product.getText());

            System.out.println(products.get(i).getText());
            //String[] productName=product.findElement(By.xpath("//h4[@class='product-name']")).getText().split(" -");
            List<String> itemsList = Arrays.asList(items);
            //System.out.println(productName[0]);
            System.out.println(products.get(i).findElement(By.cssSelector("h4[class='product-name']")).getText().split(" -")[0]);
            if(itemsList.contains(products.get(i).findElement(By.cssSelector("h4[class='product-name']")).getText().split(" -")[0]))
            {
                System.out.println("sanam ond");
                count++;
                products.get(i).findElement(By.cssSelector("div[class='product-action'] button")).click();
            }
            //if(count==3)
                //break;
        }
    }
}
