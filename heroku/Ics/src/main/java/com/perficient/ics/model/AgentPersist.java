package com.perficient.ics.model;

import java.util.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public class AgentPersist extends Model {

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
        String agentId     = rs.getString("agent_id");
        String name        = rs.getString("name");
        String description = rs.getString("description");
 
        agents.add(new Agent(name, description));
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
 
}
