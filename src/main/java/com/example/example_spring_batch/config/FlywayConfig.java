package com.example.example_spring_batch.config;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class FlywayConfig implements ApplicationRunner {

  private final DataSource dataSource;

  @Bean
  public Flyway flyway() {
    return Flyway.configure().dataSource(dataSource).load();
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    flyway().migrate();
  }
}
