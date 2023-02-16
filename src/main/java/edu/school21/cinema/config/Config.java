package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@PropertySource("file:${myProperties}") //"WEB-INF/application.properties"
@ComponentScan (basePackages = "edu.school21.cinema")
public class Config {

  @Autowired
  private Environment env;

  @Bean
  DataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();

    dataSource.setJdbcUrl(env.getProperty("db.url"));
    dataSource.setUsername(env.getProperty("db.user"));
    dataSource.setPassword(env.getProperty("db.password"));
    dataSource.setDriverClassName(env.getProperty("db.driver.name"));

    return dataSource;
  }

  @Bean
  public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

}
