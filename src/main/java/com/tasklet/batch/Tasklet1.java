package com.tasklet.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tasklet.batch.service.PrintService;

@Component
public class Tasklet1 implements Tasklet {

    @Autowired
    private PrintService printService;

    @Override
    public RepeatStatus execute(StepContribution contribution,
            ChunkContext chunkContext) throws Exception {
        StepExecution stepExecution = chunkContext
                .getStepContext()
                .getStepExecution();
        BatchStatus status = BatchStatus.COMPLETED;
        try {
            System.out.println("tasklet1!!");
            printService.execute();
            //int a = 10 / 0;
        } catch (Exception e) {
            status = BatchStatus.FAILED;
        }
        stepExecution.setStatus(status);
        return RepeatStatus.FINISHED;
    }

}
