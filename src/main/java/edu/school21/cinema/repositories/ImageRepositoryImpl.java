package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.Login;
import edu.school21.cinema.models.User;
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
public class ImageRepositoryImpl implements ImageRepository{

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ImageRepositoryImpl(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public void saveImage(Image image) {
    final String SQL_STR =
        "insert into user_schema.images(owner, realName, uniqueName, mime, size) values (?, ?, ?, ?, ?)";
    jdbcTemplate.update(SQL_STR, image.getOwner().getId(), image.getRealName(), image.getUniqueName(),
        image.getMime(), image.getSize());
  }

  @Override
  public List<Image> findAllByOwner(User owner) {
    final String SQL_STR =
        "select * from user_schema.images where owner=?";
    List<Image> images = jdbcTemplate.query(SQL_STR,
        new Object[]{owner.getId()},
        new int[]{Types.INTEGER},
        new ImageMapper());
    return images;
  }
  //https://mkyong.com/spring/spring-jdbctemplate-querying-examples/
  public class ImageMapper implements RowMapper<Image> {
    @Override
    public Image mapRow(ResultSet resultSet, int i) throws SQLException {
      return new Image(resultSet.getString("realname"),
          resultSet.getString("uniquename"),
          resultSet.getString("mime"),
          resultSet.getLong("size"));
    }
  }
}
