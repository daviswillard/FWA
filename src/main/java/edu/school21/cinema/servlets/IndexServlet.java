package edu.school21.cinema.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/", name = "index")
public class IndexServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException {
    ServletContext app = getServletContext();

    PrintWriter writer = res.getWriter();
    String filepath = app.getRealPath("WEB-INF/html/index.html");
    File file = new File(filepath);
    try (BufferedReader reader = new BufferedReader(new FileReader(file))){

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
