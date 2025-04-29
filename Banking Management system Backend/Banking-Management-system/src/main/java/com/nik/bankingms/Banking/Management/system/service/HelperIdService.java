package com.nik.bankingms.Banking.Management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nik.bankingms.Banking.Management.system.exception.NoDataFoundException;
import com.nik.bankingms.Banking.Management.system.model.HelperId;
import com.nik.bankingms.Banking.Management.system.repository.HelperIdRepo;

@Service
public class HelperIdService {
	@Autowired
	HelperIdRepo helperIdRepo;
	public HelperId getHelperIdDetais(String branchCode) throws NoDataFoundException {
		HelperId helperId= helperIdRepo.findById(branchCode).orElse(null);
		if(helperId==null) {
			throw new NoDataFoundException("No Branch Found");
		}
		return helperId;
	}
	public void updateHelperIdDetails(HelperId helperId) {
		helperIdRepo.save(helperId);
	}
}
