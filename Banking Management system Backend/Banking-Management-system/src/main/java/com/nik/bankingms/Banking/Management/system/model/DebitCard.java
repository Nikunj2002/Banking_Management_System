package com.nik.bankingms.Banking.Management.system.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DebitCard {
	@Id
	private String accountNo;
	private String cardHolderName;
    private String cardNo;
    private int cvv;
    private Date validFrom;
    private Date validTo;
    private String cardType; //mastercard ,visa,rupee
    private double limit;
}
