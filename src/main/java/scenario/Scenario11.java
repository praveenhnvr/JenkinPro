package scenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario11
{
   @Test
    public void test11() throws InterruptedException
    {
	    WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.bluestone.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//li[@class='menuparent offers-menuparent pull-right']/a"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
        driver.findElement(By.xpath("//div[@class='wh-submenu single-column-submenu width-auto']/descendant::span[@class='prcs-d'][1]")).click();
		WebElement ele5V = driver.findElement(By.xpath("//div[@class='filtered-data']/descendant::span[@class='filterDisplayName']"));
		Assert.assertEquals(ele5V.getText(),"Flat 5% Off");
		System.out.println("Products displayed with Flat 5% Off");
		driver.close();
    }
}
