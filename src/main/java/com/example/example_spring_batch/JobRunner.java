package com.example.example_spring_batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.job.SimpleJob;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JobRunner implements ApplicationRunner {

  private final JobLauncher jobLauncher;

  SimpleJob
  private final Job job;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    var param = new JobParametersBuilder()
        .addString("name", "user1")
        .toJobParameters();

    jobLauncher.run(job, param);
  }
}
