package com.aspiro.social.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.kafka.producer")
public class AspiroKafkaProperties {
    private String bootstrapServers;
    private String topic;
    private int retries;
}
