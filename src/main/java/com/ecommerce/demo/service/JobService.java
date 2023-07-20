package com.ecommerce.demo.service;

import com.ecommerce.demo.dao.JobRepository;
import com.ecommerce.demo.dto.JobDTO;
import com.ecommerce.demo.entity.Job;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobService {

    private final JobRepository jobRepository;

    public Job createJobFromDTO(JobDTO jobDTO) {
        Job job = new Job();
        job.setCompanyName(jobDTO.getCompanyName());
        job.setTechnology(jobDTO.getTechStack());
        job.setDesignation(jobDTO.getDesignation());
        job.setRequirement(jobDTO.getRequirement());

        return job;
    }
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    public void addJob(Job job) {
        jobRepository.save(job);
    }

}
