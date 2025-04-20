package com.nik.bankingms.Banking.Management.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class HelperId {
	@Id
	String branchCode;
	String accountNo;
	String debitCardNo;
	String creditCardNo;
	
}
