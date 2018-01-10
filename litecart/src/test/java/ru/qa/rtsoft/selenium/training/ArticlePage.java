package ru.qa.rtsoft.selenium.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ArticlePage extends Page {


//  public Application app = new Application();


  public ArticlePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void goToArticle() {
    driver.findElement(By.cssSelector(".content #box-most-popular li:first-child a[class='link']")).click();
  }

  public void addToCard(int initialQuantity, int i) {
    if (app.isElementPresentExplicit(By.cssSelector(".buy_now select"))) {
      WebElement size = driver.findElement(By.cssSelector(".buy_now select[name='options[Size]']"));
      Select sizeSelect = new Select(size);
      sizeSelect.selectByValue("Large");
    }
    driver.findElement(By.cssSelector(".content button[name='add_cart_product']")).click();
    int quantity = initialQuantity + i;
    wait.until(ExpectedConditions.attributeToBe(By.cssSelector("#cart .quantity"), "textContent", String.valueOf(quantity)));
    driver.navigate().back();
  }

}
