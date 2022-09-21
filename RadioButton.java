package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("You most favourite browser");
		driver.findElement(By.xpath("(//label[.='Chrome']/preceding::div[1])[1]")).click();
		System.out.println("UnSelectable");
		driver.findElement(By.xpath("//label[.='Bengaluru']")).click();
		System.out.println("Find the default select radio button");
		String text=driver.findElement(By.xpath("//h5[.='Find the default select radio button']/following::input[@checked='checked']")).getText();
		System.out.println(text);
		boolean selected=driver.findElement(By.xpath("//h5[.='Select the age group (only if not selected)']/following::span")).isSelected();
		if(!selected) {
			
			driver.findElement(By.xpath("//h5[.='Select the age group (only if not selected)']/following::span")).click();
		}
		
		else {
			System.out.println("Checkbox has already been selected");
		}
		driver.close();
	}

}
