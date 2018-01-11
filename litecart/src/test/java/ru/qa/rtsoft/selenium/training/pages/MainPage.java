package ru.qa.rtsoft.selenium.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage extends Page {


  public MainPage(WebDriver driver){
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void open() {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  //неявное ожидание в ноль
    driver.navigate().to("http://localhost:8080/litecart");
  }

  public int getInitialQuantity() {
    return Integer.parseInt(driver.findElement(By.cssSelector("#cart .quantity")).getAttribute("textContent"));
  }

  public void goToBasket() {
    driver.findElement(By.cssSelector("#cart a[class='link']")).click();
  }
}
