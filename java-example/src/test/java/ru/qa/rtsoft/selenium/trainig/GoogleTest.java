package ru.qa.rtsoft.selenium.trainig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class GoogleTest {

  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){

    /*ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    driver = new ChromeDriver(options);*/

    //DesiredCapabilities caps = new DesiredCapabilities();
    //caps.setCapability("unexpectedAlertBehaviour", "dismiss");
    //driver = new EdgeDriver(caps);
    //System.out.println(((HasCapabilities) driver).getCapabilities());

    FirefoxOptions options = new FirefoxOptions().setLegacy(true).setBinary("c:\\Program Files\\Mozilla Firefox ESR\\firefox.exe");
    driver = new FirefoxDriver(options);

    /*DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(FirefoxDriver.MARIONETTE, false);
    driver = new FirefoxDriver(new FirefoxBinary(new File("\"C:\\Program Files\\Mozilla Firefox ESR\\firefox.exe\"")), new FirefoxProfile(), caps);
    System.out.println(((HasCapabilities) driver).getCapabilities());*/

    //driver = new ChromeDriver();
    //driver = new FirefoxDriver();
    //driver = new EdgeDriver();
    //driver = new InternetExplorerDriver();
    //driver = new OperaDriver();
    //driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void googleTest(){
    driver.get("http://www.google.com");
    //driver.findElement(By.name("q")).sendKeys("webdriver");
    //driver.findElement(By.name("btnK")).click();
    //driver.findElement(By.name("q")).sendKeys(Keys.ENTER); //нечестно, заходим по Enter
    //driver.findElement(By.xpath("//div[@class='jsb']/center/input[@value='Поиск в Google']")).click();
    //driver.findElement(By.cssSelector("form[class='tsf'] input[name='btnK']")).click();
    //driver.findElement(By.xpath("//form[@id='tsf']/div[2]/div[3]/center/input")).click(); //ура
    //wait.until(titleIs("webdriver - Поиск в Google"));
  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
