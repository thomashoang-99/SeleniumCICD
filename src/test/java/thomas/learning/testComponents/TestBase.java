package thomas.learning.testComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import thomas.learning.utils.DriverFactory;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

  public WebDriver driver;

  private WebDriver initialization() {
    WebDriver driver = null;

    Properties prop = new Properties();
    String propertiesFileName = "data.properties";
    try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFileName)) {
      if (input == null) {
        throw new RuntimeException("Sorry, unable to find " + propertiesFileName);
      }
      prop.load(input);
    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException("Failed to load configuration properties.");
    }

    String browser = prop.getProperty("browser");
    if (browser.equalsIgnoreCase("chrome")) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      driver = new ChromeDriver(options);
    } else if (browser.equalsIgnoreCase("firefox")){
      WebDriverManager.firefoxdriver().setup();
      FirefoxOptions fOptions = new FirefoxOptions();
      driver = new FirefoxDriver(fOptions);
    } else if (browser.equalsIgnoreCase("edge")) {
      WebDriverManager.edgedriver().setup();
      EdgeOptions edgeOptions = new EdgeOptions();
      driver = new EdgeDriver(edgeOptions);
    }
    return driver;

  }

  @BeforeTest
  public void setup() {

    DriverFactory.getInstance().setDriver(initialization());
    driver = DriverFactory.getInstance().getDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  }


  @AfterTest(alwaysRun = true)
  public void tearDown() {
    DriverFactory.getInstance().closeBrowser();
  }

}
