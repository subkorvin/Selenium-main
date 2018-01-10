package ru.qa.rtsoft.selenium.training;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@Ignore
public class LeftMenuCheck extends TestBase {

  @Test

  public void leftMenuCheck() {
    AdminLoginTest login = new AdminLoginTest();
    login.adminLoginTest();
    List<String> menunameslist = new ArrayList<>();
    List<WebElement> leftmenu = app.driver.findElements(By.cssSelector(".list-vertical #app- .name"));


    for (WebElement menuitem : leftmenu) {
      String menuname = menuitem.getText();
      menunameslist.add(menuname);
    }

    for (String menuname : menunameslist) {
      String menulocator = "//ul[@class='list-vertical']/li[@id='app-']//span" + "[contains(., '" + menuname + "')]";
      app.driver.findElement(By.xpath("" + menulocator + "")).click();
      Assert.assertTrue(app.isElementPresent(By.cssSelector("h1[style*='margin-top']")));
      List<String> submenunameslist = new ArrayList<>();
      if (app.isElementPresent(By.cssSelector(".list-vertical #app- .docs"))) {
        List<WebElement> submenu = app.driver.findElements(By.cssSelector(".list-vertical #app- .docs .name"));
        for (WebElement submenuitem : submenu) {
          String submenuname = submenuitem.getText();
          submenunameslist.add(submenuname);
        }
        for (String submenuname : submenunameslist) {
          String submenulocator = "//ul[@class='list-vertical']/li[@id='app-']/ul[@class='docs']//span" + "[contains(., '" + submenuname + "')]";
          app.driver.findElement(By.xpath("" + submenulocator + "")).click();
          //Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
          Assert.assertTrue(app.isElementPresent(By.cssSelector("h1[style*='margin-top']")));
        }
      }
    }
  }
}
