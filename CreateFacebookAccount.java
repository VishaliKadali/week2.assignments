package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateFacebookAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//a[.='Create New Account']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Vishali");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("K");
		
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("9849732919");
		
		driver.findElement(By.xpath("//input[@aria-label='New password']")).sendKeys("leaf@12345");
		
		
		//HAndle all three dropdowns
		
		WebElement dayDropdown=driver.findElement(By.xpath("//select[@aria-label='Day']"));
		
		Select dayDrpdown=new Select(dayDropdown);
		
		dayDrpdown.selectByIndex(1);
		dayDrpdown.getFirstSelectedOption();
		System.out.println(dayDrpdown.getFirstSelectedOption().getText());
		
		WebElement monthDropdown=driver.findElement(By.xpath("//select[@aria-label='Month']"));
		Select monthDrpdown=new Select(monthDropdown);
		monthDrpdown.selectByVisibleText("May");
		
		WebElement yearDropdown=driver.findElement(By.xpath("//select[@aria-label='Year']"));
		Select yearDrpdown=new Select(yearDropdown);
		yearDrpdown.selectByValue("1982");
		
		//Select Gender
		driver.findElement(By.xpath("//label[.='Female']")).click();
		driver.close();
		
		
	}

}
