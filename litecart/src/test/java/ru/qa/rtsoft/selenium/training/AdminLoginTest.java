package ru.qa.rtsoft.selenium.training;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

@Ignore
public class AdminLoginTest extends TestBase{



  @Test

  public void adminLoginTest() {
    app.driver.navigate().to("http://localhost:8080/litecart/admin");
    app.driver.findElement(By.name("username")).sendKeys("admin");
    app.driver.findElement(By.name("password")).sendKeys("admin");
    app.driver.findElement(By.name("login")).click();
    //Thread.sleep(10000); // пока без проверок для визуального контроля
  }
}
