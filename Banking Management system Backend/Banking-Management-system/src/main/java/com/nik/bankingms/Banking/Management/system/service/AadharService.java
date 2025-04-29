package com.nik.bankingms.Banking.Management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nik.bankingms.Banking.Management.system.exception.AadharMisMatchException;
import com.nik.bankingms.Banking.Management.system.model.Aadhar;
import com.nik.bankingms.Banking.Management.system.repository.AadharRepo;

@Service
public class AadharService {
	@Autowired
	AadharRepo aadharRepo;
	public boolean validate(Aadhar requestAadhar) {
		Aadhar dbAadhar = aadharRepo.findByAadharNo(requestAadhar.getAadharNo());
		  // Check if no Aadhar record is found
	    if (dbAadhar == null) {
	        System.out.println("No Aadhar found for: " + requestAadhar.getAadharNo());
	        return false;
	    }

	    // Manually check each field to compare
	    if (dbAadhar.getAadharNo() == null || !dbAadhar.getAadharNo().equals(requestAadhar.getAadharNo())) {
	        System.out.println("AadharNo mismatch");
	        return false;
	    }
	    if (dbAadhar.getFirstName() == null || !dbAadhar.getFirstName().equals(requestAadhar.getFirstName())) {
	        System.out.println("First Name mismatch");
	        return false;
	    }
	    if (dbAadhar.getMiddleName() == null || !dbAadhar.getMiddleName().equals(requestAadhar.getMiddleName())) {
	        System.out.println("Middle Name mismatch");
	        return false;
	    }
	    if (dbAadhar.getLastName() == null || !dbAadhar.getLastName().equals(requestAadhar.getLastName())) {
	        System.out.println("Last Name mismatch");
	        return false;
	    }
	    if (dbAadhar.getMobileNo() == null || !dbAadhar.getMobileNo().equals(requestAadhar.getMobileNo())) {
	        System.out.println("Mobile Number mismatch");
	        return false;
	    }
	    if (dbAadhar.getDob() == null || !dbAadhar.getDob().equals(requestAadhar.getDob())) {
	        System.out.println("Date of Birth mismatch");
	        return false;
	    }
	    if (dbAadhar.getGender() == null || !dbAadhar.getGender().equals(requestAadhar.getGender())) {
	        System.out.println("Gender mismatch");
	        return false;
	    }
	    if (dbAadhar.getLandMark() == null || !dbAadhar.getLandMark().equals(requestAadhar.getLandMark())) {
	        System.out.println("Landmark mismatch");
	        return false;
	    }
	    if (dbAadhar.getStreet() == null || !dbAadhar.getStreet().equals(requestAadhar.getStreet())) {
	        System.out.println("Street mismatch");
	        return false;
	    }
	    if (dbAadhar.getState() == null || !dbAadhar.getState().equals(requestAadhar.getState())) {
	        System.out.println("State mismatch");
	        return false;
	    }
	    if (dbAadhar.getCity() == null || !dbAadhar.getCity().equals(requestAadhar.getCity())) {
	        System.out.println("City mismatch");
	        return false;
	    }
	    if (dbAadhar.getPincode() == null || !dbAadhar.getPincode().equals(requestAadhar.getPincode())) {
	        System.out.println("Pincode mismatch");
	        return false;
	    }

	    // If all fields match, return true
	    return true;
	}
	public Aadhar getAadharData(String aadharNo) throws AadharMisMatchException {
		Aadhar aadhar = aadharRepo.findByAadharNo(aadharNo);
		if(aadhar==null) {
			throw new AadharMisMatchException("Invalid aadhar number");
		}
		return aadhar;
	}
	public Aadhar inserAadhar(Aadhar requestAadhar) {
		return aadharRepo.save(requestAadhar);
	}
}
