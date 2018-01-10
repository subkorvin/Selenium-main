package ru.qa.rtsoft.selenium.training;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Basket extends TestBase {

  @Test
  public void basket() {

//    app.goToMainPage();
//    int initialQuantity = app.getInitialQuantity();
//    for (int i = initialQuantity + 1; i < 4; i++) {
//      app.leaveMainPage();
//      app.addToCard(initialQuantity, i);
//    }
//    app.goToBasket();
    app.addingToCard();
    app.removingFromCard();
//    List<WebElement> checkoutElements = app.getCardItems();
//      app.removeFromCard(checkoutElements);
  }
}
