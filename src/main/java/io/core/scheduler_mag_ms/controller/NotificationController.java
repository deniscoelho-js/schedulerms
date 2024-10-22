package io.core.scheduler_mag_ms.controller;

import io.core.scheduler_mag_ms.dto.SchedulerNotificationDto;
import io.core.scheduler_mag_ms.entity.Notification;
import io.core.scheduler_mag_ms.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Void> schedulerNotification(@RequestBody SchedulerNotificationDto dto){
        notificationService.scheduleNotification(dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable("notificationId") Long notificationId){
    var notification = notificationService.findById(notificationId);

    if(notification.isEmpty()){
        return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(notification.get());
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable("notificationId") Long notificationId){
        notificationService.cancelNotification(notificationId);
        return ResponseEntity.noContent().build();
    }
}
