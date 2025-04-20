package com.nik.bankingms.Banking.Management.system.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Aadhar {
	@Id
	private String aadharNo;
	private String firstName;
    private String middleName;
    private String lastName;
    private String mobileNo;
	private java.sql.Date dob;
	private String gender;
	private String landMark;
	private String street;
	private String State;
	private String city;
	private String pincode;
}
