package appmanager;

import model.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EntryHelper extends HelperBase {

  public EntryHelper(WebDriver driver) {
    super(driver);
  }

  public void deleteEntry() {
    click(By.name("_selected_action"));
    click(By.name("action"));
    new Select(driver.findElement(By.name("action"))).selectByVisibleText("Удалить выбранные Entries");
    click(By.name("index"));
    click(By.xpath("//input[@value='Да, я уверен']"));
  }

  public void createEntry(Entry entry) {
    type(By.id("id_title"), entry.getTitle());
    type(By.id("id_slug"), entry.getSlug());
    type(By.id("id_text_markdown"), entry.getText_markdown());
    type(By.id("id_text"), entry.getText());
    click(By.name("_save"));
  }
}
