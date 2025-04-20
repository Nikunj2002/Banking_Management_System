package com.nik.bankingms.Banking.Management.system.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Pan {
	@Id
	private String panNo;
	private String firstName;
    private String middleName;
    private String lastName;
	private java.sql.Date dob;
	private String gender;
}
