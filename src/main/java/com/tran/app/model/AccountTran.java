package com.tran.app.model;

import lombok.Data;

@Data
public class AccountTran {

	private long AccountNumber;
	private String Type;
	private float Amount;
	private String currency;
	private long AccountFrom;
}
