package com.balaji.exception_handling.controller;

import com.balaji.exception_handling.service.CompanyService;
import com.balaji.exception_handling.entity.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/companies")
public class companyController {
    private final CompanyService companyService;

    public companyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        List<Company> companies=companyService.getAllCompanies();
            return companies.isEmpty()
                   ? new ResponseEntity<>(companies,HttpStatus.NO_CONTENT)
                   : new ResponseEntity<>(companies,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> companyById(@PathVariable Long id){
            Company company = companyService.companyById(id);
            return new ResponseEntity<>(company, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        Company createdCompany = companyService.createCompany(company);
            return new ResponseEntity<>("Successfully Created", HttpStatus.CREATED);
    }

}
