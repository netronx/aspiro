package com.aspiro.notification.internal;

import com.aspiro.notification.domain.dto.PostDTO;
import com.aspiro.notification.domain.dto.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer1 {
    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void consumeNotification(User postDTO) {
        System.out.println("Received message from KafkaConsumer1: " + postDTO);
    }
}
