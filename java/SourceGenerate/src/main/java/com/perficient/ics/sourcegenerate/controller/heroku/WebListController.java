package com.perficient.ics.sourcegenerate.controller.heroku;

import java.util.*;
import java.net.*;
import java.io.*;
import org.apache.commons.lang.WordUtils;

import com.perficient.ics.sourcegenerate.model.*;

public class WebListController {
  private String source;
  public WebListController(Project project) {

    StringBuilder sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("package " + project.getPackageName() + ";\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("import java.io.IOException;\n");
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
    sourceBuilder.append("    name = \"" + project.getClassName() + "ListController\", \n");
    sourceBuilder.append("    urlPatterns = {\"/" + project.getClassName().toLowerCase() + "-list\"}\n");
    sourceBuilder.append("  )\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("public class " + project.getClassName() + "ListController extends HttpServlet {\n");
    sourceBuilder.append("  @Override\n");
    sourceBuilder.append("  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {\n");
    sourceBuilder.append("    ServletOutputStream out = resp.getOutputStream();\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    ArrayList<" + project.getClassName() + "> " + project.getClassName().toLowerCase() + "s = null;\n");
    sourceBuilder.append("    try {\n");
    sourceBuilder.append("      " + project.getClassName().toLowerCase() + "s = " + project.getClassName() + ".list();\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("    catch(Exception ex) {\n");
    sourceBuilder.append("      ex.printStackTrace();\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    String json = " + project.getClassName() + ".toJson(" + project.getClassName().toLowerCase() + "s);\n");
    sourceBuilder.append("    out.write(json.getBytes());\n");
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
