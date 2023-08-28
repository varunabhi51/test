package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	static {

		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/eve.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
   @Before
	public void setup() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
  @After
	public void teardown(Scenario s) throws IOException {
		if (s.isFailed()) {
			TakesScreenshot t = (TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("Screenshots/"+s.getName()+"test.png"));
			driver.quit();

		}
	}

	// Generic method for dropdown
	public void selectByvisibleText(WebElement ele, String Value) {
		Select s = new Select(ele);
		s.selectByVisibleText(Value);

	}

	public void selecyByvisibileIndex(WebElement ele, int value) {
		Select s = new Select(ele);
		s.selectByIndex(value);

	}

	public void selectByValue(WebElement ele, String Value) {

		Select s = new Select(ele);
		s.selectByValue(Value);
	}

	// mouse hover

	public void mouseHover(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();
	}

	public WebElement waitForExpectedElement(By by) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public void waitToBeClickable(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.elementToBeClickable(ele));

	}

	// java script executor
	public void clickByExecutor(WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

	}

	// Alert
	public void PopAlert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public void takescreenshot() throws IOException {
		
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("Screenshots/"+System.currentTimeMillis()+"test.png"));
		

	}
}
