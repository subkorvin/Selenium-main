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
    String n = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color");
    VerbalExpression regex = VerbalExpression.regex().capt().find("(").digit().count(3).endCapture().build();
    String r = regex.getText(n);



    //System.out.println(articleNameFromMain + " " + regularPriceFromMain + " " + campaignPriceFromMain);
     //System.out.println(n);
    System.out.println(r);
  }
}
