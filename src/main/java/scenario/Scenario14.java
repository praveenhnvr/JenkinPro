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

public class Scenario14
{
   @Test
    public void test14() throws InterruptedException
    {
	    WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.bluestone.com/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.xpath("//li[@id='goldCoins']/a[@title='Gold Coins']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		WebElement ele5 = driver.findElement(By.xpath("//span[.='Plain Gold Coins']/following::span[.='1 gram'][1]"));
		ele5.click();
		WebElement ele5V = driver.findElement(By.xpath("//span[.='1 GRAM 24 KT GOLD COIN']"));
		System.out.println(ele5V.getText());	
		Assert.assertEquals(ele5V.getText(),"1 GRAM 24 KT GOLD COIN");
		System.out.println("1 GRAM 24 KT GOLD COIN is displayed");
		driver.close();
    }
}
