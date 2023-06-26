package com.ecommerce.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_company")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "details")
    private String details;

}
