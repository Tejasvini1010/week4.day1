package Week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnNonModalAlerts {

	
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://www.leafground.com/pages/Alert.html");
			String title = driver.getTitle();
			System.out.println(title);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//button[@onclick='normalAlert()']")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			driver.findElement(By.xpath("//button[@onclick='confirmAlert()']")).click();
			Alert alert1 = driver.switchTo().alert();
			alert1.dismiss();
			
			String text = driver.findElement(By.id("result")).getText();
	if (text == "You pressed OK!") 
		System.out.println("You have accepted it");
	else
		System.out.println("You have not accepted it");
	}
			
			
	}

