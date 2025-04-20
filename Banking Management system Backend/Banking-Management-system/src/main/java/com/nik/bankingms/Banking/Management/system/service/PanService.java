package com.nik.bankingms.Banking.Management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nik.bankingms.Banking.Management.system.model.Pan;
import com.nik.bankingms.Banking.Management.system.repository.PanRepo;

@Service
public class PanService {
	@Autowired
	PanRepo panRepo;
	public boolean validate(Pan requestPan) {
		Pan dbPan=panRepo.findByPanNo(requestPan.getPanNo());
		if(dbPan==null) {
			System.out.println("No Pan found for: " + requestPan.getPanNo());
	        return false;
		}
		if (dbPan.getPanNo() == null || !dbPan.getPanNo().equals(requestPan.getPanNo())) {
	        System.out.println("AadharNo mismatch");
	        return false;
	    }
	    if (dbPan.getFirstName() == null || !dbPan.getFirstName().equals(requestPan.getFirstName())) {
	        System.out.println("First Name mismatch");
	        return false;
	    }
	    if (dbPan.getMiddleName() == null || !dbPan.getMiddleName().equals(requestPan.getMiddleName())) {
	        System.out.println("Middle Name mismatch");
	        return false;
	    }
	    if (dbPan.getLastName() == null || !dbPan.getLastName().equals(requestPan.getLastName())) {
	        System.out.println("Last Name mismatch");
	        return false;
	    }
	    if (dbPan.getDob() == null || !dbPan.getDob().equals(requestPan.getDob())) {
	        System.out.println("Date of Birth mismatch");
	        return false;
	    }
	    if (dbPan.getGender() == null || !dbPan.getGender().equals(requestPan.getGender())) {
	        System.out.println("Gender mismatch");
	        return false;
	    }
	    return true;
	}
	public Pan insertPan(Pan requestPan) {
		return panRepo.save(requestPan);
	}
}
