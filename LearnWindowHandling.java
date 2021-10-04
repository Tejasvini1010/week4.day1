package Week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[@href='https://www.air.irctc.co.in/']")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		System.out.println(driver.getTitle());

		String text = driver.findElement(By.xpath("//a[@class='d-block font-weight-bold']")).getText();
		System.out.println("The customer care mail id is " +text);
		driver.switchTo().window(windowHandlesList.get(0)).close();

	}

}
