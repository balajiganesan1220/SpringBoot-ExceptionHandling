package com.balaji.exception_handling.serviceImpl;



import com.balaji.exception_handling.entity.Company;
import com.balaji.exception_handling.exception.CompanyNotFoundException;
import com.balaji.exception_handling.repository.CompanyRepository;
import com.balaji.exception_handling.service.CompanyService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;



    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;

    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company companyById(Long id) {
            return companyRepository.findById(id)
                    .orElseThrow(()->new CompanyNotFoundException("Company Not Found with ID: "+ id));

    }

    @Override
    public Company createCompany(Company company) {
        if(company!=null)
        {
            return companyRepository.save(company);
        }
        return null;

    }

}

