package edu.school21.cinema;

import edu.school21.cinema.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
}
