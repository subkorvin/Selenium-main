package ru.qa.rtsoft.selenium.training;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.util.List;

@Ignore
public class NewArticleAdding extends TestBase {


  private String articlename = "Black Duck";
  private String code = "rd010";
  private String quantity = "37.15";
  private String filePath = "src/test/resources/1-black-duck-1.png";
  private String shortDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sollicitudin ante massa, eget ornare libero porta congue.";
  private String fullDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
          " Suspendisse sollicitudin ante massa, eget ornare libero porta congue. Cras scelerisque " +
          "dui non consequat sollicitudin. Sed pretium tortor ac auctor molestie. Nulla facilisi. " +
          "Maecenas pulvinar nibh vitae lectus vehicula semper. Donec et aliquet velit. Curabitur non " +
          "ullamcorper mauris. In hac habitasse platea dictumst. Phasellus ut pretium justo, sit amet " +
          "bibendum urna. Maecenas sit amet arcu pulvinar, facilisis quam at, viverra nisi. Morbi sit amet " +
          "adipiscing ante. Integer imperdiet volutpat ante, sed venenatis urna volutpat a. Proin justo " +
          "massa, convallis vitae consectetur sit amet, facilisis id libero.";
  private String weight = "0.25";
  private String dim_x = "6.00";
  private String dim_y = "10.00";
  private String dim_z = "10.00";
  private String attributes = "Colors\n" +
          "Body: Black\n" +
          "Eyes: Black\n" +
          "Beak: Orange\n" +
          "\n" +
          "Other\n" +
          "Material: Rubber";


  @Test

  public void newArticleAdding(){
    AdminLoginTest login = new AdminLoginTest();
    login.adminLoginTest();

//    General tab
    app.driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(2)")).click();
    app.driver.findElement(By.cssSelector("#content div a:last-child")).click();
    app.driver.findElement(By.cssSelector("#tab-general label input:not([checked='checked'])")).click();
    app.driver.findElement(By.cssSelector("#tab-general input[name='name[en]']")).sendKeys(articlename);
    app.driver.findElement(By.cssSelector("#tab-general input[name='code']")).sendKeys(code);
    app.driver.findElement(By.cssSelector("#tab-general input[data-name='Root']")).click();
    app.driver.findElement(By.cssSelector("#tab-general input[data-name='Rubber Ducks']")).click();
    app.driver.findElement(By.cssSelector("#tab-general input[data-name='Subcategory']")).click();
    WebElement defaultCategory = app.driver.findElement(By.cssSelector("#tab-general select[name='default_category_id']"));
    Select defaultCategorySelect = new Select(defaultCategory);
    defaultCategorySelect.selectByValue("1");
    app.driver.findElement(By.cssSelector("#tab-general input[value='1-2']")).click();
    app.driver.findElement(By.cssSelector("#tab-general input[name='quantity']")).clear();
    app.driver.findElement(By.cssSelector("#tab-general input[name='quantity']")).sendKeys(quantity);
    File path = new File(filePath);
    app.driver.findElement(By.cssSelector("#tab-general input[type='file']")).sendKeys(path.getAbsolutePath());
    app.driver.findElement(By.cssSelector("#tab-general input[name='date_valid_from']")).sendKeys("10102017");
    app.driver.findElement(By.cssSelector("#tab-general input[name='date_valid_to']")).sendKeys("25012018");

// Information tab
    app.driver.findElement(By.cssSelector(".tabs a[href='#tab-information']")).click();
    WebElement manufacturer = app.driver.findElement(By.cssSelector("#tab-information select[name='manufacturer_id']"));
    Select manufacturerSelect = new Select(manufacturer);
    manufacturerSelect.selectByValue("1");
    app.driver.findElement(By.cssSelector("#tab-information input[name='keywords']")).sendKeys("duck black");
    app.driver.findElement(By.cssSelector("#tab-information input[name='short_description[en]']")).sendKeys(shortDescription);
    app.driver.findElement(By.cssSelector("#tab-information .trumbowyg-editor")).sendKeys(fullDescription);
    app.driver.findElement(By.cssSelector("#tab-information input[name='head_title[en]']")).sendKeys("Black Duck");
    app.driver.findElement(By.cssSelector("#tab-information input[name='meta_description[en]']")).sendKeys("Black Duck");


//    Data tab
    app.driver.findElement(By.cssSelector(".tabs a[href='#tab-data']")).click();
    app.driver.findElement(By.cssSelector("#tab-data input[name='sku']")).sendKeys("RD010");
    app.driver.findElement(By.cssSelector("#tab-data input[name='weight']")).clear();
    app.driver.findElement(By.cssSelector("#tab-data input[name='weight']")).sendKeys(weight);
    app.driver.findElement(By.cssSelector("#tab-data input[name='dim_x']")).clear();
    app.driver.findElement(By.cssSelector("#tab-data input[name='dim_y']")).clear();
    app.driver.findElement(By.cssSelector("#tab-data input[name='dim_z']")).clear();
    app.driver.findElement(By.cssSelector("#tab-data input[name='dim_x']")).sendKeys(dim_x);
    app.driver.findElement(By.cssSelector("#tab-data input[name='dim_y']")).sendKeys(dim_y);
    app.driver.findElement(By.cssSelector("#tab-data input[name='dim_z']")).sendKeys(dim_z);
    app.driver.findElement(By.cssSelector("#tab-data textarea[name='attributes[en]']")).sendKeys(attributes);
    app.driver.findElement(By.cssSelector("#content button[name='save']")).click();

//    Checking
    List<WebElement> articles = app.driver.findElements(By.cssSelector(".dataTable tr[class='row'] a"));
    for (WebElement article : articles) {
      boolean present;
      String text = article.getAttribute("textContent");
      if (text.equals("Black Duck")){
        present = true;
        Assert.assertTrue(present);
      } return;
    }
  }
}
