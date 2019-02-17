package com.tasklet.batch.windowseventlog.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tasklet.batch.config.test.BatchTestConfig;
import com.tasklet.batch.windowseventlog.WindowsEventLogService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BatchTestConfig.class)
public class WindowsEventLogServiceTest {

    @Autowired
    private WindowsEventLogService windowsEventLogService;

    @Test
    public void 該当するIDを指定したら実行コマンドが返ってくる() {
        assertEquals(
                "EVENTCREATE /ID 0 /L Application /SO APP_TEST /T INFORMATION /D テスト",
                windowsEventLogService.getCommand(0));
    }

}
