package com.example.example_spring_batch.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class HellJobConfig {

  private final JobBuilderFactory jobBuilderFactory;

  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job helloJob() {
    return jobBuilderFactory.get("helloJob")
        .start(helloStep1())
        .next(helloStep2())
        .build();
  }

  @Bean
  public Step helloStep2() {
    return stepBuilderFactory.get("helloStep4")
        .tasklet(((contribution, chunkContext) -> {
//          contribution.getStepExecution().getJobParameters().getParameters().get("dfd")
          System.out.println("Hello Spring Batch");
          return RepeatStatus.FINISHED;
        })).build();
  }

  @Bean
  public Step helloStep1() {
    return stepBuilderFactory.get("helloStep3")
        .tasklet(((contribution, chunkContext) -> {
          System.out.println(">> step2 was executed");
          return RepeatStatus.FINISHED;
        })).build();
  }
}
