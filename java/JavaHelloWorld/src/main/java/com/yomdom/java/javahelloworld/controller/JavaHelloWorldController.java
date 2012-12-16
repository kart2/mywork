package com.yomdom.java.javahelloworld.controller;

import java.util.*;
import java.net.*;
import java.io.*;
import java.sql.*;

import org.codehaus.jackson.map.ObjectMapper; 
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.map.type.TypeFactory;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import com.yomdom.java.javahelloworld.model.Agent;

/**
 * Hello world!
 *
 */
public class JavaHelloWorldController {

  public static void main( String[] args ) {
    JavaHelloWorldController controller = new JavaHelloWorldController();


    controller.createAgentsInDatabase();

    ArrayList<Agent> agents = null;
    try {
      agents = Agent.list();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    for(Agent agent : agents) {
      System.out.println("Agent: " + agent.getName() + " - " + agent.getDescription());
      CommandLine cmdLine = CommandLine.parse(agent.getDescription());
      DefaultExecutor executor = new DefaultExecutor();
      //executor.setExitValue(1);
      try {
        int exitValue = executor.execute(cmdLine);
      }
      catch(Exception ex) {
        ex.printStackTrace();
      }
    }
    
    //controller.createAgents("http://yomdompxn.appspot.com");
    //controller.createAgents("http://localhost:8080");
  }

  public void createAgentsInDatabase() {
    Agent.deleteAll();

    ArrayList<Agent> agents = new ArrayList<Agent>();
    agents.add(new Agent("Weather"   , "fred Info Weather KJQF"));
    agents.add(new Agent("Time"   , "fred Info Time"));

    Agent.create(agents);

  }

}
