package edu.school21.cinema.servlets;

import java.io.BufferedWriter;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/signIn", name = "signIn")
public class SignInServlet extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext context = config.getServletContext();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.setContentType("text/html");
    BufferedWriter bufferedWriter = new BufferedWriter(response.getWriter());
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) {

  }
}
