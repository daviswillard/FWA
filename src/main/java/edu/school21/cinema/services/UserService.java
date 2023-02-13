package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import java.util.Optional;

public interface UserService {
  Optional<User> SignIn(String phoneNumber, String password);
  void SignUp();
}