package com.tasklet.batch.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class PrintService {

    @Autowired
    MessageSource msg;

    @Value("${app.common}")
    String appCommon;

    @Value("${app.test1}")
    String appTest1;

    public void execute() {
        System.out.println(msg.getMessage("E001", null, Locale.JAPAN));
        System.out.println(msg.getMessage("100", null, Locale.JAPAN));
        System.out.println("app.common: " + appCommon);
        System.out.println("app.test1: " + appTest1);
    }
}
