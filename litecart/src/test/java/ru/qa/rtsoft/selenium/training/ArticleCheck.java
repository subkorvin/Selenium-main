package ru.qa.rtsoft.selenium.training;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ArticleCheck extends TestBase {

  @Test
  public void articleCheck() {
    driver.navigate().to("http://localhost:8080/litecart");
    String articleNameFromMain = driver.findElement(By.cssSelector("#box-campaigns .name")).getAttribute("textContent");
    List<String> mainPageDataRegular = readData("#box-campaigns .regular-price");
    List<String> mainPageDataCampaign = readData("#box-campaigns .campaign-price");
//    System.out.println(readData("#box-campaigns .regular-price"));
//    System.out.println(readData("#box-campaigns .campaign-price"));

    driver.findElement(By.cssSelector("#box-campaigns .link")).click();
    String articleNameFromArticle = driver.findElement(By.cssSelector("#box-product .title")).getAttribute("textContent");
    List<String> articlePageDataRegular = readData(".content .regular-price");
    List<String> articlePageDataCampaign = readData(".content .campaign-price");
//    System.out.println(readData(".content .regular-price"));
//    System.out.println(readData(".content .campaign-price"));

    Assert.assertTrue(articleNameFromMain.equals(articleNameFromArticle));
    Assert.assertTrue(mainPageDataRegular.get(0).equals(articlePageDataRegular.get(0)));
    Assert.assertTrue(mainPageDataRegular.get(1).equals(articlePageDataRegular.get(1)));
    Assert.assertTrue(mainPageDataRegular.get(2).equals(articlePageDataRegular.get(2)));




//    fontSizeToFloat();
//    System.out.println(regularFontSizeFromMain);


//    readDataFromMainPage("#box-campaigns .regular-price", "textContent", "text-decoration-line", "font-weight", "font-size");
//    readDataFromMainPage("#box-campaigns .campaign-price", "textContent", "text-decoration-line", "font-weight", "font-size");

//    #box-campaigns .regular-price
//    #box-campaigns .campaign-price


//    System.out.println(parsingColorRGB("#box-campaigns .regular-price", "text-decoration-color"));
//    System.out.println(regularFontSizeFromMainString);
//    System.out.println(campaignFontSizeFromMainString);
//    System.out.println(regularFontSizeFromMain);


    //String n = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color");
    //String n = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color");
    //parsingColor("#box-most-popular div[class='sticker new']", "background-color");
    //System.out.println(parsingColor("#box-most-popular div[class='sticker new']", "background-color").get(1));
  }

  private float fontSizeToFloat() {
    String fontSizeFromMainString = readData("#box-campaigns .regular-price")
            .get(3)
            .replaceAll("px", "");
    float regularFontSizeFromMain = Float.valueOf(fontSizeFromMainString);
    return regularFontSizeFromMain;
  }

  private List<String> readData(String locator) {
    List<String> data = new ArrayList<>();
    String price = driver.findElement(By.cssSelector(locator)).getAttribute("textContent");
    String fontDecoration = driver.findElement(By.cssSelector(locator)).getCssValue("text-decoration-line");
    String fontStyle = driver.findElement(By.cssSelector(locator)).getCssValue("font-weight");
    String fontSize = driver.findElement(By.cssSelector(locator)).getCssValue("font-size");
    data.add(price);
    data.add(fontDecoration);
    data.add(fontStyle);
    data.add(fontSize);
    return data;
  }
}
