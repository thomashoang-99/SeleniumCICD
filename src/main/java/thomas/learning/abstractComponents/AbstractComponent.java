package thomas.learning.abstractComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

  WebDriver driver;

  public AbstractComponent(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void submitAlert() {
    driver.switchTo().alert().accept();
  }

  public void scrollElement(WebElement ele) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", ele);
  }

  public void waitElementPresent(WebElement ele) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.invisibilityOf(ele));
  }

}
