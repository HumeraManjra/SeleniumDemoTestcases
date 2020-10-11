package SeleniumDemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//***** This Test case is testing that a user is able to Login*******

public class TC001_LogIn {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		boolean LOGOFF;
		LOGOFF = driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).isDisplayed();
		
		if (LOGOFF==true)
		{
			System.out.println("Login Suceess: Test Passed");
		}
		
		else 
		{
			System.out.println("Login Failed: Test Failed");
		}
		
		driver.close();

	}
}
