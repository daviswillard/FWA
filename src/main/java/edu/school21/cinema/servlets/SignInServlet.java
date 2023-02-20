package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.ImageRepository;
import edu.school21.cinema.repositories.LoginRepostitory;
import edu.school21.cinema.services.UserService;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;

@WebServlet(urlPatterns = "/signIn", name = "signIn")
public class SignInServlet extends HttpServlet {
  private UserService service;
  private ImageRepository imageRepository;
  private LoginRepostitory loginRepostitory;

  @Override
  public void init() {
    ApplicationContext springContext =
        (ApplicationContext) getServletContext().getAttribute("springContext");
    service = springContext.getBean(UserService.class);
    imageRepository = springContext.getBean(ImageRepository.class);
    loginRepostitory = springContext.getBean(LoginRepostitory.class);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {
    req.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    request.setCharacterEncoding("UTF-8");
    Optional<User> user =
        service.SignIn(request.getParameter("phone"), request.getParameter("password"), request);
    if (user.isPresent()) {
      String ipAddr = request.getRemoteAddr();
      if (ipAddr.equals("0:0:0:0:0:0:0:1")) {
        ipAddr = "127.0.0.1";
      }
      User attribute = user.get();
      loginRepostitory.saveLogin(attribute.getId(), ipAddr);
      attribute.setLogins(loginRepostitory.getLogin(attribute.getId()));
      attribute.setImages(imageRepository.findAllByOwner(attribute));
      HttpSession session = request.getSession();
      session.setAttribute("user", attribute);
      response.sendRedirect("/profile");
    } else {
      response.sendError(403);
    }
  }
}
