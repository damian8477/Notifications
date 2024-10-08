package com.dam.Notifications.service;

import com.dam.Notifications.entity.Notification;
import com.dam.Notifications.entity.User;
import com.dam.Notifications.repository.NotificationRepository;
import com.dam.Notifications.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    public Notification addNotification(Long userId, String message, String notificationType, LocalDate dueDate) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + userId + " not found"));

        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notification.setNotificationType(notificationType);
        notification.setDueDate(dueDate);
        notification.setSent(false);

        return notificationRepository.save(notification);
    }
}
