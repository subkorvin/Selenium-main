package ru.qa.rtsoft.selenium.training;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NewWindow extends TestBase {


  @Test
  public void newWindow() throws InterruptedException {
    AdminLoginTest login = new AdminLoginTest();
    login.adminLoginTest();
    driver.navigate().to("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
    List<WebElement> elementslist = driver.findElements(By.cssSelector("form[name=countries_form] .dataTable .row"));
    for (WebElement element : elementslist) {
      String country = element.findElement(By.cssSelector("a")).getAttribute("textContent");
      if (country.equals("Russian Federation")){
        String link = element.findElement(By.cssSelector("a")).getAttribute("href");
        driver.navigate().to(link);
        break;
      }
    }
    List<WebElement> linkElements = driver.findElements(By.cssSelector("#content table a[target='_blank']"));
    List<String> links = new ArrayList<>();
    for (WebElement linkElement : linkElements) {
      String link = linkElement.getAttribute("href");
      links.add(link);
    }
  }
}
