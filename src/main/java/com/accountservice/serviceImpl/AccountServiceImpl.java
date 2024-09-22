package com.accountservice.serviceImpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountservice.Entity.Account;
import com.accountservice.repository.AccountRepository;
import com.accountservice.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;
	
	
	
	@Override
	public Object createAccount(Account account) {
		
		//For Account Number Creation
		int generatedAccountNumber = generateUniqueAccountNumber();
        account.setaccountNumber(generatedAccountNumber);
		
        //For IFSC Code Generated
        account.setiFSCCode("SBIN001008901");
        
        //For Account Balance
        account.setCurrentBalance(500);
        
		accountRepo.save(account);
		return "Account Create Successfully";
	}
	
    private int generateUniqueAccountNumber() {
    	
    	String startNo = "8900";
    	
    	int randomNumber = generateRandomNumber(10000, 99999);
    	
    	String  newAccountNo = startNo + randomNumber;
        
    	int accountNo = Integer.parseInt(newAccountNo);
    	
    	 Account existingAccount = accountRepo.findByAccountNumber(accountNo);
    	
    	 if (existingAccount != null) {
    	        return generateUniqueAccountNumber();
    	    }
        return accountNo;
    }
    
    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
	@Override
	public Optional<Account> getAccountById(Integer accountId) {
		return accountRepo.findById(accountId);
	}

	@Override
	public Iterable<Account> getAllAccount() {
		Iterable<Account> allaccount = accountRepo.findAll();
		return allaccount;
	}

	@Override
	public String updateAccount( Account account) {
		Optional<Account> opt = accountRepo.findById(account.getAccountid());
		if(opt.isPresent()) {
			
			
			Account temp = opt.get();
			
			temp.setAccountHolderName(account.getAccountHolderName());
			temp.setAddress(account.getAddress());
			temp.setCurrentBalance(account.getCurrentBalance());
			temp.setiFSCCode(account.getiFSCCode());
			temp.setMobileNumber(account.getMobileNumber());
			
			accountRepo.save(temp);
			
			return "Account Updated Successfully";
		}else {
		return "Account Not Found";
		}
	}

	@Override
	public String deleteAccountById(Integer accountId) {
		Optional<Account> opt = accountRepo.findById(accountId);
		if(opt.isPresent()) {
			Account acc = opt.get();
			accountRepo.delete(acc);
			return "Account is Deleted";
		}
		else {
			return "Account Not Found";
		}
		
	}

	@Override
	public Account getAccountBalanceByAccountNumber(int accountNumber) {
		return accountRepo.findByAccountNumber(accountNumber);
	}

	@Override
	public Account getAccountByaccountHolderName(String accountHolderName) {
		return accountRepo.findByaccountHolderName(accountHolderName);
	}

}
