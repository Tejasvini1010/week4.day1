package Week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	private static final String ExpectedConditions = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev90408.service-now.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("3epiSY6wrUMF");
		driver.findElement(By.id("sysverb_login")).click();

		driver.findElement(By.id("filter")).sendKeys("incident");

		driver.findElement(By.xpath("//ul[contains(@aria-label,'Incident')]/li[6]/div/div/a/div/div")).click();

		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);

		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.id("incident.short_description")).sendKeys("Automation testing purpose");
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Abel Tuter")).click();

		driver.switchTo().window(windowHandlesList.get(0));
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame2);
		
		WebElement incident = driver.findElement(By.xpath("//input[@id='incident.number']"));
		String text = incident.getAttribute("value");
		System.out.println("Incident number: " + text);

		driver.findElement(By.id("sysverb_insert_bottom")).click();

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(text, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		File source = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/myincident.png");
		FileUtils.copyFile(source, dst);

	}
}
