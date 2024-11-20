package com.aspiro.notification.controller;

import com.aspiro.notification.service.NotificationService;
import com.aspiro.notification.domain.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/create")
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    @GetMapping("/recipient/{recipientId}")
    public List<Notification> getNotificationsByRecipient(@PathVariable Long recipientId) {
        return notificationService.getNotificationsByRecipient(recipientId);
    }

    @PutMapping("/read/{id}")
    public Notification markAsRead(@PathVariable String id) {
        return notificationService.markAsRead(id);
    }
}
