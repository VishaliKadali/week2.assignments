package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
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
		
		//Click on any lead id
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		
		String title=driver.getTitle();
		
		System.out.println(title);
		
		driver.findElement(By.linkText("Edit")).click();
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Atlassian");
		
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		
		Boolean displayed=driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).isDisplayed();
		
		System.out.println(displayed);
		
		driver.close();
		
		
	}

}
