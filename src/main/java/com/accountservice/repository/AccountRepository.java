package com.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accountservice.Entity.Account;


public interface AccountRepository  extends JpaRepository<Account, Integer>{

	
	Account findByAccountNumber(int accountNo);

	Account findByaccountHolderName(String accountHolderName);
}
