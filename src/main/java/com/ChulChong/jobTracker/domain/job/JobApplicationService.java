package com.ChulChong.jobTracker.domain.job;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void delete(long id) {
        JobApplication job = jr.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        job.setIsDeleted(true);
    }

    @Transactional
    public void update(long id, JobApplication updatedJob){
        JobApplication job = jr.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        job.setCompanyName(updatedJob.getCompanyName());
        job.setPosition(updatedJob.getPosition());
    }
}
