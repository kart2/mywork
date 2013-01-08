package com.perficient.ics.fred.controller;

import java.util.*;
import java.net.*;
import java.io.*;
import java.sql.*;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perficient.ics.fred.model.Agent;

@WebServlet(
    name = "AgentCreateController", 
    urlPatterns = {"/agent-create"}
  )

public class AgentCreateController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletOutputStream out = resp.getOutputStream();

    Agent.deleteAll();

    ArrayList<Agent> agents = new ArrayList<Agent>();
    agents.add(new Agent(0, "Weather"   , "fred Info Weather KJQF"));
    agents.add(new Agent(0, "Time"   , "fred Info Time"));

    Agent.create(agents);

    out.write("<html>".getBytes());
    out.write("<body>".getBytes());
    out.write("<h2>Created Agents</h2>".getBytes());
    out.write("<ul>".getBytes());
    for(Agent agent : agents) {
      out.write("<li>".getBytes());
      out.write(agent.getName().getBytes());
      out.write("</li>".getBytes());

      /*
      CommandLine cmdLine = CommandLine.parse(agent.getDescription());
      DefaultExecutor executor = new DefaultExecutor();
      //executor.setExitValue(1);
      try {
        int exitValue = executor.execute(cmdLine);
      }
      catch(Exception ex) {
        ex.printStackTrace();
      }
      */
    }
    out.write("</ul>".getBytes());
    out.write("<a href=\"/\">Home</a>".getBytes());
    out.write("</body>".getBytes());
    out.write("</html>".getBytes());
    
    out.flush();
    out.close();
  }
}
