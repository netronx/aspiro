package com.aspiro.notification.service;

import com.aspiro.notification.domain.entity.Notification;

import java.util.List;

public interface NotificationService {
    Notification createNotification(Notification notification);

    List<Notification> getNotificationsByRecipient(Long recipientId);

    Notification markAsRead(String notificationId);
}
