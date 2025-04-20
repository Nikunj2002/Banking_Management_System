package com.nik.bankingms.Banking.Management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nik.bankingms.Banking.Management.system.model.Aadhar;

@Repository
public interface AadharRepo extends JpaRepository<Aadhar, String>{
	Aadhar findByAadharNo(String aadharNo);
}
