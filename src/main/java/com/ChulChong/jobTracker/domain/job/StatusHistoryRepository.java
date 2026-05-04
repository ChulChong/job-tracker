package com.ChulChong.jobTracker.domain.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusHistoryRepository extends JpaRepository<StatusHistory, Long> {
}
