package io.core.scheduler_mag_ms.dto;

import io.core.scheduler_mag_ms.entity.Channel;
import io.core.scheduler_mag_ms.entity.Notification;
import io.core.scheduler_mag_ms.entity.Status;

import java.time.LocalDateTime;

public record SchedulerNotificationDto(LocalDateTime dateTime, String destination, String message, Channel.Values channel) {

    public Notification toNotification(){
        LocalDateTime adjustedDateTime = dateTime.minusHours(3);

        return new Notification( adjustedDateTime, destination, message, channel.toChannel(), Status.Values.PENDING.toStatus());
    }
}
