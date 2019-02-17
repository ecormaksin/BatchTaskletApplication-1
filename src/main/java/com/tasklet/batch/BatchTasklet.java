package com.tasklet.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.tasklet.batch.config.BatchConfig;
import com.tasklet.batch.listener.JobListener;

@Configuration
@EnableBatchProcessing
@Import(BatchConfig.class)
@Profile("default")
public class BatchTasklet {

    @Autowired
    private Tasklet1 tasklet1;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step1() {
        return stepBuilderFactory
                .get("step1")
                .tasklet(tasklet1)
                .build();
    }

    @Bean
    public Job job(Step step1) throws Exception {
        return jobBuilderFactory
                .get("job")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .start(step1)
                .build();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobListener();
    }

}