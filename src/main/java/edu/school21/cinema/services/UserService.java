package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

public interface UserService {
  Optional<User> SignIn(String phoneNumber, String password, HttpServletRequest request);
  boolean SignUp(HttpServletRequest request);
}