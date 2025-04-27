package com.nik.bankingms.Banking.Management.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nik.bankingms.Banking.Management.system.exception.NoDataFoundException;
import com.nik.bankingms.Banking.Management.system.helper.PasswordGenerator;
import com.nik.bankingms.Banking.Management.system.model.CustomerApplicationDetails;
import com.nik.bankingms.Banking.Management.system.repository.AadharRepo;
import com.nik.bankingms.Banking.Management.system.repository.CustomerApplicationDetailsRepo;
import com.nik.bankingms.Banking.Management.system.repository.EmployeeRepo;
import com.nik.bankingms.Banking.Management.system.repository.PanRepo;

@Service
public class EmployeeService {
	
	@Autowired
	CustomerApplicationDetailsRepo customerApplicationDetailsRepo;

	@Autowired
	PasswordGenerator passwordGenerator;
	@Autowired
	CustomerApplicationIdService customerApplicationIdService;
	
	
	//both
	
	public List<CustomerApplicationDetails> getAllCustomerApplication(){
		return customerApplicationDetailsRepo.findAll();
	}
	
	public CustomerApplicationDetails getCustomerApplicationById(String applicationId) throws NoDataFoundException {
		CustomerApplicationDetails response=customerApplicationDetailsRepo.findById(applicationId).orElse(null);
		if(response==null) {
			throw new NoDataFoundException("No Data Found or invalid credentials");
		}
		return response;
	}
	
	
	
	
	
	
	
	// Grade 1
	
	
	
	
	
	
	
	//Grade 2
	
	public CustomerApplicationDetails registerCustomer( CustomerApplicationDetails applicationDetails) {
		String password=passwordGenerator.generatePassword(8);
		applicationDetails.setPassword(password);
		long id=customerApplicationIdService.getApplicationId();
		applicationDetails.setApplicationId(Long.toString(id));
		return customerApplicationDetailsRepo.save(applicationDetails);
	}
	
}
