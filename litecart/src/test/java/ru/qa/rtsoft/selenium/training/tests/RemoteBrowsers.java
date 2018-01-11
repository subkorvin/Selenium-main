package ru.qa.rtsoft.selenium.training.tests;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteBrowsers {

  @Test
  public void remoteBrowsers() throws MalformedURLException, InterruptedException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName("chrome");
    capabilities.setPlatform(Platform.WINDOWS);
    WebDriver driver = new RemoteWebDriver(new URL("http://10.5.20.57:4444/wd/hub"), capabilities);
    driver.navigate().to("http://www.google.com");
    Thread.sleep(3000);
    driver.quit();
  }
}
