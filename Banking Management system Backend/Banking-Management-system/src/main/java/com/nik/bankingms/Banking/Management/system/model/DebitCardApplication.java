package com.nik.bankingms.Banking.Management.system.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DebitCardApplication {
	@Id
	private String applicationId;
	private Date applicationDate;
	private String accountNo;
	private String cardHolderName;
	private String landMark; //present address
	private String street;
	private String state;
	private String city;
	private String pincode;
	private String status;
	private String remark;
}
