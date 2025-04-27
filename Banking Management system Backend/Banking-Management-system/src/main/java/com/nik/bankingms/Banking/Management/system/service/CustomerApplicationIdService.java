package com.nik.bankingms.Banking.Management.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nik.bankingms.Banking.Management.system.model.CustomerApplicationIdHelper;
import com.nik.bankingms.Banking.Management.system.repository.CustomerApplicationIdHelperRepo;

@Service
public class CustomerApplicationIdService {
	@Autowired
	CustomerApplicationIdHelperRepo applicationIdHelperRepo;
	public long getApplicationId() {
		CustomerApplicationIdHelper applicationIdHelper=applicationIdHelperRepo.findAll().get(0);
		CustomerApplicationIdHelper temp=applicationIdHelper;
		temp.setApplicationId(applicationIdHelper.getApplicationId()+1);
		applicationIdHelperRepo.save(temp);
		return applicationIdHelper.getApplicationId();
	}
}
