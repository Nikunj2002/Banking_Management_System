package com.nik.bankingms.Banking.Management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.nik.bankingms.Banking.Management.system.model.Employee;
import com.nik.bankingms.Banking.Management.system.repository.AadharRepo;
import com.nik.bankingms.Banking.Management.system.repository.EmployeeRepo;
import com.nik.bankingms.Banking.Management.system.repository.PanRepo;
import com.nik.bankingms.Banking.Management.system.response.ApiResponse;

@Service
public class AdminService {
//	@PostMapping("/add-customer")
//	public ResponseEntity<ApiResponse<Customer>> addCustomer(@RequestBody CustomerRequest request) {
//	    try {
//	        Customer customer = customerService.createCustomer(request);
//	        ApiResponse<Customer> response = new ApiResponse<>("success", "Customer created successfully", customer);
//	        return ResponseEntity.ok(response);
//	    } catch (Exception e) {
//	        ApiResponse<Customer> response = new ApiResponse<>("error", "Failed to create customer: " + e.getMessage(), null);
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//	    }
//	}

	@Autowired
	EmployeeRepo employeeRepo;
	public Employee registerEmployee(Employee requestEmployee){
		return employeeRepo.save(requestEmployee);
	}
	
//	public ResponseEntity<ApiResponse<Employee>> registerEmployee(@RequestBody Employee requestEmployee){
//		try {
//			
//		}
//	}
}
