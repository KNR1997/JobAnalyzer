package com.ecommerce.demo.controller;

import com.ecommerce.demo.entity.Company;
import com.ecommerce.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getAllCompanies")
    public List<Company> findAllCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping(value = "/saveCompany", consumes = "application/json")
    public Company saveCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

}
