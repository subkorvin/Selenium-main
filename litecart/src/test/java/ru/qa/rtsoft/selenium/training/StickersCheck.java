//package ru.qa.rtsoft.selenium.training;
//
//import org.junit.Assert;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import java.util.List;
//
//@Ignore
//public class StickersCheck extends TestBase {
//
//  @Test
//
//  public void stickersCheck(){
//    driver.navigate().to("http://localhost:8080/litecart");
//    List<WebElement> products = driver.findElements(By.cssSelector(".image-wrapper"));
//    for (WebElement product : products) {
//      List<WebElement> stickers = product.findElements(By.cssSelector("div[class^=sticker]"));
//      int numberofstickers = stickers.size();
//      Assert.assertTrue(numberofstickers == 1);
//    }
//  }
//}
