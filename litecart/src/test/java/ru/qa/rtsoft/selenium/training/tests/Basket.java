package ru.qa.rtsoft.selenium.training.tests;

import org.junit.Test;

public class Basket extends TestBase {

  @Test
  public void basket() {

    app.addingToCard();
    app.removingFromCard();
  }
}
