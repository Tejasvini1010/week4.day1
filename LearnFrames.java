package Week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
			String title = driver.getTitle();
			System.out.println(title);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			WebElement frame1 = driver.findElement(By.xpath("//div[@id='iframewrapper']"));
			driver.switchTo().frame(frame1);
			
			

	}

}
