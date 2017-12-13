package ru.qa.rtsoft.selenium.training;

import org.junit.Test;
import org.openqa.selenium.By;

public class NewUserRegistration extends TestBase {

  String taxId = "000000000";
  String company = "RTSoft";
  String firstName = "Ivan";
  String lastName = "Pupkin";
  String address = "Leninsky tupik";
  String postcode = "12345";
  String city = "Wrotslaw";
  String email = "111@1.ru";
  String phone = "1234567";
  String password = "1";


  @Test
  public void newUserRegistration() throws InterruptedException {
    driver.navigate().to("http://localhost:8080/litecart");
    driver.findElement(By.cssSelector("form[name='login_form'] a")).click();
    driver.findElement(By.cssSelector("form[name='customer_form'] input[name='tax_id']")).sendKeys(taxId);
    Thread.sleep(3000);
  }
}
