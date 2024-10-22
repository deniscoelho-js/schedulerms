package io.core.scheduler_mag_ms.scheduler;

import io.core.scheduler_mag_ms.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class MsTestScheduler {

    private final NotificationService notificationService;
    private static final Logger logger = LoggerFactory.getLogger(MsTestScheduler.class);

    @Scheduled(fixedDelay = 25, timeUnit = TimeUnit.SECONDS)
    public void checkTasks(){
        var dateTime = LocalDateTime.now();

        logger.info("Running at {}", dateTime);
        notificationService.checkAndSend(dateTime);
    }
}
