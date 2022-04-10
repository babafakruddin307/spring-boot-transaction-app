package com.tran.app.controller;


import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tran.app.model.Account;
import com.tran.app.model.AccountTran;
import com.tran.app.service.TransactionService;

@RestController
public class AccountController {

	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/save")
	public Account saveAccount(@RequestBody Account account) {
		transactionService.saveAccountTran(account);
		return account;
	}
	
	@GetMapping("/account/{id}")
	public Account getAccount(@PathVariable long id) {
		Account account=transactionService.getAccountdetails(id);
		return account;
	}
	
	@PostMapping("/transaction")
	public Account savetransaction(@RequestBody AccountTran accountTran) {
		Account accountfrom=transactionService.getAccountdetails(accountTran.getAccountFrom());
		
		Account account=transactionService.getAccountdetails(accountTran.getAccountNumber());
		
		System.out.println(account);
		System.out.println(accountfrom);
		accountfrom.setAccountNumber(accountTran.getAccountFrom());
		accountfrom.setAmount(accountfrom.getAmount()-accountTran.getAmount());
		accountfrom.setCurrency(accountTran.getCurrency());
		accountfrom.setType(accountTran.getType());
		 
		 transactionService.updateAccountTran(accountfrom);
		 
		 
		 
		 account.setAccountNumber(accountTran.getAccountNumber());
		 account.setAmount(account.getAmount()+accountTran.getAmount());
		 account.setCurrency(accountTran.getCurrency());
		 account.setType(accountTran.getType());
		 
		 transactionService.updateAccountTran(account);
		 
		 
		return account;
	}
	
}
