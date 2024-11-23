//package com.aspiro.notification.config;
//
//import com.aspiro.notification.domain.dto.PostDTO;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.IntegerDeserializer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@EnableKafka
////@EnableConfigurationProperties(KafkaProperties.class)
//@Configuration
//public class KafkaConsumerConfig {
//    private final AspiroKafkaProperties aspiroKafkaProperties;
//
//    @Autowired
//    public KafkaConsumerConfig(AspiroKafkaProperties aspiroKafkaProperties) {
//        this.aspiroKafkaProperties = aspiroKafkaProperties;
//    }
//
//    @Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, aspiroKafkaProperties.getBootstrapServers());
//        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, aspiroKafkaProperties.getGroupId());
////        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
////        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
////        configProps.put(JsonDeserializer.TYPE_MAPPINGS, "post:com.aspiro.notification.domain.dto.PostDTO");
//
////        configProps.put(JsonDeserializer.VALUE_DEFAULT_TYPE, PostDTO.class);
////        configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
//
//        return new DefaultKafkaConsumerFactory<>(configProps);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
//}