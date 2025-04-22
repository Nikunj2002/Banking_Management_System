package com.nik.bankingms.Banking.Management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nik.bankingms.Banking.Management.system.model.LoginEmployee;
import com.nik.bankingms.Banking.Management.system.response.ApiResponse;
import com.nik.bankingms.Banking.Management.system.service.LoginEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	LoginEmployeeService loginEmployeeService;
	@GetMapping("/login-employee")
	public ResponseEntity<ApiResponse<LoginEmployee>> loginEmployee(@RequestBody LoginEmployee requestLoginEmployee) {
		try {
			LoginEmployee loginEmployee= loginEmployeeService.validateLoginDetails(requestLoginEmployee);
			ApiResponse<LoginEmployee> response=new ApiResponse<>("Success","Login Successfully",loginEmployee);
			return ResponseEntity.ok(response);
		}catch(Exception e) {
			ApiResponse<LoginEmployee>response=new ApiResponse<>("failure",e.getMessage(),null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
}
