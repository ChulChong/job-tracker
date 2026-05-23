package com.ChulChong.jobTracker.domain.job;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobApplicationController {

    private final JobApplicationService js;

    JobApplicationController(JobApplicationService js) {
        this.js = js;
    }

    @GetMapping
    public ResponseEntity<List<JobApplication>> getJob() {
        try {
            return ResponseEntity.ok(js.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> postJob(@RequestBody JobApplication job) {
        try {
            js.save(job);
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable long id) {
        try {
            js.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getById(@PathVariable long id) {
        try {
            JobApplication response = js.findById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> putById(@PathVariable long id, @RequestBody JobApplication updatedJob) {
        try {
            js.update(id, updatedJob);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
