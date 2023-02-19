package edu.school21.cinema.servlets;


import edu.school21.cinema.services.UserService;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

@WebServlet(urlPatterns = "/index", name = "index")
public class IndexServlet extends HttpServlet {
  private UserService service;

  @Override
  public void init() throws ServletException {
    ApplicationContext springContext =
        (ApplicationContext) getServletContext().getAttribute("springContext");
    service = springContext.getBean(UserService.class);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    req.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(req, res);
//    ServletContext app = getServletContext();
//
//    res.setContentType("text/html; charset=UTF-8");
//    PrintWriter writer = new PrintWriter(new OutputStreamWriter(res.getOutputStream(),
//        StandardCharsets.UTF_8), true);
//    String filepath = app.getRealPath("WEB-INF/html/main.html");
//    UtilsServlet.fileWork(writer, filepath);
  }
}
