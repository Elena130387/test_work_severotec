package appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private NavigationHelper navigationHelper;
  public WebDriver driver;
  public final Properties properties;
  private EntryHelper entryHelper;
  private String browser;
  private SessionHelper sessionHelper;
  private JavascriptExecutor js;

  public ApplicationManager(String browser)  {
    this.browser = browser;
    properties = new Properties();
  }


  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    if (browser.equals(BrowserType.FIREFOX)) {
        driver = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
        driver = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)) {
        driver = new InternetExplorerDriver();
    }

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
    driver.get(properties.getProperty("web.baseUrl"));
    sessionHelper = new SessionHelper(driver);
    entryHelper = new EntryHelper(driver);
    navigationHelper = new NavigationHelper(driver);
  }

  public void stop() {
    driver.quit();
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public EntryHelper getEntryHelper() {
    return entryHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
