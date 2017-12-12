package ru.qa.rtsoft.selenium.training;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountrySorting extends TestBase {

  @Test
  public void countrySorting() {
    AdminLoginTest login = new AdminLoginTest();
    login.adminLoginTest();
    driver.navigate().to("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
    List<WebElement> elementslist = driver.findElements(By.cssSelector("form[name=countries_form] .dataTable .row"));
    List<String> countries = new ArrayList<>();
    List<String> countriessorted = new ArrayList<>();
    for (WebElement element : elementslist) {
      String country = element.findElement(By.cssSelector("a")).getAttribute("textContent");
      countries.add(country);
      countriessorted.add(country);
    }
    Collections.sort(countriessorted);
    Assert.assertTrue(countries.equals(countriessorted));
  }

  @Test
  public void geoZonesSorting() {
    AdminLoginTest login = new AdminLoginTest();
    login.adminLoginTest();
    driver.navigate().to("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
    List<String> zones = new ArrayList<>();
    List<WebElement> rows = driver.findElements(By.cssSelector("form[name=countries_form] .dataTable .row"));
    for (WebElement row : rows) {
      String zone = row.findElement(By.cssSelector("td:nth-child(6)")).getAttribute("outerText");
      if (!zone.equals("0")) {
        String zonelink = row.findElement(By.cssSelector("td > a")).getAttribute("href");
        zones.add(zonelink);
      }
    }
    for (String zone : zones){
      driver.navigate().to(zone);
      List<WebElement> geozones = driver.findElements(By.cssSelector(".dataTable tr td:nth-child(3) input[type='hidden']"));
      List<String> geozonenames = new ArrayList<>();
      List<String> geozonenamessorted = new ArrayList<>();
      for (WebElement geozone : geozones){
        geozonenames.add(geozone.getAttribute("value"));
        geozonenamessorted.add(geozone.getAttribute("value"));
        Collections.sort(geozonenamessorted);
        Assert.assertTrue(geozonenames.equals(geozonenamessorted));
      }
    }
  }

  @Test
  public void geoZonePageSorting(){
    AdminLoginTest login = new AdminLoginTest();
    login.adminLoginTest();
    driver.navigate().to("http://localhost:8080/litecart/admin/?app=geo_zones&doc=geo_zones");
    List<WebElement> geozones = driver.findElements(By.cssSelector(".dataTable .row td:nth-child(3) a"));
    List<String> pageLinks = new ArrayList<>();
    for (WebElement geozone : geozones){
      pageLinks.add(geozone.getAttribute("href"));
    }
    for (String pagelink : pageLinks){
      driver.navigate().to(pagelink);
      List<String> geozonenames = new ArrayList<>();
      List<String> geozonenamessorted = new ArrayList<>();
      List<WebElement> geoZoneWeb = driver.findElements(By.cssSelector("#table-zones select[name*='zone_code'] option[selected='selected']"));
      for (WebElement geoZoneName : geoZoneWeb){
        geozonenames.add(geoZoneName.getAttribute("textContent"));
        geozonenamessorted.add(geoZoneName.getAttribute("textContent"));
        Collections.sort(geozonenamessorted);
        Assert.assertTrue(geozonenames.equals(geozonenamessorted));
      }
    }
  }
}
