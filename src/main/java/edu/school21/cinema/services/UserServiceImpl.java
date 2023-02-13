package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepository;
import java.util.Optional;
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
    Optional<User> result = userRepository.findByNumber(phoneNumber);
    if (result.isPresent()) {
      if (encoder.matches(password, result.get().getPassword())) {
        return result;
      }
    }
    return Optional.empty();
  }

  @Override
  public void SignUp() {

  }
}
