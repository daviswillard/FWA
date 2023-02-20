package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class LoginRepostitoryImpl implements
    LoginRepostitory {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public LoginRepostitoryImpl(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public void saveLogin(Long id, String ipAddress) {
    jdbcTemplate.update("insert into user_schema.logins(owner, ipaddress) values (?, ?)", id, ipAddress);
  }

  @Override
  public List<Login> getLogin(Long id) {
    List<Login> logins = jdbcTemplate.query("select * from user_schema.logins where owner=?",
        new Object[]{id},
        new int[]{Types.INTEGER},
        new LoginMapper());
    return logins;
  }

  public class LoginMapper implements RowMapper<Login> {
    @Override
    public Login mapRow(ResultSet resultSet, int i) throws SQLException {
      return new Login(resultSet.getString("ipaddress"),
          resultSet.getTimestamp("logintime"));
    }
  }
}
