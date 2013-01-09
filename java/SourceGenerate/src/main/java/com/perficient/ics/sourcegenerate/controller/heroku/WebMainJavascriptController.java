package com.perficient.ics.sourcegenerate.controller.heroku;

import java.util.*;
import java.net.*;
import java.io.*;
import org.apache.commons.lang.WordUtils;

import com.perficient.ics.sourcegenerate.model.*;

public class WebMainJavascriptController {
  private String source;
  public WebMainJavascriptController(Project project) {

    StringBuilder sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("function MainController() {\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("  this." + project.getClassName().toLowerCase() + "List = " + project.getClassName().toLowerCase() + "List;\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("  function " + project.getClassName().toLowerCase() + "List() {\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    $.getJSON('/" + project.getClassName().toLowerCase() + "-list', function(data) {\n");
    sourceBuilder.append("      var items = [];\n");
    sourceBuilder.append("    \n");
    sourceBuilder.append("      $.each(data, function(index) {\n");
    sourceBuilder.append("        items.push('<li><div style=\"font-weight:bold\">' + data[index].name + '</div><div style=\"font-style:italic\">' + data[index].description + '</div>');\n");
    sourceBuilder.append("      });\n");
    sourceBuilder.append("    \n");
    sourceBuilder.append("      $('<ul />', {\n");
    sourceBuilder.append("        'class': 'content-list',\n");
    sourceBuilder.append("        html: items.join('')\n");
    sourceBuilder.append("      }).appendTo('body');\n");
    sourceBuilder.append("    });\n");
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
