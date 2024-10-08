package com.dam.Notifications.controller;

import com.dam.Notifications.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNotification(@RequestParam Long userId,
                                                  @RequestParam String message,
                                                  @RequestParam String notificationType,
                                                  @RequestParam String dueDate) {
        try {
            LocalDate parsedDate = LocalDate.parse(dueDate);
            notificationService.addNotification(userId, message, notificationType, parsedDate);
            return ResponseEntity.ok("Notification added successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding notification: " + e.getMessage());
        }
    }
}
