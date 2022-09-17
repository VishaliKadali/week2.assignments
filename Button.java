package week2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.leafground.com/button.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String click=driver.findElement(By.xpath("//h5[.='Click and Confirm title.']")).getAttribute("h5");
		System.out.println(click);
		
		driver.findElement(By.xpath("//h5[.='Click and Confirm title.']/following::span[contains(text(),'Click')]")).click();
		
		//Navigate back
		driver.navigate().back();
		
		System.out.println("Confirm if the button is enabled");
		
		boolean enabled=driver.findElement(By.xpath("//h5[.='Confirm if the button is disabled.']/following::span[contains(text(),'Disabled')]")).isEnabled();
		
		
		if(!enabled) {
			
			System.out.println("Button is not enabled");
			
		}
		
		else {
			System.out.println("Button is enabled");
		}
		
		//Find the position of submit button
		System.out.println("Find the position of the submit button");
		Point Location=driver.findElement(By.xpath("(//h5[.='Find the position of the Submit button']/following::span[contains(text(),'Submit')])[1]")).getLocation();
		System.out.println(Location);
		
		//Find the save button color
		System.out.println("Find the save button color");
		String cssValue=driver.findElement(By.xpath("//span[.='Save']")).getCssValue("color");
		System.out.println(cssValue);
		
		//Find the height and width of this button
		//Inorder to get sixe and width of the button use getsize method
		System.out.println("Height and width of the button");
		Dimension size=driver.findElement(By.xpath("(//span[.='Submit'])[2]")).getSize();
		System.out.println(size);
		
		//Mouse over and confirm the color changed
		WebElement success= driver.findElement(By.xpath("(//span[.='Success'])[1]"));
		
		//Check hte background color
		System.out.println("Check the background color");
		String color1=success.getCssValue("background-color");
		System.out.println(color1);
		
		Actions builder=new Actions(driver);
		builder.moveToElement(success).perform();
		
		System.out.println("Check the back ground color after mousehover");
		String color2=success.getCssValue("background-color");
		System.out.println(color2);
		
		if(!color2.equals(color1)) {
			
			System.out.println("Color changed");
		}
		
		else {
			System.out.println("Color not changed");
		}
		
		//Click on Image button and click on any hidden button
		System.out.println("Click on any image button and click on hidden button");
		driver.findElement(By.xpath("(//span[.='Image'])[1]")).click();
		
		//Click on hidden elements
		driver.findElement(By.xpath("//div[@class='card ui-fluid']")).click();
		
		//How many rounded buttons are there?
		
		List<WebElement> roundedbuttonsize=driver.findElements(By.xpath("//button[contains(@class,'rounded-button')]"));
		
		//System.out.println("Rounded button size: " +roundedbuttonsize);
		
		int NoOfRoundedbuttons=roundedbuttonsize.size();
		
		System.out.println("No of Rounded buttons : " +NoOfRoundedbuttons);
		
		driver.close();
	}

}
