package com.tran.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tran.app.model.Account;
import com.tran.app.repo.AccountTranRepository;

@Service
public class TransactionService {

	@Autowired
	AccountTranRepository repository;
	
	public Account getAccountdetails(long id) {
		return repository.findById(id).get();
	}
	
	@Transactional
	public void saveAccountTran(Account accountTrans) {
		repository.save(accountTrans);
	}
	
	@Transactional
	public void updateAccountTran(Account accountTrans) {
		repository.save(accountTrans);
	}

}
