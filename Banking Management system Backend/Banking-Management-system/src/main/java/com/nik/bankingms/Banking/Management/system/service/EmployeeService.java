package com.nik.bankingms.Banking.Management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
