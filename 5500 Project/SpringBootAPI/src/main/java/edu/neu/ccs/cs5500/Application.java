package edu.neu.ccs.cs5500;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("edu.neu.ccs.cs5500.repository")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
