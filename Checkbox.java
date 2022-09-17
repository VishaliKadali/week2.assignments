package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.leafground.com/checkbox.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//System.out.println("Click on Basic checkbox");
		
		driver.findElement(By.xpath("//span[contains(text(),'Basic')]")).click();
		
		driver.findElement(By.xpath("(//label[contains(text(),'Java')])[1]")).click();
		
		driver.findElement(By.xpath("(//label[contains(text(),'Python')])[1]")).click();
		
		driver.findElement(By.xpath("(//label[contains(text(),'Javascript')])[1]")).click();
		
		driver.findElement(By.xpath("(//label[contains(text(),'C-Sharp')])[1]")).click();
		
		driver.findElement(By.xpath("//h5[.='Tri State Checkbox']/following::div[3]")).click();
		
		//Click on toggle
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
		
		//Check if the checkbox is disabled
		Boolean checkbox=driver.findElement(By.xpath("//h5[.='Verify if check box is disabled']/following::div[3]/div[2]")).isEnabled();

		
		if(checkbox) {
			
			System.out.println("Checkbox is Enabled");
		}
		
		else {
			
			System.out.println("Checkbox is Disabled");
		}
		
	
		//Click on dropdown
		driver.findElement(By.xpath("//h5[.='Select Multiple']/following::div[1]")).click();
		
		Thread.sleep(3000);
		
		
		//Select multiple dropdown values
		driver.findElement(By.xpath("(//label[.='Miami'])[2]")).click();
		
		driver.findElement(By.xpath("(//label[.='Paris'])[2]")).click();
		
		//driver.close();
	}

}
