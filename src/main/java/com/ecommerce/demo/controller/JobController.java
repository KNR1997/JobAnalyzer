package com.ecommerce.demo.controller;

import com.ecommerce.demo.dto.JobDTO;
import com.ecommerce.demo.entity.Job;
import com.ecommerce.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/getAllJobs")
    public List<Job> findAllJobs() {
        return jobService.getJobs();
    }

    @PostMapping(value = "/addJob")
    public void saveJob(@RequestBody JobDTO jobDTO) {
        Job job = jobService.createJobFromDTO(jobDTO);
        jobService.addJob(job);
    }

}
