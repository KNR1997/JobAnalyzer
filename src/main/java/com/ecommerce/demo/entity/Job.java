package com.ecommerce.demo.entity;

import com.ecommerce.demo.dto.JobDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_job")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "technology")
    private String technology;

    @Column(name = "designation")
    private String designation;

    @Column(name = "requirement")
    private String requirement;

}
