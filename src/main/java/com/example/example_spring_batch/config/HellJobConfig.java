package com.example.example_spring_batch.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class HellJobConfig {

  private final JobBuilderFactory jobBuilderFactory;

  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job helloJob() {
    return jobBuilderFactory.get("helloJob")
        .incrementer(jobParametersIncrementer())
        .start(helloStep1())
        .next(helloStep2())
        .build();
  }

  @Bean
  public JobParametersIncrementer jobParametersIncrementer() {
    return new RunIdIncrementer();
  }

  @Bean
  public Step helloStep2() {
    return stepBuilderFactory.get("helloStep4")
        .tasklet(((contribution, chunkContext) -> {
//          contribution.getStepExecution().getJobParameters().getParameters().get("dfd")
          log.info("Hello Spring Batch");
          return RepeatStatus.FINISHED;
        })).build();
  }

  @Bean
  public Step helloStep1() {
    return stepBuilderFactory.get("helloStep3")
        .tasklet(((contribution, chunkContext) -> {
          var name = contribution.getStepExecution()
              .getJobExecution()
              .getJobParameters()
              .getString("name");
          log.info(name);
          System.out.println(">> step2 was executed");
          return RepeatStatus.FINISHED;
        })).build();
  }
}
