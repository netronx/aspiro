package com.aspiro.notification.internal;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer1 {
    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void consumeNotification(String message) {
        System.out.println("Received message from KafkaConsumer1: " + message);
    }
}
