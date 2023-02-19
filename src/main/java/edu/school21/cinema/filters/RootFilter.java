package edu.school21.cinema.filters;

import edu.school21.cinema.models.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "IndexFilter")
public class RootFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String url = request.getRequestURI();
    System.out.println(url);
    if (url.equals("/")) {
      User user = (User) request.getSession().getAttribute("user");

      if (user != null) {
        response.sendRedirect("/profile");
      }
      response.sendRedirect("/index");
    } else {
      filterChain.doFilter(request, response);
    }
  }
}
