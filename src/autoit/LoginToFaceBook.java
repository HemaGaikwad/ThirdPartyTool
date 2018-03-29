package autoit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginToFaceBook 
{
	public WebDriver driver = null;
	public static  String Chrome_Key="webdriver.chrome.driver";
	public static String Chrome_Value = "D:\\Edureka_March\\ThirdPartyToolsDemo\\Drivers\\chromedriver.exe";
	public WebDriverWait wait = null;
	
	@BeforeMethod
	public void precondition()
	{
		System.setProperty(Chrome_Key, Chrome_Value);
		driver= new ChromeDriver();
		driver.get("https://www.facebook.com");
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginToFacebook() throws FindFailed
	{
		Screen screen = new Screen();
		Pattern username = new Pattern("D:\\Edureka_Files\\Username.png");
		Pattern password = new Pattern("D:\\Edureka_Files\\Password.png");
		Pattern loginBtn = new Pattern("D:\\Edureka_Files\\LoginBtn.png");
		
		screen.wait(username,10);
		screen.type(username,"edureka");
		screen.type(password, "edureka");
		screen.click(loginBtn);
		
	}
	

}
