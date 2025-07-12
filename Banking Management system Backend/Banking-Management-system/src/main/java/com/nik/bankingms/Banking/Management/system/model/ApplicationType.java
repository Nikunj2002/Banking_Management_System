package com.nik.bankingms.Banking.Management.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ApplicationType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int typeId;
	String type;
}
