package com.nik.bankingms.Banking.Management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nik.bankingms.Banking.Management.system.model.EmployeeHelper;
@Repository
public interface EmployeeHelperRepo extends JpaRepository<EmployeeHelper, String>{

}
