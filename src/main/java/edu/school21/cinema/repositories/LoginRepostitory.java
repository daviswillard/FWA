package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Login;
import java.util.List;

public interface LoginRepostitory {
  void saveLogin(Long id, String ipAddress);
  List<Login> getLogin(Long id);
}
