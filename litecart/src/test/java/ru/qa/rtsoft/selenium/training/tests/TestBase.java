package ru.qa.rtsoft.selenium.training.tests;

import org.junit.Before;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.qa.rtsoft.selenium.training.application.Application;

import java.util.ArrayList;
import java.util.List;

public class TestBase {

  public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
  public Application app;

  @Before
  public void start(){
    if (tlApp.get() != null) {
      app = tlApp.get();
      return;
    }

    app = Application.getInstance();
    tlApp.set(app);

    Runtime.getRuntime().addShutdownHook(
            new Thread(() -> { app.quit(); app = null; }));
  }


//  @After
//  public void stop() {
//    if (app.driver != null) {
//      app.driver.quit();
//      app.driver = null;
//    }
//  }

  protected List<String> parsingColorRGBA(String color) {
    // in list colors are enumerated: r(red), g(green), b(blue), a(alpha)
    List<String> colorRGBA = new ArrayList<>();
    VerbalExpression regex = VerbalExpression.regex().find("(")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .build();
    String r = regex.getText(color, 1);
    String g = regex.getText(color, 2);
    String b = regex.getText(color, 3);
    String a = regex.getText(color, 4);
    colorRGBA.add(r);
    colorRGBA.add(g);
    colorRGBA.add(b);
    colorRGBA.add(a);
    return colorRGBA;
  }

  protected List<String> parsingColorRGB(String color) {
    // in list colors are enumerated: r(red), g(green), b(blue)
    List<String> colorRGB = new ArrayList<>();
    VerbalExpression regex = VerbalExpression.regex().find("(")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .then(", ")
            .capture().digit().count(0, 3).endCapture()
            .build();
    String r = regex.getText(color, 1);
    String g = regex.getText(color, 2);
    String b = regex.getText(color, 3);
    colorRGB.add(r);
    colorRGB.add(g);
    colorRGB.add(b);
    return colorRGB;
  }

}
