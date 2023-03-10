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

@WebFilter(filterName = "AuthenticationFilter",
urlPatterns = {"/signIn", "/signUp"})
public class AuthenticationFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    User user = (User) request.getSession().getAttribute("user");

    if (user != null) {
      response.sendRedirect("/profile");
    } else {
      filterChain.doFilter(request, response);
    }
  }

}
