package com.nik.bankingms.Banking.Management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nik.bankingms.Banking.Management.system.model.Pan;

@Repository
public interface PanRepo extends JpaRepository<Pan, String>{
	Pan findByPanNo(String panNo);
}
