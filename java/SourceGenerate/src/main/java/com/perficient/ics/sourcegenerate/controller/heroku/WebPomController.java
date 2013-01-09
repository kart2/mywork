package com.perficient.ics.sourcegenerate.controller.heroku;

import java.util.*;
import java.net.*;
import java.io.*;
import org.apache.commons.lang.WordUtils;

import com.perficient.ics.sourcegenerate.model.*;

public class WebPomController {
  private String source;
  public WebPomController(Project project) {

    StringBuilder sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
    sourceBuilder.append("  xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">\n");
    sourceBuilder.append("  <modelVersion>4.0.0</modelVersion>\n");
    sourceBuilder.append("  <groupId>com.perficient.ics." + project.getProjectName().toLowerCase() + "</groupId>\n");
    sourceBuilder.append("  <artifactId>" + project.getProjectName() + "</artifactId>\n");
    sourceBuilder.append("  <version>1.0-SNAPSHOT</version>\n");
    sourceBuilder.append("  <name>" + project.getProjectName() + "</name>\n");
    sourceBuilder.append("  <url>http://maven.apache.org</url>\n");
    sourceBuilder.append("  <dependencies>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("        <groupId>org.apache.tomcat.embed</groupId>\n");
    sourceBuilder.append("        <artifactId>tomcat-embed-core</artifactId>\n");
    sourceBuilder.append("        <version>7.0.22</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("        <groupId>org.apache.tomcat.embed</groupId>\n");
    sourceBuilder.append("        <artifactId>tomcat-embed-logging-juli</artifactId>\n");
    sourceBuilder.append("        <version>7.0.22</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("        <groupId>org.apache.tomcat.embed</groupId>\n");
    sourceBuilder.append("        <artifactId>tomcat-embed-jasper</artifactId>\n");
    sourceBuilder.append("        <version>7.0.22</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("        <groupId>org.apache.tomcat</groupId>\n");
    sourceBuilder.append("        <artifactId>tomcat-jasper</artifactId>\n");
    sourceBuilder.append("        <version>7.0.22</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("        <groupId>org.apache.tomcat</groupId>\n");
    sourceBuilder.append("        <artifactId>tomcat-jasper-el</artifactId>\n");
    sourceBuilder.append("        <version>7.0.22</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("        <groupId>org.apache.tomcat</groupId>\n");
    sourceBuilder.append("        <artifactId>tomcat-jsp-api</artifactId>\n");
    sourceBuilder.append("        <version>7.0.22</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("      <groupId>org.codehaus.jackson</groupId>\n");
    sourceBuilder.append("      <artifactId>jackson-mapper-asl</artifactId>\n");
    sourceBuilder.append("      <version>1.8.5</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("      <groupId>org.apache.commons</groupId>\n");
    sourceBuilder.append("      <artifactId>commons-exec</artifactId>\n");
    sourceBuilder.append("      <version>1.1</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("      <groupId>postgresql</groupId>\n");
    sourceBuilder.append("      <artifactId>postgresql</artifactId>\n");
    sourceBuilder.append("      <version>9.1-901.jdbc4</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("  </dependencies>\n");
    sourceBuilder.append("  <build>\n");
    sourceBuilder.append("    <finalName>" + project.getProjectName().toLowerCase() + "</finalName>\n");
    sourceBuilder.append("    <plugins>\n");
    sourceBuilder.append("        <plugin>\n");
    sourceBuilder.append("            <groupId>org.codehaus.mojo</groupId>\n");
    sourceBuilder.append("            <artifactId>appassembler-maven-plugin</artifactId>\n");
    sourceBuilder.append("            <version>1.1.1</version>\n");
    sourceBuilder.append("            <configuration>\n");
    sourceBuilder.append("                <assembleDirectory>target</assembleDirectory>\n");
    sourceBuilder.append("                <programs>\n");
    sourceBuilder.append("                    <program>\n");
    sourceBuilder.append("                        <mainClass>com.perficient.ics." + project.getProjectName().toLowerCase() + ".launch.Main</mainClass>\n");
    sourceBuilder.append("                        <name>webapp</name>\n");
    sourceBuilder.append("                    </program>\n");
    sourceBuilder.append("                </programs>\n");
    sourceBuilder.append("            </configuration>\n");
    sourceBuilder.append("            <executions>\n");
    sourceBuilder.append("                <execution>\n");
    sourceBuilder.append("                    <phase>package</phase>\n");
    sourceBuilder.append("                    <goals>\n");
    sourceBuilder.append("                        <goal>assemble</goal>\n");
    sourceBuilder.append("                    </goals>\n");
    sourceBuilder.append("                </execution>\n");
    sourceBuilder.append("            </executions>\n");
    sourceBuilder.append("        </plugin>\n");
    sourceBuilder.append("    </plugins>\n");
    sourceBuilder.append("  </build>\n");
    sourceBuilder.append("</project>\n");
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
