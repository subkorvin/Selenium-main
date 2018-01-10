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
  private WebDriverWait wait;

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





  public void removeFromCard(List<WebElement> checkoutElements) {
    for (int i = 1; i <= checkoutElements.size(); i++) {
      clickToStop(checkoutElements, i);
      String contentFromArticle = driver.findElement(By.cssSelector("#checkout-cart-wrapper li:first-child form[name='cart_form']")).getAttribute("textContent");
      VerbalExpression regex = VerbalExpression.regex().capture().find("RD").digit().count(3).endCapture().build();
      String sku = regex.getText(contentFromArticle);
      String locator = "//table[@class='dataTable rounded-corners']//td[contains(., '" + sku + "')]";
      WebElement tableSku = driver.findElement(By.xpath(locator));
      driver.findElement(By.cssSelector("#box-checkout-cart button[name='remove_cart_item']")).click();
      wait.until(ExpectedConditions.stalenessOf(tableSku));
    }
  }

  public void clickToStop(List<WebElement> checkoutElements, int i) {
    if (i < checkoutElements.size()) {
      driver.findElement(By.cssSelector("#box-checkout-cart .shortcuts li:first-child")).click();
    }
  }

  public List<WebElement> getCardItems() {
    return driver.findElements(By.cssSelector("#box-checkout-cart .item"));
  }

  public void goToMainPage() {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  //неявное ожидание в ноль
    driver.navigate().to("http://localhost:8080/litecart");
  }

  public int getInitialQuantity() {
    return Integer.parseInt(driver.findElement(By.cssSelector("#cart .quantity")).getAttribute("textContent"));
  }

  public void addToCard(int initialQuantity, int i) {
    if (isElementPresentExplicit(By.cssSelector(".buy_now select"))) {
      WebElement size = driver.findElement(By.cssSelector(".buy_now select[name='options[Size]']"));
      Select sizeSelect = new Select(size);
      sizeSelect.selectByValue("Large");
    }
    driver.findElement(By.cssSelector(".content button[name='add_cart_product']")).click();
    int quantity = initialQuantity + i;
    wait.until(ExpectedConditions.attributeToBe(By.cssSelector("#cart .quantity"), "textContent", String.valueOf(quantity)));
    driver.navigate().back();
  }

  public void leaveMainPage() {
    driver.findElement(By.cssSelector(".content #box-most-popular li:first-child a[class='link']")).click();
  }

  public void goToBasket() {
    driver.findElement(By.cssSelector("#cart a[class='link']")).click();
  }

}
