package edu.school21.cinema.servlets;


import edu.school21.cinema.repositories.ImageRepository;
import edu.school21.cinema.repositories.LoginRepostitory;
import edu.school21.cinema.services.UserService;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

@WebServlet(urlPatterns = "/image/*", name = "image")
public class ImageServlet extends HttpServlet {
  private UserService service;
  private ImageRepository imageRepository;
  private LoginRepostitory loginRepostitory;
  private String path;

  @Override
  public void init() {
    ApplicationContext springContext =
        (ApplicationContext) getServletContext().getAttribute("springContext");
    service = springContext.getBean(UserService.class);
    imageRepository = springContext.getBean(ImageRepository.class);
    loginRepostitory = springContext.getBean(LoginRepostitory.class);
    path = springContext.getBean("path", String.class);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    String filename = URLDecoder.decode(req.getPathInfo().substring(1), "UTF-8");
    File file = new File(path, filename);
    resp.setHeader("Content-Type", getServletContext().getMimeType(filename));
    resp.setHeader("Content-Length", String.valueOf(file.length()));
    resp.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
    Files.copy(file.toPath(), resp.getOutputStream());
  }
}
