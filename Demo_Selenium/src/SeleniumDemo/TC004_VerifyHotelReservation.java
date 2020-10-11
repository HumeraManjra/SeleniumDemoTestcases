package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC004_VerifyHotelReservation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.xpath("//a[contains(text(),'Hotels')]")).click();
			
		String ActMessgae = driver.findElement(By.xpath("//body/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/p/font/b/font[1]")).getText();
		System.out.println(ActMessgae);
		
		if (ActMessgae.contains("This section of our web site is currently under construction."))
		{
			System.out.println("A User can not Reserve a Hotel: Test Passed");
		}
		
		else
		{
			System.out.println("Page under Construction Msg did not display: Test Failed");
		}
		
			driver.close();

	}

}
