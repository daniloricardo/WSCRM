package nelsys;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@ComponentScan(basePackages="nelsys")
@EnableWebMvc
@Configuration
public class Start {

	 @Bean
		public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
			return entityManagerFactory.createEntityManager();
		}
	 
	 public static void main(String[] args) {
		 SpringApplication app = new SpringApplication(Start.class);
	        app.setShowBanner(false);
	        app.run(args);
	}
}
