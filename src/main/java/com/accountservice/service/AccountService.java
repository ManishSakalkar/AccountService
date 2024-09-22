package com.accountservice.service;

import java.util.Optional;

import com.accountservice.Entity.Account;

public interface AccountService {
		
	public Object createAccount(Account account);
	
	Optional<Account> getAccountById(Integer accountId);
	
	Account getAccountByaccountHolderName(String accountHolderName);
	
	public Iterable<Account> getAllAccount();
	
	public String updateAccount ( Account account);
	
	public String deleteAccountById(Integer accountId);
	
	Account getAccountBalanceByAccountNumber(int accountNumber);
}
