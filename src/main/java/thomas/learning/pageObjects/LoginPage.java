package thomas.learning.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import thomas.learning.abstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {

  WebDriver driver;
  public LoginPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "newUser")
  WebElement btnNewUser;

  @FindBy(id = "userName")
  WebElement txtUserName;

  @FindBy(id = "password")
  WebElement txtPassword;

  @FindBy(id="login")
  WebElement btnLogin;

  public void goTo() {
    driver.get("https://demoqa.com/login");
  }

  public RegisterPage clickNewUserButton() {
    scrollElement(btnNewUser);
    btnNewUser.click();
    return new RegisterPage(driver);
  }

  public void login (String userName, String password) {
    txtUserName.sendKeys(userName);
    txtPassword.sendKeys(password);
    btnLogin.click();
  }

}
