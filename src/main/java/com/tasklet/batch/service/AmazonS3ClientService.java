package com.tasklet.batch.service;

import java.io.File;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import lombok.Getter;
import lombok.Setter;

public class AmazonS3ClientService {

    @Setter
    @Getter
    String serviceEndpoint;

    @Setter
    @Getter
    String signingRegion;

    @Setter
    @Getter
    String accessKey;

    @Setter
    @Getter
    String secretKey;

    @Setter
    @Getter
    String bucketName;

    public void upload(String key, File file) {
        // 認証情報
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        // エンドポイント設定
        EndpointConfiguration endpointConfiguration = new EndpointConfiguration(
                serviceEndpoint,
                signingRegion);

        // クライアント設定
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProtocol(Protocol.HTTPS); // プロトコル
        clientConfig.setConnectionTimeout(10000); // 接続タイムアウト(ms)
        
        // クライアント生成
        AmazonS3 client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withClientConfiguration(clientConfig)
                .withEndpointConfiguration(endpointConfiguration)
                .withPathStyleAccessEnabled(true)
                .build();

        client.putObject(new PutObjectRequest(bucketName, key, file));
    }

}
