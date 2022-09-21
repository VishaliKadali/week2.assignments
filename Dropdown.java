package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Which is your favorite UI Automation tool?");
		WebElement select=driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select dropdown=new Select(select);
		dropdown.selectByVisibleText("Playwright");
		//Choose your preferred country
		driver.findElement(By.xpath("//label[.='Select Country']")).click();
		//Choose germany
		driver.findElement(By.xpath("//li[@data-label='Germany']")).click();
		//Choose your City
		
		driver.findElement(By.xpath("//li[@data-label='Germany']")).click();
		//Select your preferrred location
		driver.findElement(By.xpath("//label[.='Select City']")).click();
		WebElement City1=driver.findElement(By.xpath("//li[.='Berlin']"));
		String text=City1.getText();
		City1.click();
		Thread.sleep(3000);
		
		System.out.println(text);
		//Change the country
		driver.findElement(By.xpath("//label[.='Select Country']")).click();
		driver.findElement(By.xpath("//li[@data-label='India']")).click();
		
		driver.findElement(By.xpath("//label[.='Select City']")).click();
		WebElement city2=driver.findElement(By.xpath("//li[.='Chennai']"));
		String text2=city2.getText();
		city2.click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-item-label='AWS']")).click();
		
		driver.findElement(By.xpath("//label[.='Select Language']")).click();
		driver.findElement(By.xpath("//li[.='English']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[.='Select Values']")).click();
		driver.findElement(By.xpath("//li[@data-label='Two']")).click();
		Thread.sleep(3000);
		driver.close();
	}

}
