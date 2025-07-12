package com.nik.bankingms.Banking.Management.system.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nik.bankingms.Banking.Management.system.exception.NoDataFoundException;
import com.nik.bankingms.Banking.Management.system.model.DebitCardApplication;
import com.nik.bankingms.Banking.Management.system.repository.CustomerDetailsRepo;
import com.nik.bankingms.Banking.Management.system.repository.DebitCardApplicationRepo;
@Service
public class DebitCardApplicationService {
	@Autowired
	DebitCardApplicationRepo debitCardApplicationRepo;
	@Autowired
	CustomerDetailsRepo customerDetailsRepo;
	@Autowired
	CustomerApplicationIdService customerApplicationIdService;
	public DebitCardApplication debitCardRequest(DebitCardApplication debitCardApplicationRequest) throws NoDataFoundException {
		
			String accountNo=debitCardApplicationRequest.getAccountNo();
			if(customerDetailsRepo.findByAccountNo(accountNo)==null) {
				throw new NoDataFoundException(accountNo+" does not exist");
			}
			long applicationId=customerApplicationIdService.getApplicationId();
			debitCardApplicationRequest.setApplicationId(Long.toString(applicationId));
			debitCardApplicationRequest.setApplicationDate(Date.valueOf(LocalDate.now()));
			debitCardApplicationRequest.setStatus("Pending");
			debitCardApplicationRequest.setRemark("Application is Under Process");
			return debitCardApplicationRepo.save(debitCardApplicationRequest);
		
		
	}
}
