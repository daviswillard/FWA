package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder encoder;

  @Autowired
  public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
    this.userRepository = repository;
    this.encoder = encoder;
  }

  @Override
  public Optional<User> SignIn(String phoneNumber, String password) {
    if (phoneNumber.isEmpty()) {
      return Optional.empty();
    }
    Optional<User> result = userRepository.findByNumber(phoneNumber);
    if (result.isPresent()) {
      if (encoder.matches(password, result.get().getPassword())) {
        return result;
      }
    }
    return Optional.empty();
  }

  @Override
  public boolean SignUp(HttpServletRequest request) {
    User user;

    String name = request.getParameter("first_name");
    String lastName = request.getParameter("last_name");
    String phoneNumber = request.getParameter("phone");
    String password = request.getParameter("password");


    if (name.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
      return false;
    }
    //Pattern class
    if (!phoneNumber.matches("\\+\\d{11}") && !phoneNumber.matches("\\d{11}")) {
      return false;
    }

    user = new User(name, lastName, phoneNumber, encoder.encode(password));

    List<User> list;
    list = userRepository.findAll();
    for (User iter: list) {
      if (iter.equals(user)) {
        return false;
      }
    }
    userRepository.save(user);
    return true;
  }
}
