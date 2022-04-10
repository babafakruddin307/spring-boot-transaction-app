package com.tran.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Account {
	@Id
	private long AccountNumber;
	private String Type;
	private float Amount;
	private String currency;

}
