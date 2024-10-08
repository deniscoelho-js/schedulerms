package io.core.scheduler_mag_ms.repository;

import io.core.scheduler_mag_ms.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
