package com.dam.Notifications.repository;

import com.dam.Notifications.entity.Notification;
import com.dam.Notifications.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUser(User user);
    List<Notification> findByDueDateBefore(LocalDate date);
    List<Notification> findByIsSentFalse();
}
