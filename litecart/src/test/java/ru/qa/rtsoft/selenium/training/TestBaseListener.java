package ru.qa.rtsoft.selenium.training;

import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBaseListener {

  public static EventFiringWebDriver driver;
  public static WebDriverWait wait;

  public static class MyListener extends AbstractWebDriverEventListener{
    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
      File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      File screen = new File("screen-" + System.currentTimeMillis() + ".png");
      try {
        Files.copy(tmp, screen);
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println(screen);
    }
  }

  public boolean isElementPresent(By locator) { // функция наличия элемента при использовании неявного ожидания
    try {
      driver.findElement(locator);
      return true;
    }
    catch (NoSuchElementException ex) {
      return false;
    }
  }

  public boolean isElementPresentExplicit(By locator) {  //функция наличия элемента при использовании явного ожидания локатора
    try {
      wait.until((WebDriver d) -> d.findElement(locator));
      return true;
    }
    catch (TimeoutException ex){
      return false;
    }
  }

  public boolean areElementsPresent(By locator) {
    try {
      return driver.findElements(locator).size() > 0;
    } catch (InvalidSelectorException ex) {
      return false;
    }
  }

  @Before
  public void start(){
    if (driver != null) {
      return;
    }

    // инициализация Chrome
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized").addArguments("disable-infobars");
    driver = new EventFiringWebDriver(new ChromeDriver(options));
    driver.register(new MyListener());

//    инициализация Firefox
//    driver = new FirefoxDriver();
//    driver.manage().window().maximize();

    // инициализация Firefox ESR
//    FirefoxOptions options = new FirefoxOptions().setLegacy(true).setBinary("c:\\Program Files\\Mozilla Firefox ESR\\firefox.exe");
//    driver = new FirefoxDriver(options);
//    driver.manage().window().maximize();

//     инициализация InternetExplorer
//    driver = new InternetExplorerDriver();

    // инициализация Edge
//    driver = new EdgeDriver();
//    driver.manage().window().maximize();



    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //неявное ожидание
    wait = new WebDriverWait(driver, 3); // тайм-аут явного ожидания
  }


  @After
  public void stop() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
