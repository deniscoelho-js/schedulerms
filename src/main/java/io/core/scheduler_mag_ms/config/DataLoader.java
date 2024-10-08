package io.core.scheduler_mag_ms.config;

import io.core.scheduler_mag_ms.entity.Channel;
import io.core.scheduler_mag_ms.entity.Status;
import io.core.scheduler_mag_ms.repository.ChannelRepository;
import io.core.scheduler_mag_ms.repository.StatusRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;

    private final StatusRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(Status.Values.values())
                .map(Status.Values::toStatus)
                .forEach(statusRepository::save);
    }
}
