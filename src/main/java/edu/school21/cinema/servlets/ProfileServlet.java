package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.ImageService;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

@MultipartConfig
@WebServlet(name = "profile", urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {
  private String path;
  private ImageService imageService;

  @Override
  public void init() {
    ApplicationContext springContext =
        (ApplicationContext) this.getServletContext().getAttribute("springContext");
    path = springContext.getBean("path", String.class);
    imageService = springContext.getBean(ImageService.class);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    User user = (User) req.getSession().getAttribute("user");
    req.getSession().setAttribute("path", this.path);
    int size = user.getImages().size();
    if (size > 0) {
      String uniqueName = user.getImages().get(size - 1).getUniqueName();
      try (InputStream is = Files.newInputStream(Paths.get(path + File.separator + uniqueName))) {
        byte[] array = IOUtils.toByteArray(is);
        req.getSession().setAttribute("img", Base64.getEncoder().encodeToString(array));
      } catch (NoSuchFileException ignored) {

      }
    }
    req.getRequestDispatcher("/WEB-INF/jsp/realprofile.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Part part = req.getPart("file");
    File file = new File(path + File.separator);
    if (part.getSize() > 0) {
      file.mkdir();
      imageService.saveImage(req, part, path);
    }
    part.delete();
    resp.sendRedirect("/profile");
  }
}
