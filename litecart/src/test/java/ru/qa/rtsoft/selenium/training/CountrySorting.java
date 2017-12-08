package ru.qa.rtsoft.selenium.training;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CountrySorting extends TestBase {

  @Test
  public void countrySorting() {
    AdminLoginTest login = new AdminLoginTest();
    login.adminLoginTest();
    driver.navigate().to("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
    List<WebElement> elementslist = driver.findElements(By.cssSelector("form[name=countries_form] .dataTable .row"));
    List<String> zones = new ArrayList<>();
    List<String> countries = new ArrayList<>();
    for (WebElement element : elementslist) {
      String country = element.findElement(By.cssSelector("a")).getAttribute("textContent");
      countries.add(country);
    }


    List<WebElement> rows = driver.findElements(By.cssSelector("form[name=countries_form] .dataTable .row"));
    for (WebElement row : rows) {
      String zone = row.findElement(By.cssSelector("td:nth-child(6)")).getAttribute("outerText");
      if (!zone.equals("0")) {
        String zonelink = row.findElement(By.cssSelector("td > a")).getAttribute("href");
        zones.add(zonelink);
      }



//      for (WebElement cell : rows){
//        String zone = cell.getAttribute("outerText");
//        if (zone.equals("0")){
//          return;
//        }
//        String zonelink = element.findElement(By.cssSelector("td > a")).getAttribute("href");
//        zones.add(zonelink);
//      }
    }
    System.out.println(zones);
  }
}
