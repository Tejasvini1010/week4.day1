package Week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Frames");
		
		//driver.switchTo().frame(frame1);
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		
		WebElement drop1 = driver.findElement(By.id("animals"));
		Select drpdwn1 = new Select(drop1);
		drpdwn1.selectByValue("avatar");
		
		
		
		
		
		
		
		
		
		

	}

}
