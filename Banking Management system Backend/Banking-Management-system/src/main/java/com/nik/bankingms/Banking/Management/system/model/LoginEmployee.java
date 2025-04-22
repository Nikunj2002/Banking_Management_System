package com.nik.bankingms.Banking.Management.system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "login_employees")
public class LoginEmployee {
    @Id
    private String employeeId;
    private String password;
    @Column(name = "employee_rank")
    private String rank;
    private String status;
}