package edu.school21.cinema.servlets;

import edu.school21.cinema.services.UserService;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

@WebServlet(urlPatterns = "/signIn", name = "signIn")
public class SignInServlet extends HttpServlet {
  private UserService service;

  @Override
  public void init() throws ServletException {
    ApplicationContext springContext =
        (ApplicationContext) getServletContext().getAttribute("springContext");
    service = springContext.getBean(UserService.class);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {
    req.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) {

  }
}
