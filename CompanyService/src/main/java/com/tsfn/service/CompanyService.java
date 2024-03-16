package com.tsfn.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsfn.model.Company;
import com.tsfn.repository.CompanyRepository;
import com.tsfn.service.exceptions.CompanyAlreadyExistsException;
import com.tsfn.service.exceptions.CompanyNotFoundException;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository ;
	
	
	public Company login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public Company getCompanyById(int companyId) throws CompanyNotFoundException {
       
		Optional<Company> company = companyRepository.findById(companyId);
        if (company == null) {
            throw new CompanyNotFoundException("Company with ID " + companyId + " not found");
        }
        return company.get();
    }
	
	

	public void deleteCompany(int companyId) throws CompanyNotFoundException {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("Company with ID " + companyId + " not found"));
        companyRepository.delete(company);
    }
	
	
	 public Company updateCompany(Company company) throws CompanyNotFoundException {
	        int companyId = company.getId();
	        if (!companyRepository.existsById(companyId)) {
	            throw new CompanyNotFoundException("Company with ID " + companyId + " not found");
	        }
	        return companyRepository.save(company);
	    }

	    public Company createCompany(Company company) throws CompanyAlreadyExistsException {
	        String email = company.getEmail();
	        if (companyRepository.existsByEmail(email)) {
	            throw new CompanyAlreadyExistsException("Company with email " + email + " already exists");
	        }
	        return companyRepository.save(company);
	    }
	
	
}
