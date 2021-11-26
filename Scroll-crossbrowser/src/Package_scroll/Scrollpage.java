package Package_scroll;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;





public class Scrollpage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) { 
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			}
		
	}
	@Test
	public void test1() throws Exception {
	driver.get("https://freecrm.com/");
	Thread.sleep(5000);
	}	
	@Test (dependsOnMethods = "test1")
	public void Scrolldown_bottom() throws Exception
	{
		//scroll down by 500 pixels with Javascript Executor
	    JavascriptExecutor j = (JavascriptExecutor) driver;
	      j.executeScript("window.scrollBy(0,5000)");
	      Thread.sleep(5000);
	}
	      @Test (dependsOnMethods = "Scrolldown_bottom")
	      public void twitter() throws Exception {
	    	  WebElement twitter = driver.findElement(By.xpath("//div//a[@href='https://twitter.com/cogmento']"));
	    	  twitter.click();

	    	  Thread.sleep(6000);
	    } 
	      @Test (dependsOnMethods = "twitter")
	      public void facebook() throws Exception
	      {
	      WebElement facebook = driver.findElement(By.xpath("//div//a[@href='https://www.facebook.com/cogmento']"));
	      facebook.click();
	      Thread.sleep(3000);
	      }
	      @Test (dependsOnMethods = "facebook")
	      public void github() throws Exception
	      {
	      WebElement github = driver.findElement(By.xpath("//div//a[@href='https://github.com/cogmento']"));
	      github.click();
	      Thread.sleep(3000);
	      }
	      @Test (dependsOnMethods = "github")
	      public void paperplane() throws Exception
	      {
	      WebElement paperplane = driver.findElement(By.xpath("//div//a[@href='https://t.me/cogmento']"));
	      paperplane.click();
	      Thread.sleep(3000);
	      }
	@AfterTest
	public void finish() {
	driver.quit();
	System.out.println("Test is successful");
	}
}


