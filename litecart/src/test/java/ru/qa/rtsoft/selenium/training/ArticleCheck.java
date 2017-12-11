package ru.qa.rtsoft.selenium.training;

import org.junit.Test;
import org.openqa.selenium.By;
import ru.lanwen.verbalregex.VerbalExpression;

public class ArticleCheck extends TestBase {

  @Test
  public void articleCheck(){
    driver.navigate().to("http://localhost:8080/litecart");
    String articleNameFromMain = driver.findElement(By.cssSelector("#box-campaigns .name")).getAttribute("textContent");
    String regularPriceFromMain = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getAttribute("textContent");
    String campaignPriceFromMain = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getAttribute("textContent");
    //String n = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color");
    //String n = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color");
    String n = driver.findElement(By.cssSelector("#box-most-popular div[class='sticker new']")).getCssValue("background-color");
    //VerbalExpression regex = VerbalExpression.regex().find("(").capture().digit().count(3).endCapture().build();
    VerbalExpression regex = VerbalExpression.regex().find("(")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .build();
    String r = regex.getText(n, 1);
    String g = regex.getText(n, 2);
    String b = regex.getText(n, 3);



    //System.out.println(articleNameFromMain + " " + regularPriceFromMain + " " + campaignPriceFromMain);
    System.out.println(n);
    System.out.println(r);
    System.out.println(g);
    System.out.println(b);
  }
}
