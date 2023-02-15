package edu.school21.cinema.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/", name = "index")
public class IndexServlet extends HttpServlet {
  //placeholder
  private static String index = "/WEB-INF/index.jsp";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
  throws ServletException, IOException {
    req.getRequestDispatcher(index).forward(req, res);
  }
}
