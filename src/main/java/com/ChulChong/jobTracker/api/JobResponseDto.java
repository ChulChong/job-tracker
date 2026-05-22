package com.ChulChong.jobTracker.api;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JobResponseDto {
    private List<JobDto> jobs;

    public List<JobDto> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobDto> jobs) {
        this.jobs = jobs;
    }
}
