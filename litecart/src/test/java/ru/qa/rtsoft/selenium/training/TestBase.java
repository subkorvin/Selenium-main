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
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.lanwen.verbalregex.VerbalExpression;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class TestBase {

public Application app = new Application();

  @Before
  public void start(){
    if (app.driver != null) {
      return;
    }

//    // инициализация Chrome
//
////    DesiredCapabilities caps = DesiredCapabilities.chrome();
////    LoggingPreferences logPrefs = new LoggingPreferences();
////    logPrefs.enable(LogType.BROWSER, Level.ALL);
////    caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("start-maximized").addArguments("disable-infobars");
////    caps.setCapability(ChromeOptions.CAPABILITY, options);
//    driver = new ChromeDriver(options);
//
////    инициализация Firefox
////    driver = new FirefoxDriver();
////    driver.manage().window().maximize();
//
//    // инициализация Firefox ESR
////    FirefoxOptions options = new FirefoxOptions().setLegacy(true).setBinary("c:\\Program Files\\Mozilla Firefox ESR\\firefox.exe");
////    driver = new FirefoxDriver(options);
////    driver.manage().window().maximize();
//
////     инициализация InternetExplorer
////    driver = new InternetExplorerDriver();
//
//    // инициализация Edge
////    driver = new EdgeDriver();
////    driver.manage().window().maximize();
//
//
//
//    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //неявное ожидание
//    wait = new WebDriverWait(driver, 3); // тайм-аут явного ожидания
  }


  @After
  public void stop() {
    if (app.driver != null) {
      app.driver.quit();
      app.driver = null;
    }
  }

//  protected List<String> parsingColorRGBA(String color) {
//    // in list colors are enumerated: r(red), g(green), b(blue), a(alpha)
//    List<String> colorRGBA = new ArrayList<>();
//    VerbalExpression regex = VerbalExpression.regex().find("(")
//            .capture().digit().count(0, 3).endCapture()
//            .then(", ")
//            .capture().digit().count(0, 3).endCapture()
//            .then(", ")
//            .capture().digit().count(0, 3).endCapture()
//            .then(", ")
//            .capture().digit().count(0, 3).endCapture()
//            .build();
//    String r = regex.getText(color, 1);
//    String g = regex.getText(color, 2);
//    String b = regex.getText(color, 3);
//    String a = regex.getText(color, 4);
//    colorRGBA.add(r);
//    colorRGBA.add(g);
//    colorRGBA.add(b);
//    colorRGBA.add(a);
//    return colorRGBA;
//  }
//
//  protected List<String> parsingColorRGB(String color) {
//    // in list colors are enumerated: r(red), g(green), b(blue)
//    List<String> colorRGB = new ArrayList<>();
//    VerbalExpression regex = VerbalExpression.regex().find("(")
//            .capture().digit().count(0, 3).endCapture()
//            .then(", ")
//            .capture().digit().count(0, 3).endCapture()
//            .then(", ")
//            .capture().digit().count(0, 3).endCapture()
//            .build();
//    String r = regex.getText(color, 1);
//    String g = regex.getText(color, 2);
//    String b = regex.getText(color, 3);
//    colorRGB.add(r);
//    colorRGB.add(g);
//    colorRGB.add(b);
//    return colorRGB;
//  }

}
