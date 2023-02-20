package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.User;
import java.util.List;

public interface ImageRepository {
  void saveImage(Image image);
  List<Image> findAllByOwner(User owner);
}
