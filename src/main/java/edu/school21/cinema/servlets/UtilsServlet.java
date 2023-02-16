package edu.school21.cinema.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class UtilsServlet {

  static void fileWork(PrintWriter writer, String filepath) throws IOException {
    File file = new File(filepath);

    try (BufferedReader reader
        = new BufferedReader(new FileReader(file))) {
      for (StringBuilder line = new StringBuilder(reader.readLine());
          line != null; line = new StringBuilder(reader.readLine())) {
        writer.println(line);
      }
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    writer.close();
  }
}
