package com.ecommerce.demo.service;

import com.ecommerce.demo.dao.JobRepository;
import com.ecommerce.demo.entity.Job;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getJobs(){
        return jobRepository.findAll();
    }

}
