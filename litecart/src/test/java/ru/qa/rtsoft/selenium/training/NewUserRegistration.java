package ru.qa.rtsoft.selenium.training;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;


@Ignore
public class NewUserRegistration extends TestBase {

  private String taxId = "000000000";
  private String company = "RTSoft";
  private String firstName = "Ivan";
  private String lastName = "Pupkin";
  private String address = "Leninsky tupik";
  private String postcode = "12345";
  private String city = "Wrotslaw";
  private String email = null;
  private String phone = "1234567";
  private String password = "1";


  @Test

  public void newUserRegistration() {
    Random random = new Random();
    int n = random.nextInt(100000);
    email = n + "@email.com";
    app.driver.navigate().to("http://localhost:8080/litecart");
    app.driver.findElement(By.cssSelector("form[name='login_form'] a")).click();
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='tax_id']")).sendKeys(taxId);
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='company']")).sendKeys(company);
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='firstname']")).sendKeys(firstName);
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='lastname']")).sendKeys(lastName);
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='address1']")).sendKeys(address);
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='postcode']")).sendKeys(postcode);
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='city']")).sendKeys(city);
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='email']")).sendKeys(email);
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='phone']")).sendKeys(phone);
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='password']")).sendKeys(password);
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='confirmed_password']")).sendKeys(password);
    WebElement country = app.driver.findElement(By.cssSelector("form[name='customer_form'] select[name='country_code']"));
    WebElement state = app.driver.findElement(By.cssSelector("form[name='customer_form'] select[name='zone_code']"));
    Select countrySelect = new Select(country);
    Select stateSelect = new Select(state);
    countrySelect.selectByValue("US");
    stateSelect.selectByValue("CO");
    app.driver.findElement(By.cssSelector("form[name='customer_form'] input[name='newsletter']")).click();
    app.driver.findElement(By.cssSelector("form[name='customer_form'] button[name='create_account']")).click();
    app.driver.findElement(By.cssSelector("#box-account li:nth-child(4) a")).click(); //logout
    app.driver.findElement(By.cssSelector("#box-account-login input[name='email']")).sendKeys(email);
    app.driver.findElement(By.cssSelector("#box-account-login input[name='password']")).sendKeys(password);
    app.driver.findElement(By.cssSelector("form[name='login_form'] button[name='login']")).click();
    app.driver.findElement(By.cssSelector("#box-account li:nth-child(4) a")).click();
  }
}
