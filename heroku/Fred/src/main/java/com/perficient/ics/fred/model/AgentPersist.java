package com.perficient.ics.fred.model;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.map.type.TypeFactory;

import java.util.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public class AgentPersist extends Model {

  public static void init() {
    ArrayList<String> sqlCommands = new ArrayList<String>();
    sqlCommands.add("DROP TABLE IF EXISTS agent");

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CREATE TABLE agent (");
    stringBuilder.append("agent_id serial PRIMARY KEY,");
    stringBuilder.append("name text NOT NULL,");
    stringBuilder.append("description text NOT NULL");
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


  public static ArrayList<Agent> list() {
    ArrayList<Agent> agents = new ArrayList<Agent>();
 
    Connection dbConnection = null;
    PreparedStatement preparedStatement = null;
 
    //String selectSQL = "SELECT agent_id, name, description FROM agent WHERE agent_id = ?";
    String selectSQL = "SELECT agent_id, name, description FROM agent";
 
    try {
      dbConnection = getDBConnection();
      preparedStatement = dbConnection.prepareStatement(selectSQL);
      //preparedStatement.setInt(1, 1001);
 
      // execute select SQL stetement
      ResultSet rs = preparedStatement.executeQuery();
 
      while (rs.next()) {
        int agentId        = rs.getInt("agent_id");
        String name        = rs.getString("name");
        String description = rs.getString("description");
 
        agents.add(new Agent(agentId, name, description));
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

    return agents;
  }
 
  public static void create(ArrayList<Agent> agents) {
 
    Connection dbConnection = null;
    PreparedStatement preparedStatement = null;
 
    String insertTableSQL = "INSERT INTO agent"
        + "(name, description) VALUES"
        + "(?,?)";
 
    try {
      dbConnection = getDBConnection();
      preparedStatement = dbConnection.prepareStatement(insertTableSQL);
 
      dbConnection.setAutoCommit(false);

      for(Agent agent : agents) {
        preparedStatement.setString(1, agent.getName());
        preparedStatement.setString(2, agent.getDescription());
        preparedStatement.addBatch();
      }
 
      preparedStatement.executeBatch();
 
      dbConnection.commit();
 
      System.out.println("Records inserted into agent table!");
 
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
 
    String deleteTableSQL = "DELETE FROM agent";
 
    try {
      dbConnection = getDBConnection();
      preparedStatement = dbConnection.prepareStatement(deleteTableSQL);
 
      // execute insert SQL stetement
      preparedStatement.executeUpdate();
 
      System.out.println("Records deleted from agent table!");
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

  public static String toJson(ArrayList<Agent> agents) {

    // Convert list to JSON
    ObjectMapper mapper = new ObjectMapper();
    String json = "";

    try {
      json = mapper.writeValueAsString(agents);
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return json;
  }
 
}
