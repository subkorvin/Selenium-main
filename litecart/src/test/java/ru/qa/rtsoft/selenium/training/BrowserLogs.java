package ru.qa.rtsoft.selenium.training;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserLogs extends TestBase {

  @Test
  public void browserLogs(){
    AdminLoginTest login = new AdminLoginTest();
    login.adminLoginTest();
    driver.navigate().to("http://localhost:8080/litecart/admin/?app=catalog&doc=catalog&category_id=1");
    List<WebElement> elemenstList = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row']//img/.."));
    List<String> links = new ArrayList<>();
    for (WebElement element : elemenstList) {
      String link = element.findElement(By.cssSelector("a")).getAttribute("href");
      links.add(link);
    }
    for (String link: links) {
      driver.navigate().to(link);
      driver.manage().logs().get("browser").forEach(l -> System.out.println(l));
    }
  }
}
