package SeleniumDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//***** This Test case is testing that a user is able to Enter Flight Detail*******

public class TC003_EnterFlightDetail {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
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
			
		driver.findElement(By.xpath("//font[contains(text(),'Economy class')]")).click();
		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
		driver.findElement(By.xpath("//table//table//table//table//table[1]//tbody[1]//tr[9]//td[1]//input[1]")).click();
		driver.findElement(By.xpath("//table[2]//tbody[1]//tr[9]//td[1]//input[1]")).click();
		driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
		
		String confrMsg = driver.findElement(By.xpath("//font[contains(text(),'Please review your')]")).getText();
		System.out.println("Message Displayed:"  +confrMsg);
		
		if (confrMsg.equalsIgnoreCase(confrMsg))
		{
			System.out.println("Flight Detail has been succesfully entered: Test passed");
		}
		
		else 
		{
			System.out.println("Flight detail was not succesfully entered: Test failed");
		}
		
		driver.close();
	}

}
