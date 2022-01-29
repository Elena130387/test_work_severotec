package tests;

import model.Entry;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

public class TestCase extends TestBase {

  @Test
  public void testEntry() throws Exception {
    app.getSessionHelper().login(app.properties.getProperty("web.userLogin"), app.properties.getProperty("web.userPassword"));
    assertTrue(app.driver.getTitle().contains("Панель управления"));
    app.getNavigationHelper().goToCreateEntry();
    assertTrue(app.driver.getTitle().contains("Добавить entry"));
    app.getEntryHelper().createEntry(new Entry("Title43565463456","Slug43565463456", "Slug43565463456",
            ": Slug43565463456" ));
    app.getNavigationHelper().goToBlog();
    assertTrue(app.driver.findElement(By.linkText("Entry Title43565463456")).isDisplayed());
    app.getNavigationHelper().goToControlPanel();
    app.getNavigationHelper().goToChangeEntry();
    app.getEntryHelper().deleteEntry();
    app.getNavigationHelper().logout();
  }
}

