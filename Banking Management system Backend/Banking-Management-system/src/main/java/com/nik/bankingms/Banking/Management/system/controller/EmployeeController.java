package com.nik.bankingms.Banking.Management.system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nik.bankingms.Banking.Management.system.model.CustomerApplicationDetails;
import com.nik.bankingms.Banking.Management.system.model.CustomerDetails;
import com.nik.bankingms.Banking.Management.system.model.DebitCardApplication;
import com.nik.bankingms.Banking.Management.system.model.LoginEmployee;
import com.nik.bankingms.Banking.Management.system.response.ApiResponse;
import com.nik.bankingms.Banking.Management.system.service.EmployeeService;
import com.nik.bankingms.Banking.Management.system.service.LoginEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	LoginEmployeeService loginEmployeeService;
	@Autowired
	EmployeeService employeeService;
	
	
	//common for employee and customer
	
	//Apply for debit card
	
	@PostMapping("/debitCard-request")
	public ResponseEntity<ApiResponse<DebitCardApplication>> debitCardRequest(@RequestBody DebitCardApplication debitCardApplicationRequest) {
		try {
			DebitCardApplication debitCardApplication=employeeService.debitCardRequest(debitCardApplicationRequest);
			ApiResponse<DebitCardApplication> response=new ApiResponse<>("Success","Application Submitted Successfully",debitCardApplication);
			return ResponseEntity.ok(response);
		}
		catch(Exception e) {
			ApiResponse<DebitCardApplication> response=new ApiResponse<>("failure",e.getMessage(),null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	
	
	
	
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
	
	// both 
	@GetMapping("/get-all-customer-applications")
	public ResponseEntity<ApiResponse<List<CustomerApplicationDetails>>> getAllCustomerApplication(){
		try {
			List<CustomerApplicationDetails> customerApplicationDetails= employeeService.getAllCustomerApplication();
			ApiResponse<List<CustomerApplicationDetails>> response=new ApiResponse<>("Success","Customer Application data fetch successfully",customerApplicationDetails);
			return ResponseEntity.ok(response);
		}catch(Exception e) {
			ApiResponse<List<CustomerApplicationDetails>>response=new ApiResponse<>("failure",e.getMessage(),null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	@GetMapping("/get-customer-application-of-{id}")
	public ResponseEntity<ApiResponse<CustomerApplicationDetails>> getCustomerApplicationById(@PathVariable String id){
		try {
			CustomerApplicationDetails customerApplicationDetails=employeeService.getCustomerApplicationById(id);
			ApiResponse<CustomerApplicationDetails>response=new ApiResponse<>("Success","Customer Application with "+"id"+" fetch successfully",customerApplicationDetails);
			return ResponseEntity.ok(response);
		}
		catch(Exception e) {
			ApiResponse<CustomerApplicationDetails>response=new ApiResponse<>("failure",e.getMessage(),null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	//
	@GetMapping("/getCustomerDetails-{accountNo}")
	public ResponseEntity<ApiResponse<CustomerDetails>> getCustomerDetails(@PathVariable String accountNo){
		try {
			CustomerDetails customerDetails=employeeService.getCustomerDetails(accountNo);
			ApiResponse<CustomerDetails> response=new ApiResponse<>("Success","Customer details fetched successfully",customerDetails);
			return ResponseEntity.ok(response);
		}
		catch(Exception e) {
			ApiResponse<CustomerDetails>response=new ApiResponse<>("failure",e.getMessage(),null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	
	//casher
	@PutMapping("/cash-deposite-{accountNo}")
	public ResponseEntity<ApiResponse<String>> cashDeposite(@PathVariable String accountNo, @RequestBody Map<String, Double> request){
		try {
			String depositeStatus=employeeService.cashDeposite(accountNo,request.get("amount"));
			ApiResponse<String> response=new ApiResponse<>("Success","Deposite carried successfully",depositeStatus);
			return ResponseEntity.ok(response);
		}
		catch(Exception e) {
			ApiResponse<String>response=new ApiResponse<>("failure",e.getMessage(),"failure");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	@PutMapping("/cash-withdrawl-{accountNo}")
	public ResponseEntity<ApiResponse<String>> cashWithdrawl(@PathVariable String accountNo, @RequestBody Map<String, Double> request){
		try {
			String withdrawlStatus=employeeService.cashWithdrawl(accountNo, request.get("amount"));
			ApiResponse<String> response=new ApiResponse<>("Success","Withdrawl carried successfully",withdrawlStatus);
			return ResponseEntity.ok(response);
		}
		catch (Exception e) {
			ApiResponse<String> response=new ApiResponse<>("failure",e.getMessage(),"failure");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	//Grade 1
	
	@PostMapping("/validate-customer-{applicantId}")
	public ResponseEntity<ApiResponse<CustomerDetails>> validateCustomer(@PathVariable String applicantId){
		try {
			CustomerDetails customerDetails=employeeService.validateCustomer(applicantId);
			ApiResponse<CustomerDetails>response=new ApiResponse<>("Success","Account created Successfully",customerDetails);
			return ResponseEntity.ok(response);
		}
		catch(Exception e) {
			ApiResponse<CustomerDetails>response=new ApiResponse<>("failure",e.getMessage(),null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
	
	
	
	
	
	
	//Grade 2
	@PostMapping("/register-customer")
	public ResponseEntity<ApiResponse<CustomerApplicationDetails>> registerCustomer(@RequestBody CustomerApplicationDetails applicationDetails) {
		try {
			CustomerApplicationDetails customerApplicationDetails=employeeService.registerCustomer(applicationDetails);
			ApiResponse<CustomerApplicationDetails> response=new ApiResponse<>("Success","Application Created",customerApplicationDetails);
			return ResponseEntity.ok(response);
		}
		catch(Exception e) {
			ApiResponse<CustomerApplicationDetails> response=new ApiResponse<>("failure",e.getMessage(),null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}
}
