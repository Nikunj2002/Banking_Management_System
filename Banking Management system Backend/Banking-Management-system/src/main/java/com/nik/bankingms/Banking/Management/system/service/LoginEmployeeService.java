package com.nik.bankingms.Banking.Management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nik.bankingms.Banking.Management.system.exception.EmployeeLoginDetailsMismatchException;
import com.nik.bankingms.Banking.Management.system.model.LoginEmployee;
import com.nik.bankingms.Banking.Management.system.repository.LoginEmployeeRepo;

@Service
public class LoginEmployeeService {
	@Autowired
	LoginEmployeeRepo loginEmployeeRepo;
	public void saveLoginDetails(LoginEmployee loginEmployee) {
		loginEmployeeRepo.save(loginEmployee);
	}
	public LoginEmployee validateLoginDetails(LoginEmployee loginEmployee) throws EmployeeLoginDetailsMismatchException {
		if(loginEmployee==null) {
			throw new EmployeeLoginDetailsMismatchException("You Enter the null details");
		}
		LoginEmployee dbLoginEmployee=loginEmployeeRepo.findByEmployeeId(loginEmployee.getEmployeeId());
		if(dbLoginEmployee==null) {
			throw new EmployeeLoginDetailsMismatchException("Invalid Employee Id");
		}
		if(!dbLoginEmployee.getPassword().equals(loginEmployee.getPassword())) {
			throw new EmployeeLoginDetailsMismatchException("Invalid Password");
		}
		if(!dbLoginEmployee.getStatus().equals("Active")) {
			throw new EmployeeLoginDetailsMismatchException("NO Employee Found");
		}
		return dbLoginEmployee;
	}
}
