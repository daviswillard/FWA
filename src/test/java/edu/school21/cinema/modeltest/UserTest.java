package edu.school21.cinema.modeltest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepositoryImpl;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

  private static DataSource dataSource;
  private static UserRepositoryImpl repository;

  @Test
  public void testUser() {
    User user = new User(0L, "Kamil", "Zinatullin", "88005553535");
    user.setPassword("SuP3p_p@ssword");
    System.out.println(user);
  }

  @BeforeClass
  public static void init() {
    HikariConfig config = new HikariConfig();

    {
      config.setJdbcUrl("jdbc:postgresql://localhost:5432/newDataBase");
      config.setUsername("kamil");
      config.setPassword("qwe");
    }

    dataSource = new HikariDataSource(config);
    repository = new UserRepositoryImpl(dataSource);
  }

  @Test
  public void testConnection() throws SQLException {
    Connection connection = dataSource.getConnection();
    assertNotNull(connection);
  }

  @Test
  public void testCreateAndRead() {
    User user = new User(1L, "Kamil", "Zinatullin", "88005553535");
    user.setPassword("SuP3p_p@ssword");

    repository.save(user);
    assertEquals(user, repository.findById(1L));
  }
}
