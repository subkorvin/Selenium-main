package ru.qa.rtsoft.selenium.training;

import org.junit.Test;
import org.openqa.selenium.By;

public class AdminLoginTest extends TestBase{



  @Test
  public void adminLoginTest() {
    driver.navigate().to("http://localhost:8080/litecart/admin");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    //Thread.sleep(10000); // пока без проверок для визуального контроля
  }
}
