package edu.school21.cinema.servlets;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/", name = "index")
public class IndexServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
  throws IOException {
    ServletContext app = getServletContext();

    res.setContentType("text/html; charset=UTF-8");
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(res.getOutputStream(),
        StandardCharsets.UTF_8), true);
    String filepath = app.getRealPath("WEB-INF/html/enter.html");
    UtilsServlet.fileWork(writer, filepath);
  }
}
