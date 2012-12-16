package com.perficient.ics.controller;

import java.io.IOException;



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

import com.perficient.ics.model.Agent;

@WebServlet(
    name = "IcsController", 
    urlPatterns = {"/ics"}
  )

public class IcsController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletOutputStream out = resp.getOutputStream();
    out.write("{ \"total\":\"1\", \"page\":\"1\", \"records\":\"2\", \"rows\": [ { \"id\":\"1\", \"cell\": [\"1\",\"Time\",\"Time Agent\"] }, { \"id\":\"2\", \"cell\": [\"2\",\"Weather\",\"Weather Agent\"] } ] }".getBytes());

    ArrayList<Agent> agents = null;
    try {
      agents = Agent.list();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

   for(Agent agent : agents) {
      System.out.println("Agent: " + agent.getName() + " - " + agent.getDescription());
    }
    
    out.flush();
    out.close();
  }
}
