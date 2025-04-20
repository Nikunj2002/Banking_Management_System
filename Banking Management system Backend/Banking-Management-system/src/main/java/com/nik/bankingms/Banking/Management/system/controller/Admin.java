package com.nik.bankingms.Banking.Management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nik.bankingms.Banking.Management.system.exception.AadharMisMatchException;
import com.nik.bankingms.Banking.Management.system.model.Aadhar;
import com.nik.bankingms.Banking.Management.system.model.Employee;
import com.nik.bankingms.Banking.Management.system.model.Pan;
import com.nik.bankingms.Banking.Management.system.repository.AadharRepo;
import com.nik.bankingms.Banking.Management.system.response.ApiResponse;
import com.nik.bankingms.Banking.Management.system.service.AadharService;
import com.nik.bankingms.Banking.Management.system.service.AdminService;
import com.nik.bankingms.Banking.Management.system.service.PanService;

@RestController
public class Admin {
	
	
	
	
	@Autowired
	AadharService aadharService;
	
	@Autowired
	PanService panService;
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/aadhar")
	public boolean getAadhar(@RequestBody Aadhar req) {
		System.out.println("Comming");
		return aadharService.validate(req);
	}
	@PutMapping("/putAadhar")
	public Aadhar insertAadhar(@RequestBody Aadhar req) {
		return aadharService.inserAadhar(req);
	}
	
	@PostMapping("/pan")
	public boolean getPan(@RequestBody Pan req) {
		return panService.validate(req);
	}
	
	@PutMapping("/putPan")
	public Pan insertPan(@RequestBody Pan req) {
		return panService.insertPan(req);
	}
	
	
	
	
	//check
	
	@PostMapping("/register-employee")
	public ResponseEntity<ApiResponse<Employee>> registerEmployee(@RequestBody Employee request) {
	    try {
	        Employee employee = adminService.registerEmployee(request);
	        ApiResponse<Employee> response = new ApiResponse<>("success", "Employee data has been inserted successfully", employee);
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        ApiResponse<Employee> response = new ApiResponse<>("failure", e.getMessage(), null);
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    }
	}

	
	
	
	//check
	
	
	
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

//	@PostMapping("/register-employee")
//	public ResponseEntity<ApiResponse<Employee>> registerEmployee(@RequestBody Employee request){
//		return 
//	}
}
