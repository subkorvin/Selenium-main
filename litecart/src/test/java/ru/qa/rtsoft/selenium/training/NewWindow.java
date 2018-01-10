//package ru.qa.rtsoft.selenium.training;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import javax.annotation.Nullable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//
//@Ignore
//public class NewWindow extends TestBase {
//
//
//  @Test
//
//  public void newWindow() {
//    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  //неявное ожидание в ноль
//    wait = new WebDriverWait(driver, 15); // явное ожидание переставляем в 10 сек
//    AdminLoginTest login = new AdminLoginTest();
//    login.adminLoginTest();
//    driver.navigate().to("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
//    List<WebElement> elementslist = driver.findElements(By.cssSelector("form[name=countries_form] .dataTable .row"));
//    for (WebElement element : elementslist) {
//      String country = element.findElement(By.cssSelector("a")).getAttribute("textContent");
//      if (country.equals("Russian Federation")){
//        String link = element.findElement(By.cssSelector("a")).getAttribute("href");
//        driver.navigate().to(link);
//        break;
//      }
//    }
//    String mainWindow = driver.getWindowHandle();
//    List<String> titles = new ArrayList<>();
//    titles.add("Wikipedia");
//    titles.add("International");
//    List<WebElement> linkElements = driver.findElements(By.cssSelector("#content table a[target='_blank']"));
//    for (WebElement linkElement : linkElements) {
//      Set<String> existingWindows = driver.getWindowHandles();
//      linkElement.click();
//      String newWindow = wait.until(anyWindowOtherThen(existingWindows));
//      driver.switchTo().window(newWindow);
//      wait.until(ExpectedConditions.or(ExpectedConditions.titleContains("Wikipedia"), (ExpectedConditions.titleContains("International"))));
//      driver.close();
//      driver.switchTo().window(mainWindow);
//
//    }
//  }
//
//  public ExpectedCondition<String> anyWindowOtherThen(Set<String> existingWindows) {
//    return new ExpectedCondition<String>() {
//      @Nullable
//      @Override
//      public String apply(@Nullable WebDriver driver) {
//        assert driver != null;
//        Set<String> handles = driver.getWindowHandles();
//        handles.removeAll(existingWindows);
//        return handles.size()>0 ? handles.iterator().next(): null;
//      }
//    };
//  }
//}
