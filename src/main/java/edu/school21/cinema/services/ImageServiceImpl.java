package edu.school21.cinema.services;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.ImageRepository;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.io.IOUtils;

@Service
public class ImageServiceImpl implements ImageService{
  private ImageRepository imageRepository;

  @Autowired
  public ImageServiceImpl(ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  @Override
  public void saveImage(HttpServletRequest request, Part part, String path) {
    String mime = part.getContentType();
    String uniqName = getUniqueName(mime);
    File file = new File(Paths.get(path + File.separator + uniqName).toUri());
    try(FileOutputStream output = new FileOutputStream(file)) {
      InputStream is = part.getInputStream();
      byte[] array = IOUtils.toByteArray(is);
      output.write(array);
      request.getSession().setAttribute("img", Base64.getEncoder().encodeToString(array));
      is.close();

      User user = (User) request.getSession().getAttribute("user");
      Image image = new Image(user, getFileName(part), uniqName, mime, part.getSize());
      imageRepository.saveImage(image);
      user.getImages().add(image);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private String getUniqueName(String mime) {
    String type = "." + mime.split("/")[1];
    return UUID.randomUUID().toString().replace("-", "") + type;
  }

  private String getFileName(Part part) {
    String[] content = part.getHeader("content-disposition").split("; ");
    for (String string : content) {
      if (string.startsWith("filename")) {
        return string.substring(string.indexOf('=') + 2, string.length() - 1);
      }
    }
    return null;
  }
}
