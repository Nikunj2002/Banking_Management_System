package com.nik.bankingms.Banking.Management.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nik.bankingms.Banking.Management.system.exception.AadharMisMatchException;
import com.nik.bankingms.Banking.Management.system.exception.InvalidNumberException;
import com.nik.bankingms.Banking.Management.system.exception.NoDataFoundException;
import com.nik.bankingms.Banking.Management.system.helper.PasswordGenerator;
import com.nik.bankingms.Banking.Management.system.model.Aadhar;
import com.nik.bankingms.Banking.Management.system.model.CustomerApplicationDetails;
import com.nik.bankingms.Banking.Management.system.model.CustomerDetails;
import com.nik.bankingms.Banking.Management.system.model.DebitCardApplication;
import com.nik.bankingms.Banking.Management.system.model.HelperId;
import com.nik.bankingms.Banking.Management.system.repository.AadharRepo;
import com.nik.bankingms.Banking.Management.system.repository.CustomerApplicationDetailsRepo;
import com.nik.bankingms.Banking.Management.system.repository.CustomerDetailsRepo;
import com.nik.bankingms.Banking.Management.system.repository.EmployeeRepo;
import com.nik.bankingms.Banking.Management.system.repository.HelperIdRepo;
import com.nik.bankingms.Banking.Management.system.repository.PanRepo;

@Service
public class EmployeeService {
	
	@Autowired
	CustomerApplicationDetailsRepo customerApplicationDetailsRepo;

	@Autowired
	PasswordGenerator passwordGenerator;
	@Autowired
	CustomerApplicationIdService customerApplicationIdService;
	@Autowired
	CustomerDetailsRepo customerDetailsRepo;
	@Autowired
	HelperIdService helperIdService;
	@Autowired
	AadharService aadharService;
	@Autowired
	DebitCardApplicationService debitCardApplicationService;
	
	//common for employee and customer
	
	//Apply for debit card
	public DebitCardApplication debitCardRequest(DebitCardApplication debitCardApplicationRequest) throws NoDataFoundException {
		return debitCardApplicationService.debitCardRequest(debitCardApplicationRequest);
	}
	
	
	
	
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
	
	public CustomerDetails getCustomerDetails(String accountNo) throws NoDataFoundException {
		CustomerDetails response=customerDetailsRepo.findByAccountNo(accountNo);
		if(response==null || response.getStatus().equalsIgnoreCase("Inactive")) {
			throw new NoDataFoundException("No customer found with given accountNo");
		}
		
		return response;
	}
	
	//casher
	public String cashDeposite(String accountNo,double amount) throws NoDataFoundException , Exception{
		if(amount<0) {
			throw new InvalidNumberException("Amount cannot be less then Zero");
		}
		CustomerDetails customerDetails=this.getCustomerDetails(accountNo);
		double databaseAmount=customerDetails.getAmount();
		double updatedAmount=databaseAmount+amount;
		customerDetails.setAmount(updatedAmount);
		customerDetailsRepo.save(customerDetails);
		return "Success";
	}
	public String cashWithdrawl(String accountNo,double amount) throws Exception {
		if(amount<0) {
			throw new InvalidNumberException("Amount cannot be less then Zero");
		}
		CustomerDetails customerDetails=this.getCustomerDetails(accountNo);
		double databaseAmount=customerDetails.getAmount();
		if(databaseAmount<amount) {
			throw new Exception("Insufficient Amount");
		}
		double updatedAmount=databaseAmount-amount;
		customerDetails.setAmount(updatedAmount);
		customerDetailsRepo.save(customerDetails);
		return "Success";
	}
	
	
	
	
	// Grade 1
	
	public CustomerDetails validateCustomer(String applicationId) throws NoDataFoundException, AadharMisMatchException {
		CustomerApplicationDetails applicationDetails= this.getCustomerApplicationById(applicationId);
		System.out.println(applicationDetails.getStatus());
		if(!applicationDetails.getStatus().equalsIgnoreCase("Pending")) {
			throw new NoDataFoundException("Application ID "+applicationId+" hasbeen already approved or rejected");
		}
		CustomerDetails response=new CustomerDetails();
		HelperId helperIdDetails=helperIdService.getHelperIdDetais(applicationDetails.getBranchCode());
		response.setCustomerId(helperIdDetails.getCustomerId());
		response.setAccountNo(helperIdDetails.getAccountNo());
		response.setBranchCode(helperIdDetails.getBranchCode());
		response.setAadharNo(applicationDetails.getAadharNo());
		response.setPanNo(applicationDetails.getPanNo());
		response.setFirstName(applicationDetails.getFirstName());
		response.setMiddleName(applicationDetails.getMiddleName());
		response.setLastName(applicationDetails.getLastName());
		response.setDob(applicationDetails.getDob());
		response.setAmount(applicationDetails.getAmount());
		response.setAccountType(applicationDetails.getAccountType());
		response.setGender(applicationDetails.getGender());
		response.setEmail(applicationDetails.getEmail());
		response.setStatus("Active");
		response.setKyc("Done");
		Aadhar aadhar=aadharService.getAadharData(applicationDetails.getAadharNo());
		response.setLandMark(aadhar.getLandMark());
		response.setStreet(aadhar.getStreet());
		response.setState(aadhar.getState());
		response.setCity(aadhar.getCity());
		response.setPincode(aadhar.getPincode());
		response.setMobileNo(aadhar.getMobileNo());
		customerDetailsRepo.save(response); // entering customer in main customer table
		applicationDetails.setStatus("Approved");
		applicationDetails.setRemark("Application has been approved successfully");
		helperIdDetails.setCustomerId(String.valueOf(Long.parseLong(helperIdDetails.getCustomerId())+1));
		helperIdDetails.setAccountNo(String.valueOf(Long.parseLong(helperIdDetails.getAccountNo())+1));
		helperIdService.updateHelperIdDetails(helperIdDetails);
		return response;
	}


	

	
	
	
	//Grade 2
	
	public CustomerApplicationDetails registerCustomer( CustomerApplicationDetails applicationDetails) {
		String password=passwordGenerator.generatePassword(8);
		applicationDetails.setPassword(password);
		long id=customerApplicationIdService.getApplicationId();
		applicationDetails.setApplicationId(Long.toString(id));
		return customerApplicationDetailsRepo.save(applicationDetails);
	}
	
}
