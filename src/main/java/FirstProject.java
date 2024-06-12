import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FirstProject {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver" , "C:\\Users\\n505739\\OneDrive - British Airways Plc\\Documents\\JavaSeleniumLearning\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //WebElement selectDropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        /*Select dropDown = new Select(selectDropDown);

        //System.out.println("myr"+dropDown.getOptions().toString());
        dropDown.selectByIndex(1);
        dropDown.selectByIndex(2);
        System.out.println(dropDown.getFirstSelectedOption().getText());
        System.out.println(dropDown.getAllSelectedOptions().get(0));*/

        //driver.close();

        /*driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Bra");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        System.out.println("myr");
        System.out.println(options.get(1).getText());
        for(WebElement option : options)
        {
            System.out.println(option.getText());
            if(option.getText().equalsIgnoreCase("Brazil"))
            {
                option.click();
                System.out.println(option.getText());
                break;
            }
        }*/
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
        List<WebElement> tdList = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
        for (WebElement element1 : tdList)
        {
            if (element1.getAttribute("data-month").equalsIgnoreCase("4") & element1.getAttribute("data-year").equalsIgnoreCase("2024"))
            {
                if(element1.findElement(By.cssSelector(".ui-state-default")).getText().equalsIgnoreCase("12"))
                {
                    element1.findElement(By.cssSelector(".ui-state-default")).click();
                    break;
                }
            }
        }



    }
}
