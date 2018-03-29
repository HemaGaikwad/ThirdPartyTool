package autoit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ComposeEmail {

	public WebDriver driver = null;
	public static  String Chrome_Key="webdriver.chrome.driver";
	public static String Chrome_Value = "D:\\Edureka_March\\ThirdPartyToolsDemo\\Drivers\\chromedriver.exe";
	public WebDriverWait wait = null;
	
	@BeforeMethod
	public void precondition()
	{
		System.setProperty(Chrome_Key, Chrome_Value);
		driver= new ChromeDriver();
		driver.get("https://www.gmail.com");
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void RunAutoIt()
	{
		try
		{
			String strFilePath ="D:\\Edureka_Files\\SampleText.txt";
			String strPath = "D:\\Edureka_Files\\Attachment.exe";
			String strParameter = strPath+" "+strFilePath;
			Runtime.getRuntime().exec(strParameter);
			
		}
		catch (Exception e) 
		{
			System.out.println("Unable to upload the attachment");

		}
	}
	
	@Test
	public void composeEmailWithAttachment()
	{
		WebElement username = driver.findElement(By.id("identifierId"));
		username.sendKeys("seleniumedureka@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Apple12345");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		wait.until(ExpectedConditions.titleContains("Inbox"));
		WebElement composeBtn = driver.findElement(By.xpath("//div[text()='COMPOSE']"));
		composeBtn.click();
		driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();
		RunAutoIt();
		
	}
	
	/*@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}*/

}
