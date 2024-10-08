package io.core.scheduler_mag_ms.repository;

import io.core.scheduler_mag_ms.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
