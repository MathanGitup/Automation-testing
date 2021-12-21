package Windows_Auth;
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

public class windows_auth_popup {
	
	public static void main(String[] args) {
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://the-internet.herokuapp.com/digest_auth");
	driver.get("http://admin:admin@the-internet.herokuapp.com/digest_auth");
	}
}


