package com.tasklet.batch.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tasklet.batch.config.test.BatchTestConfig;
import com.tasklet.batch.service.PrintService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BatchTestConfig.class)
public class PrintServiceTest {

    @Autowired
    private PrintService printService;

    @Value("${app.test}")
    String appTest;

    @Test
    public void test() {
        System.out.println("app.test: " + appTest);
        printService.execute();
    }
}
