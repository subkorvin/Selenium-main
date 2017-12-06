package ru.qa.rtsoft.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

  public WebDriver driver;
  public WebDriverWait wait;

  public boolean isElementPresent (By locator){
    try {
      //wait.until((WebDriver d) -> d.findElement(locator)); // явное ожидание элемента locator
      driver.findElement(locator); // при неявном ожидании
      return true;
    } catch (NoSuchElementException ex){ // при неявном ожидании
      //catch (TimeoutException ex){ // в случае явного ожидания функция until может вызвать TimeoutException
      return false;
    }
  }

  public boolean areElementsPresent (By locator){
    try {
      return driver.findElements(locator).size() > 0;
    } catch (InvalidSelectorException ex){
      return false;
    }
  }

  @Before
  public void start(){
    // инициализация Chrome
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized").addArguments("disable-infobars");
    driver = new ChromeDriver(options);

    // инициализация Firefox по-новому
    //driver = new FirefoxDriver();

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //неявное ожидание
    wait = new WebDriverWait(driver, 10);
  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
