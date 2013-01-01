package com.perficient.ics.javasource.controller;

import java.util.*;
import java.net.*;
import java.io.*;

public class ModelCreateController {
  public ModelCreateController() {
    String projectName = "test";
    String className   = "Model";

    StringBuilder sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("package com.perficient.")
                 .append(projectName)
                 .append(";\n\n");

    // Class definition
    sourceBuilder.append("public class ")
                 .append(className)
                 .append(" {\n");

    // End Class definition
    sourceBuilder.append("}\n");

    System.out.println(sourceBuilder.toString());
  }
}
