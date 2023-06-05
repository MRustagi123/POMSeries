package galentic.test.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import galentic.test.opencart.factory.Driverfactory;
import galentic.test.opencart.pages.AccountsPage;
import galentic.test.opencart.pages.LoginPage;
import galentic.test.opencart.pages.ProductInfoPage;
import galentic.test.opencart.pages.ResultsPage;

public class BaseTest {

	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected ResultsPage resultsPage;
	protected ProductInfoPage productInfoPage;

	protected Driverfactory df;
	protected Properties prop;
	
	@BeforeTest
	public void setup() {
		df = new Driverfactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		
		loginPage = new LoginPage(driver);
		//dologin
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}




