package ru.qa.rtsoft.selenium.training;

import org.junit.Test;

public class Basket extends TestBase {

  @Test
  public void basket(){
    driver.navigate().to("http://localhost:8080/litecart");
  }
}
