package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//***** This Test case is testing that a user is able to Book Two ways Flight*******

public class TC002_BookTwoWayFlight {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\humer\\eclipse-workspace\\Drivers\\Driver\\chromedriver.exe");
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
			System.out.println("Login Suceess and Flight Finder Page displayed: Test Passed");
		}
		
		else 
		{
			System.out.println("Login Failed Flight finder page did not display: Test Failed");
		}
		
		driver.findElement(By.xpath("//body//b//input[1]")).click();
		
		Select Passengers = new Select (driver.findElement(By.xpath("//select[@name='passCount']")));
		Passengers.selectByIndex(1);	
		
		Select DepartingFrom = new Select (driver.findElement(By.name("fromPort")));
		DepartingFrom.selectByIndex(2);	
		
		Select fromMonth = new Select (driver.findElement(By.name("fromMonth")));		
		fromMonth.selectByVisibleText("May");	
		
		Select fromDay = new Select (driver.findElement(By.name("fromDay")));		
		fromDay.selectByValue("13");	
		
		Select toPort = new Select (driver.findElement(By.name("toPort")));		
		toPort.selectByIndex(3);		
		
		Select toMonth = new Select (driver.findElement(By.name("toMonth")));		
		toMonth.selectByVisibleText("May");		
		
		Select toDay = new Select (driver.findElement(By.name("toDay")));
		toDay.selectByValue("20");
			
		driver.findElement
		(By.xpath("/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[5]/td[1]/form[1]/table[1]/tbody[1]/tr[9]/td[2]/font[1]/font[1]")).click();

		
	}

}
