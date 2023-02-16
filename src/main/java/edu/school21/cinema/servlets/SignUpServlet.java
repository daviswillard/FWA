package edu.school21.cinema.servlets;



import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/signUp", name = "signUp")
public class SignUpServlet extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext context = config.getServletContext();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    ServletContext app = getServletContext();

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(response.getOutputStream(),
        StandardCharsets.UTF_8), true);
    String filepath = app.getRealPath("WEB-INF/html/registration.html");
    UtilsServlet.fileWork(writer, filepath);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) {

  }
}
