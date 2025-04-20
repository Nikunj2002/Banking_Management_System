package com.nik.bankingms.Banking.Management.system.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class CustomerApplicationDetails {
	@Id
	private String userId;
	private String password;
	private String branchCode;
	private String aadharNo;
	private String panNo;
	private String firstName;
    private String middleName;
    private String lastName;
	private Date dob;
	private double amount;
	private String accountType;
	private String gender;
	private String mobileNo;
	private String email;
	private String status;
	private String remark;
	private String kyc;
}
