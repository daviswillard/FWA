package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("application.properties")
@ComponentScan (basePackages = {
    "edu.school21.cinema.services", "edu.school21.cinema.repositories"})
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

}
