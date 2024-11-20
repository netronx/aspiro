package com.aspiro.notification.internal;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer2 {
    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void consumeNotification(String message) {
        System.out.println("Received message from KafkaConsumer2: " + message);
    }
}
