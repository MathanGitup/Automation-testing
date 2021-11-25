package Packagedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossbrowser {
	WebDriver driver;
		String projectPath = System.getProperty("user.dir");
		@Parameters("browsern")
		@BeforeTest
		public void setup(String browsern) { 
			if (browsern.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
				} else if (browsern.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", projectPath+"/Drivers/msedgedriver.exe");
				driver = new EdgeDriver();
				}
			
		}
		@Test
		public void test1() throws Exception {
		driver.get("https://google.com");
		Thread.sleep(10000);
		}	
		@Test
		public void test2() throws Exception {
		driver.get("https://yahoo.com");
		Thread.sleep(10000);
		}	
		@AfterTest
		public void finish() {
		driver.quit();
		System.out.println("Test is successful");
		}
	}