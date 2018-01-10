package ru.qa.rtsoft.selenium.training;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.lanwen.verbalregex.VerbalExpression;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Application {

  public WebDriver driver;
  public WebDriverWait wait;

  private MainPage mainPage;
  private ArticlePage articlePage;
  private CardPage cardPage;

  public Application() {
    // инициализация Chrome

    DesiredCapabilities caps = DesiredCapabilities.chrome();
    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.BROWSER, Level.ALL);
    caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized").addArguments("disable-infobars");
    caps.setCapability(ChromeOptions.CAPABILITY, options);
    driver = new ChromeDriver(options);
    mainPage = new MainPage(driver);
    articlePage = new ArticlePage(driver);
    cardPage = new CardPage(driver);
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

  public void quit(){
    driver.quit();
  }

  public void addingToCard() {
    mainPage.open();
    int initialQuantity = mainPage.getInitialQuantity();
    for (int i = initialQuantity + 1; i < 4; i++) {
      articlePage.goToArticle();
      articlePage.addToCard(initialQuantity, i);
    }
    mainPage.goToBasket();
  }

  public void removingFromCard() {
    List<WebElement> checkoutElements = cardPage.getCardItems();
    cardPage.removeFromCard(checkoutElements);
  }

  public boolean isElementPresent(By locator) { // функция наличия элемента при использовании неявного ожидания
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public boolean isElementPresentExplicit(By locator) {  //функция наличия элемента при использовании явного ожидания локатора
    try {
      wait.until((WebDriver d) -> d.findElement(locator));
      return true;
    } catch (TimeoutException ex) {
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

}
