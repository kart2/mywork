package com.perficient.tabasco.model;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.map.type.TypeFactory;

import java.util.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public class ProductPersist extends Model {

  public static void init() {
    ArrayList<String> sqlCommands = new ArrayList<String>();
    sqlCommands.add("DROP TABLE IF EXISTS product");

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CREATE TABLE product (");
    stringBuilder.append("product_id serial PRIMARY KEY,");
    stringBuilder.append("name text NOT NULL,");
    stringBuilder.append("item text NOT NULL,");
    stringBuilder.append("model text NOT NULL,");
    stringBuilder.append("description text NOT NULL,");
    stringBuilder.append("url text NOT NULL,");
    stringBuilder.append("price numeric NOT NULL");
    stringBuilder.append(");");

    sqlCommands.add(stringBuilder.toString());

    for(String sql : sqlCommands) {

      Connection dbConnection = null;
      Statement statement = null;
   
      try {
        dbConnection = getDBConnection();
        statement    = dbConnection.createStatement();
        statement.executeUpdate(sql);
      } 
      catch (SQLException e) {
        System.out.println(e.getMessage());
      } 
      finally {
        try {
          if (statement != null) {
            statement.close();
          }
     
          if (dbConnection != null) {
            dbConnection.close();
          }
        }
        catch(SQLException e) {
          System.out.println(e.getMessage());
        }
      }
    }
  }

  public static ArrayList<Product> list() {
    ArrayList<Product> products = new ArrayList<Product>();
 
    Connection dbConnection = null;
    PreparedStatement preparedStatement = null;
 
    //String selectSQL = "SELECT product_id, name, description FROM product WHERE product_id = ?";
    String selectSQL = "SELECT product_id, name, item, model, description, url, price FROM product";
 
    try {
      dbConnection = getDBConnection();
      preparedStatement = dbConnection.prepareStatement(selectSQL);
      //preparedStatement.setInt(1, 1001);
 
      // execute select SQL stetement
      ResultSet rs = preparedStatement.executeQuery();
 
      while (rs.next()) {
        int productId      = rs.getInt("product_id");
        String name        = rs.getString("name");
        String item        = rs.getString("name");
        String model       = rs.getString("name");
        String description = rs.getString("description");
        String url         = rs.getString("url");
        double price       = rs.getDouble("price");
 
        products.add(new Product(productId, name, item, model, description, url, price));
      }
 
    } 
    catch (SQLException e) {
      System.out.println(e.getMessage());
    } 
    finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
   
        if (dbConnection != null) {
          dbConnection.close();
        }
      }
      catch(SQLException e) {
        System.out.println(e.getMessage());
      }
    }

    return products;
  }
 
  public static void create(ArrayList<Product> products) {
 
    Connection dbConnection = null;
    PreparedStatement preparedStatement = null;
 
    String insertTableSQL = "INSERT INTO product"
        + "(name, item, model, description, url, price) VALUES"
        + "(?,?,?,?,?,?)";
 
    try {
      dbConnection = getDBConnection();
      preparedStatement = dbConnection.prepareStatement(insertTableSQL);
 
      dbConnection.setAutoCommit(false);

      for(Product product : products) {
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getItem());
        preparedStatement.setString(3, product.getModel());
        preparedStatement.setString(4, product.getDescription());
        preparedStatement.setString(5, product.getUrl());
        preparedStatement.setDouble(6, product.getPrice());
        preparedStatement.addBatch();
      }
 
      preparedStatement.executeBatch();
 
      dbConnection.commit();
 
      System.out.println("Records inserted into product table!");
 
    } 
    catch (SQLException e) {
 
      System.out.println(e.getMessage());
      try {
        dbConnection.rollback();
      }
      catch(SQLException ex) {
        System.out.println(ex.getMessage());
      }
 
    } 
    finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
  
        if (dbConnection != null) {
          dbConnection.close();
        }
      }
      catch(SQLException e) {
        System.out.println(e.getMessage());
      }
    }
 
  }

  public static void deleteAll() {
 
    Connection dbConnection = null;
    PreparedStatement preparedStatement = null;
 
    String deleteTableSQL = "DELETE FROM product";
 
    try {
      dbConnection = getDBConnection();
      preparedStatement = dbConnection.prepareStatement(deleteTableSQL);
 
      // execute insert SQL stetement
      preparedStatement.executeUpdate();
 
      System.out.println("Records deleted from product table!");
    } 
    catch (SQLException e) {
      System.out.println(e.getMessage());
    } 
    finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
  
        if (dbConnection != null) {
          dbConnection.close();
        }
      }
      catch(SQLException e) {
        System.out.println(e.getMessage());
      }
    }

  }

  public static String toJsonGrid(ArrayList<Product> products) {

    HashMap<String, Object> productMap = new HashMap<String, Object>();

    productMap.put("total", "1");
    productMap.put("page", "1");
    productMap.put("records", String.valueOf(products.size()));

    ArrayList<HashMap<String,Object>> rows = new ArrayList<HashMap<String,Object>>();

    int rowNumber = 1;

    for(Product product : products) {
      HashMap<String,Object> row = new HashMap<String,Object>();

      row.put("id", String.valueOf(rowNumber));

      ArrayList<String> fields = new ArrayList<String>();
      fields.add(String.valueOf(rowNumber));
      fields.add(product.getName());
      //fields.add(product.getItem());
      //fields.add(product.getModel());
      fields.add(product.getDescription());
      //fields.add(product.getUrl());
      fields.add(String.valueOf(product.getPrice()));

      row.put("cell", fields);

      rows.add(row);

      rowNumber++;
    }

    productMap.put("rows", rows);

    // Convert list to JSON
    ObjectMapper mapper = new ObjectMapper();
    String json = "";

    try {
      json = mapper.writeValueAsString(productMap);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return json;
  }
 
}
