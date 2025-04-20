package com.nik.bankingms.Banking.Management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nik.bankingms.Banking.Management.system.model.LoginEmployee;

public interface LoginEmployeeRepo extends JpaRepository<LoginEmployee, String> {

}
