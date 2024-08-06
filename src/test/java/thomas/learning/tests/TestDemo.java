package thomas.learning.tests;

import org.testng.annotations.Test;
import thomas.learning.pageObjects.LoginPage;
import thomas.learning.pageObjects.RegisterPage;
import thomas.learning.testComponents.TestBase;

public class TestDemo extends TestBase {



  @Test
  public void register() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.goTo();

    RegisterPage registerPage = loginPage.clickNewUserButton();
    registerPage.registerNewUser("Phong", "Hoang", "userName1111", "Test@12345");

    loginPage = registerPage.gotoLogin();
    loginPage.login("userName1111", "Test@12345");

  }

}
