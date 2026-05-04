package com.ChulChong.jobTracker.domain.job;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "status_history")
@Entity
@Getter
@NoArgsConstructor
public class StatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_application_id", nullable = false)
    private JobApplication application;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus previousStatus;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus newStatus;
    private LocalDateTime changedAt;

    @PrePersist
    protected void OnChange() {
        this.changedAt = LocalDateTime.now();
    }
}
