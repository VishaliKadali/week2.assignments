package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		//String driverPath=System.setProperty(null, null)
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on link 
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on Leads
		driver.findElement(By.xpath("//a[.='Leads']")).click();
		
		//Click on Find Leads
		driver.findElement(By.xpath("//a[contains(text(), 'Find Leads')]")).click();
		//Click on Email 
		
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		//Enter email address
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("test@gmail.com");
		//Click on Find Leads
		driver.findElement(By.xpath("//button[.='Find Leads']")).click();
		
		Thread.sleep(1000);
		
		//Click on any lead id
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		
		Thread.sleep(1000);
		
		//String text=driver.findElement(By.xpath("//a[.='Duplicate Lead']")).getAttribute("linkText");
		
	//	System.out.println(text);
		
		//Click on Duplicate lead
		driver.findElement(By.xpath("//a[.='Duplicate Lead']")).click();
		
		Thread.sleep(1000);
		
		
		
		//String ttitle=text.getAttribute("linkText");
		
		String text="Duplicate Lead";
		
		
		
		String title=driver.getTitle();
		
		System.out.println(title);
		
		if(text.equalsIgnoreCase(title)) {
			
			System.out.println("Title matches");
		}
		
		else {
			
			System.out.println("Title doesn't match");
		}
		driver.close();
		
	}

}
