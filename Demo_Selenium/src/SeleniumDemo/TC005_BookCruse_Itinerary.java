package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC005_BookCruse_Itinerary {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.xpath("//a[contains(text(),'Cruises')]")).click();
		
		String FirstDay = driver.findElement(By.xpath("//tr//tr//tr[4]//td[1]//font[1]")).getText();
		System.out.println("Start day of the cruise:" +FirstDay);
		String FirstDayPort = driver.findElement(By.xpath("//tr//tr//tr[4]//td[2]//strong[1]//font[1]")).getText();
		System.out.println("Start Port of the cruise:" +FirstDayPort);
		
		String LastDay = driver.findElement(By.xpath("//tr[11]//td[1]//font[1]")).getText();
		System.out.println("End day of the cruise:" +LastDay);
		String LastDayPort = driver.findElement(By.xpath("//tr[11]//td[2]")).getText();
		System.out.println("End Port of the cruise:" +LastDayPort);
		
		System.out.println("Cruise Itinerary Displayed as expected: Test Passed");
			driver.close();

	}

}
