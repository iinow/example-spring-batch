package com.example.example_spring_batch;

import com.example.example_spring_batch.config.KeyProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@EnableConfigurationProperties(KeyProperties.class)
@Validated
@RequiredArgsConstructor
@Component
public class JobRunner implements ApplicationRunner {

  private final JobLauncher jobLauncher;

  private final Job job;

  private final KeyProperties keyProperties;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    var param = new JobParametersBuilder()
        .addString("name", "user9")
        .toJobParameters();

    jobLauncher.run(job, param);
  }
}
