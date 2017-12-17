package ru.qa.rtsoft.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.lanwen.verbalregex.VerbalExpression;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

  public static WebDriver driver;
  public static WebDriverWait wait;

  public boolean isElementPresent(By locator) {
    try {
//      wait.until((WebDriver d) -> d.findElement(locator)); // явное ожидание элемента locator
      driver.findElement(locator); // при неявном ожидании
      return true;
    }
        catch (NoSuchElementException ex) { // при неявном ожидании
//      catch (TimeoutException ex){ // в случае явного ожидания функция until может вызвать TimeoutException
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
  public void start() {
    if (driver != null) {
      return;
    }
    // инициализация Chrome
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized").addArguments("disable-infobars");
    driver = new ChromeDriver(options);

//    инициализация Firefox
//    driver = new FirefoxDriver();
//    driver.manage().window().maximize();

    // инициализация Firefox ESR
//    FirefoxOptions options = new FirefoxOptions().setLegacy(true).setBinary("c:\\Program Files\\Mozilla Firefox ESR\\firefox.exe");
//    driver = new FirefoxDriver(options);
//    driver.manage().window().maximize();

//     инициализация InternetExplorer
//    driver = new InternetExplorerDriver();




    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //неявное ожидание
    wait = new WebDriverWait(driver, 10);
  }


  @After
  public void stop() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }

  protected List<String> parsingColorRGBA(String color) {
    // in list colors are enumerated: r(red), g(green), b(blue), a(alpha)
    List<String> colorRGBA = new ArrayList<>();
    VerbalExpression regex = VerbalExpression.regex().find("(")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .build();
    String r = regex.getText(color, 1);
    String g = regex.getText(color, 2);
    String b = regex.getText(color, 3);
    String a = regex.getText(color, 4);
    colorRGBA.add(r);
    colorRGBA.add(g);
    colorRGBA.add(b);
    colorRGBA.add(a);
    return colorRGBA;
  }

  protected List<String> parsingColorRGB(String color) {
    // in list colors are enumerated: r(red), g(green), b(blue)
    List<String> colorRGB = new ArrayList<>();
    VerbalExpression regex = VerbalExpression.regex().find("(")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .build();
    String r = regex.getText(color, 1);
    String g = regex.getText(color, 2);
    String b = regex.getText(color, 3);
    colorRGB.add(r);
    colorRGB.add(g);
    colorRGB.add(b);
    return colorRGB;
  }

}
