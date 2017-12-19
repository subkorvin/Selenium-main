package ru.qa.rtsoft.selenium.trainig;


import org.junit.Test;

import java.sql.*;

public class Database {

  @Test
  public void database() throws SQLException {
    Connection connection = null;
    connection = DriverManager.getConnection("jdbc:sqlite:d:\\Temp\\52021806.db");
    Statement statement = connection.createStatement();
    statement.setQueryTimeout(30);  // set timeout to 30 sec.
    ResultSet rs = statement.executeQuery("select * from lData where profileid = 1");
    while(rs.next()){
      System.out.println("time = " + rs.getString("timeStamp"));
      System.out.println("cosem = " + rs.getInt("cosemValue"));

    }
  }
}
