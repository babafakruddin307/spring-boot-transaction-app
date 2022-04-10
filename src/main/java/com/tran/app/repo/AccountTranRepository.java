package com.tran.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tran.app.model.Account;

public interface AccountTranRepository extends JpaRepository<Account,Long>{

}
