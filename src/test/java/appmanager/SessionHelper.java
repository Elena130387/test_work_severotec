package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver driver) {
    super(driver);
  }
  public void login(String username, String userpassword) {
    type(By.id("id_username"), username);
    type(By.id("id_password"), userpassword);
    click(By.xpath("//input[@value='Войти']"));
  }
}
