package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User>{
  Optional<User> findByName(String firstName, String lastName);
  Optional<User> findByNumber(String phoneNumber);
}
