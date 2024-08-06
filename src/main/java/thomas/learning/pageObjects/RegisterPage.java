package thomas.learning.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import thomas.learning.abstractComponents.AbstractComponent;

public class RegisterPage extends AbstractComponent {

  WebDriver driver;
  public RegisterPage(WebDriver driver) {
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "firstName")
  WebElement txtFirstName;

  @FindBy(id = "lastname")
  WebElement txtLastName;

  @FindBy(id = "userName")
  WebElement txtUserName;

  @FindBy(id = "password")
  WebElement txtPassword;

  @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
  WebElement iframeCaptcha;

  @FindBy(id = "recaptcha-anchor")
  WebElement chkCaptcha;

  @FindBy(id = "register")
  WebElement btnRegister;

  @FindBy(id = "gotologin")
  WebElement btnBackLogin;

  private void checkCaptcha() {
    driver.switchTo().frame(iframeCaptcha);
    chkCaptcha.click();
    driver.switchTo().defaultContent();
  }

  public void registerNewUser(String firstName, String lastName, String userName, String password) {
    waitElementPresent(txtFirstName);
    scrollElement(txtFirstName);
    txtFirstName.sendKeys(firstName);
    txtLastName.sendKeys(lastName);
    txtUserName.sendKeys(userName);
    txtPassword.sendKeys(password);
    checkCaptcha();
    scrollElement(btnRegister);
    btnRegister.click();
    submitAlert();
  }

  public LoginPage gotoLogin() {
    scrollElement(btnBackLogin);
    btnBackLogin.click();
    return new LoginPage(driver);
  }




}
