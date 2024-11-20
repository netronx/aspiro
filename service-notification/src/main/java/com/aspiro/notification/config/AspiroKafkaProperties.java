package com.aspiro.notification.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.kafka.consumer")
public class AspiroKafkaProperties {

    private String bootstrapServers;
    private String groupId;
    private String autoOffsetReset;
    private String enableAutoCommit;
}
