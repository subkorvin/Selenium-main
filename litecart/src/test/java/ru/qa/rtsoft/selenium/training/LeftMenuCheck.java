package ru.qa.rtsoft.selenium.training;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LeftMenuCheck extends TestBase {

  @Test
  public void leftMenuCheck() throws InterruptedException {
    AdminLoginTest login = new AdminLoginTest();
    login.adminLoginTest();
    List<WebElement> leftmenu = driver.findElements(By.cssSelector(".list-vertical #app-"));
    for (WebElement menuitem : leftmenu) {
      String menuname = menuitem.findElement(By.cssSelector(".name")).getText();
      System.out.println(menuname);
      String locator = "//ul[@class='list-vertical']/li[@id='app-']//span" + "[contains(., '" + menuname + "')]";
      System.out.println(locator);
      menuitem.findElement(By.xpath("" + locator + "")).click();


//      WebElement w = driver.findElement(By.xpath("//ul[@class='list-vertical']/li[@id='app-'][2]"));
//      String m1 = driver.findElement(By.xpath("//ul[@class='list-vertical']/li[@id='app-'][2]")).getText();
//      String m2 = menuitem.findElement(By.cssSelector(".name")).getText();
//      menuitem.findElement(By.cssSelector(".name")).click();


      Thread.sleep(1500);
    }
  }
}
