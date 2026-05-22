package com.ChulChong.jobTracker.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/jobs")
public class JobSearchController {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://himalayas.app/jobs/api";

    @GetMapping("/search")
    public ResponseEntity<JobResponseDto> searchJobs() {
        JobResponseDto result = restTemplate.getForObject(BASE_URL, JobResponseDto.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/filter")
    public ResponseEntity<JobResponseDto> filterJobs(@RequestParam String keyword) {
        try {
            JobResponseDto result = restTemplate.getForObject(BASE_URL, JobResponseDto.class);
            List<JobDto> list = result.getJobs();
            List<JobDto> ans = list.stream().filter(c -> c.getTitle().toLowerCase().contains(keyword) ||
                    c.getCategories().stream().anyMatch(t -> t.toLowerCase().contains(keyword.toLowerCase())))
                    .collect(Collectors.toList());

            JobResponseDto response = new JobResponseDto();
            response.setJobs(ans);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
