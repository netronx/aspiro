package com.aspiro.notification.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;
    private Long recipientId;  // Profile/User ID of the notification recipient
    private String message;
    private LocalDateTime timestamp;
    private boolean read;      // Mark notification as read/unread
    private String type;       // e.g., "FRIEND_REQUEST", "COMMENT", "LIKE"

}