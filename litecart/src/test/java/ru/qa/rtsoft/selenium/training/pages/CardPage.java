package ru.qa.rtsoft.selenium.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.lanwen.verbalregex.VerbalExpression;

import java.util.List;

public class CardPage extends Page {


  public CardPage(WebDriver driver){
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void clickToStop(List<WebElement> checkoutElements, int i) {
    if (i < checkoutElements.size()) {
      driver.findElement(By.cssSelector("#box-checkout-cart .shortcuts li:first-child")).click();
    }
  }

  public List<WebElement> getCardItems() {
    return driver.findElements(By.cssSelector("#box-checkout-cart .item"));
  }

  public void removeFromCard(List<WebElement> checkoutElements) {
    for (int i = 1; i <= checkoutElements.size(); i++) {
      clickToStop(checkoutElements, i);
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
