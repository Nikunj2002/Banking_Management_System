package com.nik.bankingms.Banking.Management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nik.bankingms.Banking.Management.system.model.CustomerDetails;

public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails, String>{

}
