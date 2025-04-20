package com.nik.bankingms.Banking.Management.system.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    private String id;
    private String userName;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private java.sql.Date dob;
    private String gender;
    private String post;
    private String status;
    private String mobile;
    private String email;
    private String aadharNo;
    private String panNo;
    private String branchCode;
}
