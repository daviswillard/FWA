package edu.school21.cinema.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public interface ImageService {
  void saveImage(HttpServletRequest request, Part part, String path);
}
