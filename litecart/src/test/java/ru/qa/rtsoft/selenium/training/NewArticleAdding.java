package ru.qa.rtsoft.selenium.training;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class NewArticleAdding extends TestBase {


  private String articlename = "Black Duck";
  private String code = "rd010";
  private String quantity = "37.15";

  @Test
  public void newArticleAdding() throws InterruptedException {
    AdminLoginTest login = new AdminLoginTest();
    login.adminLoginTest();
    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(2)")).click();
    driver.findElement(By.cssSelector("#content div a:last-child")).click();
    driver.findElement(By.cssSelector("#tab-general label input:not([checked='checked'])")).click();
    driver.findElement(By.cssSelector("#tab-general input[name='name[en]']")).sendKeys(articlename);
    driver.findElement(By.cssSelector("#tab-general input[name='code']")).sendKeys(code);
    driver.findElement(By.cssSelector("#tab-general input[data-name='Root']")).click();
    driver.findElement(By.cssSelector("#tab-general input[data-name='Rubber Ducks']")).click();
    driver.findElement(By.cssSelector("#tab-general input[data-name='Subcategory']")).click();
    WebElement defaultCategory = driver.findElement(By.cssSelector("#tab-general select[name='default_category_id']"));
    Select defaultCategorySelect = new Select(defaultCategory);
    defaultCategorySelect.selectByValue("1");
    driver.findElement(By.cssSelector("#tab-general input[value='1-2']")).click();
    driver.findElement(By.cssSelector("#tab-general input[name='quantity']")).clear();
    driver.findElement(By.cssSelector("#tab-general input[name='quantity']")).sendKeys(quantity);
    


    Thread.sleep(3000);
  }
}
