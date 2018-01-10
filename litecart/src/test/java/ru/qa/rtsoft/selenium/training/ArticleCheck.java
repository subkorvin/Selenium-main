package ru.qa.rtsoft.selenium.training;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

@Ignore
public class ArticleCheck extends TestBase {

  @Test

  public void articleCheck() {
    app.driver.navigate().to("http://localhost:8080/litecart");
    String articleNameFromMain = app.driver.findElement(By.cssSelector("#box-campaigns .name")).getAttribute("textContent");
    List<String> mainPageDataRegular = readData("#box-campaigns .regular-price");
    List<String> mainPageDataCampaign = readData("#box-campaigns .campaign-price");

    app.driver.findElement(By.cssSelector("#box-campaigns .link")).click();
    String articleNameFromArticle = app.driver.findElement(By.cssSelector("#box-product .title")).getAttribute("textContent");
    List<String> articlePageDataRegular = readData(".content .regular-price");
    List<String> articlePageDataCampaign = readData(".content .campaign-price");

    List<String> mainPageColorsRegular = parsingColorRGB(mainPageDataRegular.get(3));
    List<String> articlePageColorsRegular = parsingColorRGB(articlePageDataRegular.get(3));
    List<String> mainPageColorsCampaign = parsingColorRGB(mainPageDataCampaign.get(3));
    List<String> articlePageColorsCampaign = parsingColorRGB(articlePageDataCampaign.get(3));


    // проверки
    Assert.assertTrue("Names of article aren't equal", articleNameFromMain.equals(articleNameFromArticle));

      Assert.assertTrue("Regular prices are different", mainPageDataRegular.get(0).equals(articlePageDataRegular.get(0)));
      Assert.assertTrue("Campaign prices are different", mainPageDataCampaign.get(0).equals(articlePageDataCampaign.get(0)));

    if ((Float.valueOf(mainPageColorsRegular.get(0)) > 0
            && mainPageColorsRegular.get(0).equals(mainPageColorsRegular.get(1))
            && mainPageColorsRegular.get(1).equals(mainPageColorsRegular.get(2)))
            && mainPageDataRegular.get(1).contains("line-through")){
      System.out.printf("Regular price on main page is grey and strikethrough \n");
    } else {
      System.out.printf("Style error!!!\n");
    }

    if ((Float.valueOf(articlePageColorsRegular.get(0)) > 0
            && articlePageColorsRegular.get(0).equals(articlePageColorsRegular.get(1))
            && articlePageColorsRegular.get(1).equals(articlePageColorsRegular.get(2)))
            && mainPageDataRegular.get(1).contains("line-through")) {
      System.out.printf("Regular price on main page is grey and strikethrough \n");
    } else {
      System.out.printf("Style error!!!\n");
    }


    boolean colorCampaign = false;
    if (Float.valueOf(mainPageColorsCampaign.get(0)) > 0
            && Float.valueOf(mainPageColorsCampaign.get(1)) == 0
            && Float.valueOf(mainPageColorsCampaign.get(2)) == 0
            && Float.valueOf(mainPageDataCampaign.get(2)) > Float.valueOf(mainPageDataRegular.get(2))) {
      colorCampaign = true;
    }
    Assert.assertTrue("Campaign price on main page isn't red and bold \n", colorCampaign);

    colorCampaign = false;
    if (Float.valueOf(articlePageColorsCampaign.get(0)) > 0
            && Float.valueOf(articlePageColorsCampaign.get(1)) == 0
            && Float.valueOf(articlePageColorsCampaign.get(2)) == 0
            && Float.valueOf(articlePageDataCampaign.get(2)) > Float.valueOf(articlePageDataRegular.get(2))) {
      colorCampaign = true;
    }
    Assert.assertTrue("Campaign price on article page isn't red and bold \n", colorCampaign);

    Assert.assertTrue("Font size of campaign price on main page isn't bigger then regular", fontSizeToFloat(mainPageDataRegular.get(4)) < fontSizeToFloat(mainPageDataCampaign.get(4)));
    Assert.assertTrue("Font size of campaign price on article page isn't bigger then regular", fontSizeToFloat(articlePageDataRegular.get(4)) < fontSizeToFloat(articlePageDataCampaign.get(4)));

  }

  private float fontSizeToFloat(String size) {
    size = size.replaceAll("px", "");
    float sizeFloat = Float.valueOf(size);
    return sizeFloat;
  }

  private List<String> readData(String locator) {
    List<String> data = new ArrayList<>();
    String price = app.driver.findElement(By.cssSelector(locator)).getAttribute("textContent");
    String fontDecoration = app.driver.findElement(By.cssSelector(locator)).getCssValue("text-decoration");
    String fontStyle = app.driver.findElement(By.cssSelector(locator)).getCssValue("font-weight");
    String fontColor = app.driver.findElement(By.cssSelector(locator)).getCssValue("color");
    String fontSize = app.driver.findElement(By.cssSelector(locator)).getCssValue("font-size");
    data.add(price);
    data.add(fontDecoration);
    data.add(fontStyle);
    data.add(fontColor);
    data.add(fontSize);
    return data;
  }
}
