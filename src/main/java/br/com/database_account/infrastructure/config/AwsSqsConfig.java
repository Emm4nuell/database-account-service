package br.com.database_account.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.time.Duration;

@Configuration
public class AwsSqsConfig {

    @Value("${aws.region}")
    private String region;
    @Value("${aws.access-key}")
    private String accessKey;
    @Value("${aws.secret-key}")
    private String secretKey;

    @Bean
    public SqsAsyncClient sqsAsyncClient(){
        return SqsAsyncClient
                .builder()
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
                .overrideConfiguration(ClientOverrideConfiguration
                        .builder()
//                        .apiCallTimeout(Duration.ofSeconds(30)) // Tempo total para a chamada da API
//                        .apiCallAttemptTimeout(Duration.ofSeconds(10)) // Tempo para cada tentativa de chamada
                        .build())
                .region(Region.of(region))
                .build();
    }
}
