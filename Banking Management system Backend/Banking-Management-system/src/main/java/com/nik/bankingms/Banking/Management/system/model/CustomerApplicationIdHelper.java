package com.nik.bankingms.Banking.Management.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class CustomerApplicationIdHelper {
	@Id
	private Long id = 1L; 
	private long applicationId;
}
