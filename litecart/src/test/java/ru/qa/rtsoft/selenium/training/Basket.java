package ru.qa.rtsoft.selenium.training;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.lanwen.verbalregex.VerbalExpression;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class Basket extends TestBase {

  @Test
  public void basket() {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  //неявное ожидание в ноль
    driver.navigate().to("http://localhost:8080/litecart");
    int initialQuantity = Integer.parseInt(driver.findElement(By.cssSelector("#cart .quantity")).getAttribute("textContent"));
    for (int i = initialQuantity + 1; i < 4; i++) {
      driver.findElement(By.cssSelector(".content #box-most-popular li:first-child a[class='link']")).click();
      if (isElementPresentExplicit(By.cssSelector(".buy_now select"))){
        WebElement size = driver.findElement(By.cssSelector(".buy_now select[name='options[Size]']"));
        Select sizeSelect = new Select(size);
        sizeSelect.selectByValue("Large");
      }
      driver.findElement(By.cssSelector(".content button[name='add_cart_product']")).click();
      int quantity = initialQuantity + i;
      wait.until(ExpectedConditions.attributeToBe(By.cssSelector("#cart .quantity"), "textContent", String.valueOf(quantity)));
      driver.navigate().back();
    }
    driver.findElement(By.cssSelector("#cart a[class='link']")).click();


    List<WebElement> checkoutElements = driver.findElements(By.cssSelector("#box-checkout-cart .item"));
    for (int i = 1; i <= checkoutElements.size(); i++) {
      if (i < checkoutElements.size()) {
        driver.findElement(By.cssSelector("#box-checkout-cart .shortcuts li:first-child")).click();
      }
      String contentFromArticle = driver.findElement(By.cssSelector("#checkout-cart-wrapper li:first-child form[name='cart_form']")).getAttribute("textContent");
      VerbalExpression regex = VerbalExpression.regex().capture().find("RD").digit().count(3).endCapture().build();
      String sku = regex.getText(contentFromArticle);
      String locator = "//table[@class='dataTable rounded-corners']//td[contains(., '" + sku + "')]";
      WebElement tableSku = driver.findElement(By.xpath(locator));
      driver.findElement(By.cssSelector("#box-checkout-cart button[name='remove_cart_item']")).click();
      wait.until(ExpectedConditions.stalenessOf(tableSku));
    }
  }
}
