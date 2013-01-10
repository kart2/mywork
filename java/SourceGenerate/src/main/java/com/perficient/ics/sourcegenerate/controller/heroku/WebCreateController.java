package com.perficient.ics.sourcegenerate.controller.heroku;

import java.util.*;
import java.net.*;
import java.io.*;
import org.apache.commons.lang.WordUtils;

import com.perficient.ics.sourcegenerate.model.*;

public class WebCreateController {
  private String source;
  public WebCreateController(Project project) {

    StringBuilder sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("package " + project.getPackageName() + ";\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("import java.util.*;\n");
    sourceBuilder.append("import java.net.*;\n");
    sourceBuilder.append("import java.io.*;\n");
    sourceBuilder.append("import java.sql.*;\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("import org.apache.commons.exec.CommandLine;\n");
    sourceBuilder.append("import org.apache.commons.exec.DefaultExecutor;\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("import javax.servlet.ServletException;\n");
    sourceBuilder.append("import javax.servlet.ServletOutputStream;\n");
    sourceBuilder.append("import javax.servlet.annotation.WebServlet;\n");
    sourceBuilder.append("import javax.servlet.http.HttpServlet;\n");
    sourceBuilder.append("import javax.servlet.http.HttpServletRequest;\n");
    sourceBuilder.append("import javax.servlet.http.HttpServletResponse;\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("import com.perficient.ics." + project.getProjectName().toLowerCase() + ".model." + project.getClassName() + ";\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("@WebServlet(\n");
    sourceBuilder.append("    name = \"" + project.getClassName() + "CreateController\", \n");
    sourceBuilder.append("    urlPatterns = {\"/" + project.getClassName().toLowerCase() + "-create\"}\n");
    sourceBuilder.append("  )\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("public class " + project.getClassName() + "CreateController extends HttpServlet {\n");
    sourceBuilder.append("  @Override\n");
    sourceBuilder.append("  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {\n");
    sourceBuilder.append("    ServletOutputStream out = resp.getOutputStream();\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    " + project.getClassName() + ".init();\n");
    sourceBuilder.append("\n");


    sourceBuilder.append("    ArrayList<" + project.getClassName() + "> " + project.getClassName().toLowerCase() + "s = new ArrayList<" + project.getClassName() + ">();\n");
    sourceBuilder.append("    " + project.getClassName().toLowerCase() + "s.add(new " + project.getClassName() + "(0, \"Weather\"   , \"" + project.getProjectName().toLowerCase() + " Info Weather KJQF\"));\n");
     sourceBuilder.append("    " + project.getClassName().toLowerCase() + "s.add(new " + project.getClassName() + "(0, \"Time\"   , \"" + project.getProjectName().toLowerCase() + " Info Time\"));\n");

/*
    for(Property property : project.getProperties()) {
      if(property.getType().equals("String")) {
        sourceBuilder.append();
      } else if(property.getType().equals("int")) {
        sourceBuilder.append(); 
      }

    }
*/

    sourceBuilder.append("\n");
    sourceBuilder.append("    " + project.getClassName() + ".create(" + project.getClassName().toLowerCase() + "s);\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    out.write(\"<html>\".getBytes());\n");
    sourceBuilder.append("    out.write(\"<body>\".getBytes());\n");
    sourceBuilder.append("    out.write(\"<h2>Created " + project.getClassName() + "s</h2>\".getBytes());\n");
    sourceBuilder.append("    out.write(\"<ul>\".getBytes());\n");
    sourceBuilder.append("    for(" + project.getClassName() + " " + project.getClassName().toLowerCase() + " : " + project.getClassName().toLowerCase() + "s) {\n");
    sourceBuilder.append("      out.write(\"<li>\".getBytes());\n");
    sourceBuilder.append("      out.write(" + project.getClassName().toLowerCase() + ".getName().getBytes());\n");
    sourceBuilder.append("      out.write(\"</li>\".getBytes());\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("      /*\n");
    sourceBuilder.append("      CommandLine cmdLine = CommandLine.parse(" + project.getClassName().toLowerCase() + ".getDescription());\n");
    sourceBuilder.append("      DefaultExecutor executor = new DefaultExecutor();\n");
    sourceBuilder.append("      //executor.setExitValue(1);\n");
    sourceBuilder.append("      try {\n");
    sourceBuilder.append("        int exitValue = executor.execute(cmdLine);\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("      catch(Exception ex) {\n");
    sourceBuilder.append("        ex.printStackTrace();\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("      */\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("    out.write(\"</ul>\".getBytes());\n");
    sourceBuilder.append("    out.write(\"<a href='/'>Home</a>\".getBytes());\n");
    sourceBuilder.append("    out.write(\"</body>\".getBytes());\n");
    sourceBuilder.append("    out.write(\"</html>\".getBytes());\n");
    sourceBuilder.append("    \n");
    sourceBuilder.append("    out.flush();\n");
    sourceBuilder.append("    out.close();\n");
    sourceBuilder.append("  }\n");
    sourceBuilder.append("}\n");
    this.source = sourceBuilder.toString();
  }

  /**
   * @param source the source to set
   */
  public void setSource(String source) {
    this.source = source;
  }

  /**
   * @return the source
   */
  public String getSource() {
    return source;
  }
}
