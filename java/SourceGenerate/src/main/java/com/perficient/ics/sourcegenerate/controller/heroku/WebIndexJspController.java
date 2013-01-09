package com.perficient.ics.sourcegenerate.controller.heroku;

import java.util.*;
import java.net.*;
import java.io.*;
import org.apache.commons.lang.WordUtils;

import com.perficient.ics.sourcegenerate.model.*;

public class WebIndexJspController {
  private String source;
  public WebIndexJspController(Project project) {

    StringBuilder sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("<html>\n");
    sourceBuilder.append("  <head>\n");
    sourceBuilder.append("    <title>" + project.getClassName() + "s</title>\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    <!-- jQuery -->\n");
    sourceBuilder.append("    <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\"></script>\n");
    sourceBuilder.append("    <script script type=\"text/javascript\" src=\"javascript/main-controller.js\">  </script>\n");
    sourceBuilder.append("    <style>\n");
    sourceBuilder.append("      ul {\n");
    sourceBuilder.append("        list-style-type: none;\n");
    sourceBuilder.append("        padding: 0;\n");
    sourceBuilder.append("        margin: 0;\n");
    sourceBuilder.append("        text-align: left;\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("      \n");
    sourceBuilder.append("      li {\n");
    sourceBuilder.append("        vertical-align: middle;\n");
    sourceBuilder.append("        background-image: url(/images/vault-64.png);\n");
    sourceBuilder.append("        background-repeat: no-repeat;\n");
    sourceBuilder.append("        background-position: left top;\n");
    sourceBuilder.append("        padding-bottom: 10px;\n");
    sourceBuilder.append("        padding-top: 5px;\n");
    sourceBuilder.append("        padding-left: 80px;\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("    </style>\n");
    sourceBuilder.append("  </head>\n");
    sourceBuilder.append("  <body>\n");
    sourceBuilder.append("    <script type=\"text/javascript\">\n");
    sourceBuilder.append("      $(function() {\n");
    sourceBuilder.append("        var mainController = new MainController();\n");
    sourceBuilder.append("        mainController." + project.getClassName().toLowerCase() + "List();\n");
    sourceBuilder.append("      });\n");
    sourceBuilder.append("    </script>\n");
    sourceBuilder.append("  </body>\n");
    sourceBuilder.append("</html>\n");
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
