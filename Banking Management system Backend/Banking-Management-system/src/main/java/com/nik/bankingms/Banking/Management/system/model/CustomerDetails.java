package com.nik.bankingms.Banking.Management.system.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerDetails {
	@Id
	private String customerId;
	private String accountNo;
	private String branchCode;
	private String aadharNo;
	private String panNo;
	private String firstName;
    private String middleName;
    private String lastName;
	private java.sql.Date dob;
	private double amount;
	private String accountType;
	private String gender;
	private String mobileNo;
	private String email;
	private String status;
	
	private String landMark;
	private String street;
	private String State;
	private String city;
	private String pincode;
	
	private String kyc;
}
