package com.tasklet.batch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("com.tasklet.batch")
@Import({
        LocalConfig.class,
        DevelopConfig.class,
        ProductionConfig.class
})
@Profile("common")
public class BatchConfig {

}
