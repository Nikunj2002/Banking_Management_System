package com.nik.bankingms.Banking.Management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nik.bankingms.Banking.Management.system.model.EmployeeHelper;
import com.nik.bankingms.Banking.Management.system.repository.EmployeeHelperRepo;

@Service
public class EmployeeHelperService {
	@Autowired
	EmployeeHelperRepo employeeHelperRepo;
	public EmployeeHelper getBasicEmployee() {
		EmployeeHelper employeeHelper= employeeHelperRepo.findAll().get(0); //this will send the employee id and employee username auto generation use
		EmployeeHelper temp=employeeHelper;
		temp.setEmployeeId(employeeHelper.getEmployeeId()+1);
		employeeHelperRepo.save(temp);
		
		return employeeHelper;
	}
}
