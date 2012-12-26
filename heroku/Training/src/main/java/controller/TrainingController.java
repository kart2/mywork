package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import model.*;

@WebServlet(
  name = "TrainingController", 
  urlPatterns = {"/training"}
)

public class TrainingController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Agent.init();

    ArrayList<Agent> agents = new ArrayList<Agent>();
    agents.add(new Agent(0, "Weather", "My Weather"));
    agents.add(new Agent(0, "News", "My News"));

    Agent.create(agents);

    agents = null;

    try {
      agents = Agent.list();
      String json = Agent.toJsonGrid(agents);
      ServletOutputStream out = resp.getOutputStream();
      out.write(json.getBytes());
      out.flush();
      out.close();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }


  }
  
}
