package Miniproj_multibrow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Miniproj_edge_FF {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browsern) { 
		if (browsern.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			} else if (browsern.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath+"/Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			}
	}
// Launching url in chrome browser
		@Test
		public void launchapp() throws Exception {
		driver.get("https://pega-86-demo.iqzsystems.io/prweb/app/default/b0aUC_g2NnC90uEC3dhEbKXJdQTMkXeP*/!STANDARD");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
// Entering username
		@Test (dependsOnMethods = "launchapp")
		public void enteruser() throws Exception
		{
		WebElement username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
		username.sendKeys("tcapron");
		}
	// Entering password
		@Test (dependsOnMethods = "enteruser")
		public void enterpswd() throws Exception
		{
		WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		password.sendKeys("rules@123");
		}
	//Clicking Login button
		@Test (dependsOnMethods = "enterpswd")
		public void clicklogin() throws Exception
		{
		WebElement loginbutton = driver.findElement(By.xpath("//button[@id='sub']"));
		loginbutton.click();
		}
	//Clicking Plus icon
		@Test (dependsOnMethods = "clicklogin")
		public void clickplusicon() throws Exception
		{
		WebElement menuitem = driver.findElement(By.xpath("(//span[contains(@role,'presentation')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", menuitem);
		WebElement individuallead = driver.findElement(By.xpath("(//a[contains(@role,'menuitem')])[7]"));
		individuallead.click();
	// Entering Details in Fields
		WebElement firstname = driver.findElement(By.xpath("//input[@id='546ad300']"));
		firstname.sendKeys("Mathan");
		WebElement lastname = driver.findElement(By.xpath("//input[@id='6e54da89']"));
		lastname.sendKeys("IQZ");
	//Clicking Submit button
		WebElement submitbutton = driver.findElement(By.xpath("//button[@title='Complete this assignment']"));
		submitbutton.click();
		System.out.println("Individual Lead created successfully");
		}
	//Clicking Edit lead button
		@Test (dependsOnMethods = "clickplusicon")
		public void editlead() throws Exception
		{
		WebElement editbtn = driver.findElement(By.xpath("(//button[contains(@title,'Edit')][normalize-space()='Edit'])[2]"));
		editbtn.click();
	// Clearing the old ones and entering new values
		WebElement editfirstname = driver.findElement(By.xpath("//input[@id='546ad300']"));
		editfirstname.clear();
		editfirstname.sendKeys("math");
		WebElement editlastname = driver.findElement(By.xpath("//input[@id='6e54da89']"));
		editlastname.clear();
		editlastname.sendKeys("tester");
	// Clicking submit button after editing the details
		WebElement sbtbutton = driver.findElement(By.xpath("//button[@title='Complete this assignment']"));
		sbtbutton.click();
		Thread.sleep(5000);
		//System.out.println("Individual Lead is edited successfully");
		}
	// Clicking on Convert lead
		@Test (dependsOnMethods ="editlead")
		public void convertlead() throws Exception
		{
		WebElement actions = driver.findElement(By.xpath("(//button[contains(@title,'Actions')][normalize-space()='Actions'])[2]"));
		actions.click();
		WebElement cnvtlead = driver.findElement(By.xpath("//span[contains(text(),'Convert lead')]"));
		cnvtlead.click();
	// Entering details in Convert lead fields
		WebElement opportname = driver.findElement(By.xpath("(//input[@id='8dcd183b'])[1]"));
		opportname.sendKeys("rules@123");
		WebElement ammount = driver.findElement(By.xpath("(//input[@id='1dfe6fd2'])[1]"));
		ammount.sendKeys("100");
		WebElement datepicker = driver.findElement(By.xpath("(//input[@id='c0445fa3'])[1]"));
		datepicker.click();
		datepicker.sendKeys("1/27/2022");
	// Clicking submit button in Convert lead fields
		WebElement sbtbuttonclick = driver.findElement(By.xpath("//button[@title='Complete this assignment']"));
		sbtbuttonclick.click();
		Thread.sleep(10000);
		System.out.println("Converted a lead successfully");
		}
	//All the testcases are completed
		@AfterTest
		public void finish() {
		driver.quit();
		System.out.println("Test is successfull");
		}
			
	}


