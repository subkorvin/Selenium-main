package ru.qa.rtsoft.selenium.trainig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class GoogleTest {

  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
    //driver = new ChromeDriver();
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void googleTest(){
    driver.get("http://www.google.com");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("btnK")).click();
    //driver.findElement(By.xpath("//div[@class='jsb']/center/input[@value='Поиск в Google']")).click();
    //driver.findElement(By.cssSelector("form[class='tsf'] input[name='btnK']")).click();
    //driver.findElement(By.xpath("//input[@name='btnK']")).click();
    wait.until(titleIs("webdriver - Поиск в Google"));
  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
