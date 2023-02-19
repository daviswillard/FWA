package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public UserRepositoryImpl(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public User findById(Long id) {
    final String SQL_STR = "select * from user_schema.users where id = ?";
    return jdbcTemplate
        .queryForObject(SQL_STR, new BeanPropertyRowMapper<>(User.class), id);
  }

  @Override
  public List<User> findAll() {
    final String SQL_STR = "select * from user_schema.users";
    return jdbcTemplate.query(SQL_STR, new BeanPropertyRowMapper<>(User.class));
  }

  @Override
  public void save(User entity) {
    final String SQL_STR = "insert into user_schema.users (firstName, lastName, phoneNumber, password)"
        + " values (?, ?, ?, ?)";

    jdbcTemplate.update(SQL_STR,
        entity.getFirstName(), entity.getLastName(), entity.getPhoneNumber(), entity.getPassword());
  }

  @Override
  public void update(User entity) {
    final String SQL_STR = "update user_schema.users set phonenumber = ?, password = ? where id = ?";
    jdbcTemplate.update(SQL_STR, entity.getPhoneNumber(), entity.getPassword(), entity.getId());
  }

  @Override
  public void delete(Long id) {
    jdbcTemplate.update("delete from user_schema.users where id = ?", id);
  }

  @Override
  public Optional<User> findByName(String firstName, String lastName) {
    final String SQL_STR = "select * from user_schema.users where (firstname = ? and lastname = ?)";
    return jdbcTemplate.query(SQL_STR, new BeanPropertyRowMapper<>(User.class), firstName, lastName)
        .stream().findAny();
  }

  @Override
  public Optional<User> findByNumber(String phoneNumber) {
    final String SQL_STR = "select * from user_schema.users where phonenumber = ?";
    return jdbcTemplate.query(SQL_STR, new BeanPropertyRowMapper<>(User.class), phoneNumber)
        .stream().findAny();
  }
}
