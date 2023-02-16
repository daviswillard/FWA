package edu.school21.cinema.listeners;

import edu.school21.cinema.config.Config;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebListener
public class ContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext context = sce.getServletContext();

    AnnotationConfigApplicationContext configApplicationContext
        = new AnnotationConfigApplicationContext(Config.class);

    context.setAttribute("springContext", configApplicationContext);
  }
}
