package model.persist;

public class Model {

import java.util.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public class Model {
  private static final String DB_DRIVER     = "org.postgresql.Driver";
  private static final String DB_CONNECTION = "jdbc:postgresql://127.0.0.1:5432/training";
  private static final String DB_USER       = "ics";
  private static final String DB_PASSWORD   = "QQQqqq!!!111";

  public static Connection getDBConnection() {

    Connection dbConnection = null;

    try {
      Class.forName(DB_DRIVER);
    }
    catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    try {
      dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
      return dbConnection;

    }
    catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    return dbConnection;

  }

  public static java.sql.Timestamp getCurrentTimeStamp() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Timestamp(today.getTime());
  }
}
