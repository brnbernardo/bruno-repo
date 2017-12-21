import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChromeBrowser {

	static String driverPath = "d:/";
	public static WebDriver driver;

	public static void main(String[] args) {
		setUp();
		testGooglePageTitleInIEBrowser();
		tearDown();
	}

	@BeforeClass
	public static void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public static void testGooglePageTitleInIEBrowser() {
		driver.navigate().to("http://www.google.com");
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - " + strPageTitle);
		Assertions.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}

	@AfterClass
	public static void tearDown() {
		if (driver != null) {
			System.out.println("Closing chrome browser");
			driver.quit();
		}
	}

}