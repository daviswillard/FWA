package edu.school21.cinema.modeltest;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepositoryImpl;
import org.junit.Test;
import javax.sql.DataSource;

public class UserTest {

  private DataSource dataSource;
  private UserRepositoryImpl repository;

  @Test
  public void testUser() {
    User user = new User(0L, "Kamil", "Zinatullin", "88005553535");
    user.setPassword("SuP3p_p@ssword");
    System.out.println(user);
  }
}
