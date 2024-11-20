package com.aspiro.social.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
//@EnableConfigurationProperties(AspiroKafkaProperties.class)
@Configuration
public class KafkaProducerConfig {
    private final AspiroKafkaProperties aspiroKafkaProperties;

    @Autowired
    public KafkaProducerConfig(AspiroKafkaProperties aspiroKafkaProperties) {
        this.aspiroKafkaProperties = aspiroKafkaProperties;
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, aspiroKafkaProperties.getBootstrapServers());
        configProps.put(ProducerConfig.RETRIES_CONFIG, aspiroKafkaProperties.getRetries());
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        configProps.put(JsonSerializer.TYPE_MAPPINGS, "greeting:com.baeldung.spring.kafka.Greeting, farewell:com.baeldung.spring.kafka.Farewell");
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}