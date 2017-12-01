package ru.qa.rtsoft.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdminLoginTest {

  private WebDriver driver;

  @Before
  public void start(){
    driver = new ChromeDriver();
    //driver = new FirefoxDriver();
    driver.manage().window().maximize();
  }

  @Test
  public void adminLoginTest() throws InterruptedException {
    driver.navigate().to("http://localhost:8080/litecart/admin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    Thread.sleep(10000); // пока без проверок для визуального контроля
  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
