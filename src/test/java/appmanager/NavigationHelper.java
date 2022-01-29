package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void goToControlPanel() {
    click(By.linkText("Главная"));
  }

  public void goToCreateEntry() {
    click(By.xpath("//div[@id='module_2']/div/ul/li/ul/li/a/span"));
  }

  public void goToChangeEntry() {
    click(By.xpath("//div[@id='module_2']/div/ul/li/ul/li[2]/a/span"));
  }

  public void goToBlog() {
    click(By.linkText("Blog"));
  }

  public void logout() {
    click(By.linkText("Выйти"));
  }
}
