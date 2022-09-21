package week2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Link {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.leafground.com/link.xhtml");

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[1]"));
		
		String title=driver.getTitle();
		
		System.out.println(title);
		if(title.contains("Dashboard")) {
			
			System.out.println("Dashboard confirmed");
		}
		
		else {
			
			System.out.println("Dashboard is not confirmed");
		}
		
		driver.navigate().forward();
		
		String attribute=driver.findElement(By.xpath("//a[contains(text(),'Find the URL without clicking me.')]")).getAttribute("a");
		System.out.println(attribute);
		
		driver.findElement(By.xpath("(//a[text()='Broken?'])[1]")).click();
		String title2=driver.getTitle();
		if(title2.contains("404")) {
			
			System.out.println("Broken");
		}
		else {
			System.out.println("Not Broken");
		}
		Thread.sleep(2000);
		driver.navigate().back();
		
		driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[2]")).click();
		driver.navigate().forward();
		
		//driver.findElement(By.xpath("//a[.='How many links in this page?']"))
		
		List<WebElement> findElements=driver.findElements(By.tagName("a"));
		System.out.println(findElements.size());
		driver.navigate().back();
	}

}
