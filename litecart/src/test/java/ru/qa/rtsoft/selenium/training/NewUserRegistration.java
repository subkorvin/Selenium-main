package ru.qa.rtsoft.selenium.training;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;


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
    driver.navigate().to("http://localhost:8080/litecart");
    driver.findElement(By.cssSelector("form[name='login_form'] a")).click();
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='tax_id']")).sendKeys(taxId);
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='company']")).sendKeys(company);
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='firstname']")).sendKeys(firstName);
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='lastname']")).sendKeys(lastName);
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='address1']")).sendKeys(address);
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='postcode']")).sendKeys(postcode);
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='city']")).sendKeys(city);
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='email']")).sendKeys(email);
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='phone']")).sendKeys(phone);
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='password']")).sendKeys(password);
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='confirmed_password']")).sendKeys(password);
    WebElement country = driver.findElement(By.cssSelector("form[name='customer_form'] select[name='country_code']"));
    WebElement state = driver.findElement(By.cssSelector("form[name='customer_form'] select[name='zone_code']"));
    Select countrySelect = new Select(country);
    Select stateSelect = new Select(state);
    countrySelect.selectByValue("US");
    stateSelect.selectByValue("CO");
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='newsletter']")).click();
    driver.findElement(By.cssSelector("form[name='customer_form'] button[name='create_account']")).click();
    driver.findElement(By.cssSelector("#box-account li:nth-child(4) a")).click(); //logout
    driver.findElement(By.cssSelector("#box-account-login input[name='email']")).sendKeys(email);
    driver.findElement(By.cssSelector("#box-account-login input[name='password']")).sendKeys(password);
    driver.findElement(By.cssSelector("form[name='login_form'] button[name='login']")).click();
    driver.findElement(By.cssSelector("#box-account li:nth-child(4) a")).click();
  }
}
