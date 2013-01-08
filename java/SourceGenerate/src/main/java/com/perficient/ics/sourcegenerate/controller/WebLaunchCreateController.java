package com.perficient.ics.sourcegenerate.controller;

import java.util.*;
import java.net.*;
import java.io.*;
import org.apache.commons.lang.WordUtils;

import com.perficient.ics.sourcegenerate.model.*;

public class WebLaunchCreateController {
  private String source;
  public WebLaunchCreateController(Project project) {

    StringBuilder sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("package com.perficient.ics." + project.getProjectName().toLowerCase() + ".launch;\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("import java.io.File;\n");
    sourceBuilder.append("import org.apache.catalina.startup.Tomcat;\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("public class Main {\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("  public static void main(String[] args) throws Exception {\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    String webappDirLocation = \"src/main/webapp/\";\n");
    sourceBuilder.append("    Tomcat tomcat = new Tomcat();\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    //The port that we should run on can be set into an environment variable\n");
    sourceBuilder.append("    //Look for that variable and default to 8080 if it isn't there.\n");
    sourceBuilder.append("    String webPort = System.getenv(\"PORT\");\n");
    sourceBuilder.append("    if(webPort == null || webPort.isEmpty()) {\n");
    sourceBuilder.append("      webPort = \"8080\";\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    tomcat.setPort(Integer.valueOf(webPort));\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    tomcat.addWebapp(\"/\", new File(webappDirLocation).getAbsolutePath());\n");
    sourceBuilder.append("    System.out.println(\"configuring app with basedir: \" + new File(\"./\" + webappDirLocation).getAbsolutePath());\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    tomcat.start();\n");
    sourceBuilder.append("    tomcat.getServer().await();  \n");
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
