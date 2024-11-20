package com.balaji.exception_handling.service;




import com.balaji.exception_handling.entity.Company;

import java.util.List;

public interface CompanyService {
    public List<Company> getAllCompanies();

    public Company companyById(Long id);

    Company createCompany(Company company);

}
