package com.ChulChong.jobTracker.domain.job;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {
    private final JobApplicationRepository jr;

    JobApplicationService(JobApplicationRepository jr) {
        this.jr = jr;
    }

    public List<JobApplication> findAll() {
        return jr.findAll();
    }

    public JobApplication findById(long id) {
        return jr.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public void save(JobApplication job) {
        jr.save(job);
    }

    public void delete(long id) {
        JobApplication job = jr.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        job.setIsDeleted(true);
        jr.save(job);
    }
}
