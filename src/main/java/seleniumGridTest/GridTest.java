package seleniumGridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridTest {

	/*
	 * To get the HUB server up and running use the below command: 
	 * java -jar selenium-server-standalone-3.14.0.jar -role hub 
	 * To get the NODE server up and running use the below command:
	 *  java -Dwebdriver.chrome.driver="C:\Program Files\selenium server\chromedriver.exe" -jar selenium-server-standalone-3.14.0.jar -role node -hub http://192.168.234.1:4444/grid/register/
	 *
	 * dont forget to put the webdrivers of all the browsers you want to launch in the folder where selenium grid jar file is
	 */

	@Test
	@Parameters("browser")
	
	public void seleniumGridTest(String browser) throws MalformedURLException, InterruptedException {
		if(browser.equalsIgnoreCase("chrome")){
		// define desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);

		// chrome options definitions
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);

		String hubUrl = "http://192.168.234.1:4443/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl), cap);
		driver.get("http://demo.guru99.com/V4/");
		//Find user name
		WebElement userName = driver.findElement(By.name("uid"));
		//Fill user name
		userName.sendKeys("guru99");
		//Find password
		WebElement password = driver.findElement(By.name("password"));
		//Fill password
		password.sendKeys("guru99");
		Thread.sleep(5000);
		System.out.println(driver.getTitle()+"in chrome");
		driver.quit();
		}
	
		else if(browser.equalsIgnoreCase("Firefox")){
		
		DesiredCapabilities capability = DesiredCapabilities.firefox(); 
		WebDriver  driver1 = new RemoteWebDriver(new URL("http://192.168.234.1:4443/wd/hub"), capability);   
		driver1.get("http://demo.guru99.com/V4/");
		//Find user name
		WebElement userName = driver1.findElement(By.name("uid"));
		//Fill user name
		userName.sendKeys("guru99");
		//Find password
		WebElement password = driver1.findElement(By.name("password"));
		//Fill password
		password.sendKeys("guru99");
		System.out.println(driver1.getTitle()+"in firefox");
		driver1.quit();
		}
		}
	}
