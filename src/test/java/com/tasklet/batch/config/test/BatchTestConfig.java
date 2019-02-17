package com.tasklet.batch.config.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.tasklet.batch.config.BatchConfig;

@Configuration
@ComponentScan("com.tasklet.batch")
@Import(BatchConfig.class)
@Profile("test")
public class BatchTestConfig {
}
