package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@PropertySource("/WEB-INF/application.properties") //"WEB-INF/application.properties"
@PropertySource("classpath:application.properties")
@ComponentScan (basePackages = "edu.school21.cinema")
public class Config {

//  @Autowired
//  private Environment env;

  @Value("${db.url}")
  private String url;

  @Value("${db.user}")
  private String dbUser;

  @Value("${db.password}")
  private String dbPassword;

  @Value("${db.driver.name}")
  private String dbDriver;


  @Bean
  DataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();

    dataSource.setJdbcUrl(url);
    dataSource.setUsername(dbUser);
    dataSource.setPassword(dbPassword);
    dataSource.setDriverClassName(dbDriver);

    return dataSource;
  }

  @Bean
  public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

}
