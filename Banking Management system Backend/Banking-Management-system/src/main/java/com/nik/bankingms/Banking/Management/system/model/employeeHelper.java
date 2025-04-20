package com.nik.bankingms.Banking.Management.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class employeeHelper {
	@Id
	String employeeId;
	String userName;
}
