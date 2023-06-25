package com.ecommerce.demo.dao;

import com.ecommerce.demo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
