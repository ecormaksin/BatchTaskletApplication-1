package com.tasklet.batch.service.test;

//import static org.junit.Assert.*;

import java.io.File;
import java.net.URI;
import java.net.URL;

import org.junit.Test;

import com.tasklet.batch.service.AmazonS3ClientService;

public class AmazonS3ClientServiceTest {

    @Test
    public void test() throws Exception {

        String fileName = "amazons3upload_test.txt";
        URL url = ClassLoader.getSystemResource(fileName);
        URI uri = url.toURI();
        AmazonS3ClientService clientService = new AmazonS3ClientService();
        clientService.setServiceEndpoint("http://localhost:54572/");
        clientService.setSigningRegion("us-east-1");
        clientService.setAccessKey("dummy");
        clientService.setSecretKey("dummy");
        clientService.setBucketName("bucket-test");
        clientService.upload(fileName, new File(uri));
    }

}
